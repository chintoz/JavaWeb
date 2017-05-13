package com.ciklum.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;

import com.ciklum.service.UserService;

/**
 * Controller for requests to query GitHub User's favourite language
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	/** Constant for index page **/
	private static final String INDEX_NAVIGATION = "index";

	/**
	 * Controller for '/'. Shows index page
	 * 
	 * @param model
	 *            Model to update index view
	 * @return Navigation rule
	 */
	@RequestMapping("/")
	public String home(Model model) {
		return INDEX_NAVIGATION;
	}

	/**
	 * Controller for '/user'. Show index page with results about language
	 * 
	 * @param userName
	 *            GitHub user to calculate his languages
	 * @param model
	 *            Model to update index view.
	 * @return Navigation rule.
	 */
	@RequestMapping("/user")
	public String home(@RequestParam(value = "userName", required = true) String userName, Model model) {

		List<String> errors = new ArrayList<String>();
		List<String> languages = null;

		// Validate empty user
		if (userName == null || userName.isEmpty() || userName.trim().isEmpty()) {
			errors.add("Empty user");
		} else {

			try {
				
				// Query languages
				languages = userService.favouriteLanguages(userName);

				// Check if user exists or has repositories
				if (languages == null || languages.isEmpty()) {
					errors.add("[" + userName + "] doesn't have repositories");
				}

			} catch (RestClientException e) {
				if (e.getMessage() != null && e.getMessage().contains("404")) {
					errors.add("[" + userName + "] doesn't exist");
				} else {
					errors.add("Error on Github Call for user [" + userName + "]: " + e.getMessage());
				}
			} catch (UnsupportedEncodingException e) {
				errors.add("Error on Github Call for user [" + userName + "]: " + e.getMessage());
			}
		}

		// Update Model
		model.addAttribute("userName", userName);
		model.addAttribute("language", languages);
		model.addAttribute("errors", errors);

		return INDEX_NAVIGATION;
	}

}