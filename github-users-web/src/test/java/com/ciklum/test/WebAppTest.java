package com.ciklum.test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.WireMockServer;

/**
 * Test class to check web application operations
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
public class WebAppTest {

	@Autowired
	private TestRestTemplate restTemplate;

	private WireMockServer server;

	@Value("${github.user.repos.path}")
	private String path;
	
	@Value("${github.user.repos.port}")
	private String port;

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
	 * Test started WebApp
	 */
	@Test
	public void startWebApp() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).contains("Welcome to GitHub User's Favourite Programming Language");
	}

	/**
	 * Test a not existing user request
	 */
	@Test
	public void notExistingUserRequest() {
		String userName = "ASDASDASDASD" + System.currentTimeMillis();

		String mockPath = "responses/notexisting.json";

		server.stubFor(get(urlEqualTo(path.replace(":user", userName))).willReturn(aResponse().withStatus(404)
				.withHeader("Content-Type", "application/json; charset=utf-8").withBodyFile(mockPath)));

		String body = this.restTemplate.getForObject("/user?userName=" + userName, String.class);
		assertThat(body).contains("[" + userName + "] doesn&#39;t exist");
	}

	/**
	 * Test an existing user request with repositories
	 */
	@Test
	public void existingUserRequest() {

		String userName = "jjmena";

		String mockPath = "responses/jjmena.json";

		server.stubFor(get(urlEqualTo(path.replace(":user", userName))).willReturn(
				aResponse().withStatus(200).withHeader("Content-Type", "application/json;").withBodyFile(mockPath)));

		String body = this.restTemplate.getForObject("/user?userName=" + userName, String.class);
		assertThat(body).contains("[jjmena] favourite language/s: Java,JavaScript");
	}

}
