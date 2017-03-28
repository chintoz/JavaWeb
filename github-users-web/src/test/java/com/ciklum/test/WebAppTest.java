package com.ciklum.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test class to check web application operations
 * @author Jacinto J. Mena Lomeña
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebAppTest {

	@Autowired
	private TestRestTemplate restTemplate;

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
		String body = this.restTemplate.getForObject("/user?userName=" + userName,
				String.class);
		assertThat(body).contains("[" + userName + "] doesn&#39;t exist");
	}

	/**
	 * Test an existing user request with repositories
	 */
	@Test
	public void existingUserRequest() {
		String body = this.restTemplate.getForObject("/user?userName=jjmena", String.class);
		assertThat(body).contains("[jjmena] favourite language/s: Java,JavaScript");
	}

}
