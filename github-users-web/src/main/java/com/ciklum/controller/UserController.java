package com.ciklum.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

		// Variable definition
		List<String> errors = new ArrayList<String>();
		List<String> languages = null;

		// Validate empty user
		if (userName == null || userName.isEmpty() || userName.trim().isEmpty()) {
			errors.add("Empty user");
		} else {

			// Query languages
			try {
				languages = userService.favouriteLanguages(userName);

				// Check if user exists or has repositories
				if (languages == null || languages.isEmpty()) {
					errors.add("[" + userName + "] doesn't have repositories");
				}

			} catch (FileNotFoundException e) {
				errors.add("[" + userName + "] doesn't exist");
			} catch (IOException e) {
				errors.add("Error on Github Call for user [" + userName + "]: " + e.getMessage());
			}
		}

		// Update Model
		model.addAttribute("userName", userName);
		model.addAttribute("language", languages);
		model.addAttribute("errors", errors);

		// Return navigation
		return INDEX_NAVIGATION;
	}

}