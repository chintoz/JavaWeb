package com.ciklum.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ciklum.service.UserService;

/**
 * Test for UserService
 * @author Jacinto J. Mena Lomeña
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	UserService userService;

	/**
	 * Test to check not existing users
	 */
	@Test
	public void notExistingUser() {

		// Not existing user
		String userName = "ASDASDASDASDASD" + System.currentTimeMillis();

		try {

			// Call with a not existing user
			userService.favouriteLanguages(userName);

			// Fail because do not produce error
			fail("Not existing user must throw an exception");

		} catch (FileNotFoundException fnfe) {
			// Everything OK
		} catch (Exception e) {
			// Fail other exception
			fail("Not existing users must throw FileNotFoundException", e.getCause());
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
