package com.ciklum.test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.ciklum.service.UserService;
import com.github.tomakehurst.wiremock.WireMockServer;

/**
 * Test for UserService
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Value("${github.user.repos.path}")
	private String path;

	@Value("${github.user.repos.port}")
	private String port;

	private WireMockServer server;

	@Before
	public void init() {

		// Initialize server
		if (server == null) {
			server = new WireMockServer(options().port(Integer.valueOf(port)));
		}

		server.start();
	}

	@After
	public void finish() {
		server.stop();
	}

	/**
	 * Test to check not existing users
	 */
	@Test
	public void notExistingUser() {

		// Not existing user
		String userName = "ASDASDASDASDASD" + System.currentTimeMillis();

		try {

			String mockPath = "responses/notexisting.json";

			server.stubFor(get(urlEqualTo(path.replace(":user", userName))).willReturn(aResponse().withStatus(404)
					.withHeader("Content-Type", "application/json; charset=utf-8").withBodyFile(mockPath)));

			// Call with a not existing user
			userService.favouriteLanguages(userName);

			// Fail because do not produce error
			fail("Not existing user must throw an exception");

		} catch (HttpClientErrorException fnfe) {
			// Everything OK
		} catch (Exception e) {
			// Fail other exception
			fail("Not existing users must throw HttpClientErrorException", e.getCause());
		}
	}

	/**
	 * Test to check an user without repositories
	 */
	@Test
	public void existingUserWithoutRepositories() {

		// existing user without repositories
		String userName = "jjmena8080";

		try {

			String mockPath = "responses/jjmena8080.json";

			server.stubFor(get(urlEqualTo(path.replace(":user", userName))).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withBodyFile(mockPath)));

			// Call with an existing user
			List<String> favouriteLanguages = userService.favouriteLanguages(userName);

			// Check the user hasn't favourite language
			assertThat(favouriteLanguages).isNull();

		} catch (Exception e) {
			// Fail exceptions
			fail("Existing user must not throw exceptions", e.getCause());
		}

	}

	/**
	 * Test to check an user with repositories
	 */
	@Test
	public void existingUserWithRepositories() {
		// existing user
		String userName = "jjmena";

		try {

			String mockPath = "responses/jjmena.json";

			server.stubFor(get(urlEqualTo(path.replace(":user", userName))).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withBodyFile(mockPath)));

			// Call with an existing user
			List<String> favouriteLanguages = userService.favouriteLanguages(userName);

			// Check contains two favourite languages
			assertEquals(2, favouriteLanguages.size());
			assertThat(favouriteLanguages).contains("Java", "JavaScript");

		} catch (Exception e) {
			// Fail exception
			fail("Existing user must not throw exceptions", e.getCause());
		}
	}

}
