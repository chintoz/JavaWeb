package com.ciklum.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Service implementation for UserService
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final String GITHUB_API_USER_URL = "https://api.github.com/users/";
	private static final String GITHUB_API_USER_REPOS = "/repos";
	private static final String LANGUAGE_KEY = "language";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ciklum.service.UserService#favouriteLanguages(java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<String> favouriteLanguages(String userName) throws IOException {

		// Variable declaration
		List<String> result = null;

		// Assign input value to a local variable
		String encodedUserName = URLEncoder.encode(userName, "UTF-8");

		// Do a REST request to get information about repositories
		String reposContent = getRestContent(encodedUserName);

		// Convert content to a JSON Object
		ObjectMapper mapper = new ObjectMapper();
		Map[] repos = mapper.readValue(reposContent, Map[].class);

		// No exists repositories or user doesn't have a repository
		if (repos == null || repos.length == 0) {
			return null;
		}

		// Calculate results
		result = calculateFavourite(repos);

		// Return result
		return result;
	}

	/**
	 * Method to do a REST request to get repositories information about an
	 * user.
	 * 
	 * @param userName
	 *            Github userName
	 * @return String with userContent
	 * @throws IOException
	 *             When I/O an error occur
	 */
	private String getRestContent(String userName) throws IOException {

		// Variable declaration
		URL url = null;
		HttpsURLConnection con = null;

		// Call URL to get content
		url = new URL(GITHUB_API_USER_URL + userName + GITHUB_API_USER_REPOS);
		con = (HttpsURLConnection) url.openConnection();

		// Get response from input
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Return response content as String
		return response.toString();

	}

	/**
	 * Private method to calculate most used languages from JSON response
	 * 
	 * @param repos
	 *            JSON response as a Java Object
	 * @return List of most used languages
	 */
	@SuppressWarnings("rawtypes")
	private List<String> calculateFavourite(Map[] repos) {
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		Integer maxCount = null;
		List<String> maxLanguages = null;

		// Structure language counts as a Map (language --> count)
		for (Map repo : repos) {
			if (repo.get(LANGUAGE_KEY) != null) {
				String language = (String) repo.get(LANGUAGE_KEY);
				if (count.get(language) == null) {
					count.put(language, Integer.valueOf(1));
				} else {
					count.put(language, count.get(language) + 1);
				}
			}
		}

		// Calculate favourite language
		for (Entry<String, Integer> entry : count.entrySet()) {

			// First step, the first element is the max at this moment
			if (maxCount == null) {
				maxCount = entry.getValue();
				maxLanguages = new ArrayList<>();
				maxLanguages.add(entry.getKey());
				continue;
			}

			// If this element has the same count then other favourite language
			if (maxCount.intValue() == entry.getValue().intValue()) {
				maxLanguages.add(entry.getKey());
			}

			// New favourite language more appereances
			if (maxCount.intValue() < entry.getValue().intValue()) {
				maxCount = entry.getValue();
				maxLanguages.clear();
				maxLanguages.add(entry.getKey());
			}
		}

		// Return the result
		return maxLanguages;
	}

}
