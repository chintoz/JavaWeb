package com.ciklum.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ciklum.model.Repo;

/**
 * Service implementation for UserService
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Value("${github.user.repos.proto}")
	private String proto;

	@Value("${github.user.repos.host}")
	private String host;

	@Value("${github.user.repos.port}")
	private String port;

	@Value("${github.user.repos.path}")
	private String path;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ciklum.service.UserService#favouriteLanguages(java.lang.String)
	 */
	@Override
	public List<String> favouriteLanguages(String userName) throws RestClientException, UnsupportedEncodingException {

		// Encode Github User name to prevent malformed URLs
		String encodedUserName = URLEncoder.encode(userName, "UTF-8");

		// Do a REST request to get information about repositories
		List<Repo> repos = getRestContent(encodedUserName);

		// Calculate results
		List<String> result = calculateFavourite(repos);

		return result;
	}

	/**
	 * Method to do a REST request to get repositories information about an
	 * user.
	 * 
	 * @param userName
	 *            Github userName
	 * @return List of user repositories info
	 * @throws RestClientException
	 *             When REST error occurs
	 */
	private List<Repo> getRestContent(String userName) throws RestClientException {

		String curl = builRequestUrl(userName);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Repo[]> response = restTemplate.getForEntity(curl, Repo[].class);

		return Arrays.asList(response.getBody());

	}

	/**
	 * Private method to calculate most used languages from JSON response
	 * 
	 * @param repos
	 *            JSON response as a Java Object
	 * @return List of most used languages
	 */
	private List<String> calculateFavourite(List<Repo> repos) {

		Optional<Entry<Long, List<String>>> max = repos.stream().filter(repo -> repo.getLanguage() != null)
				.collect(Collectors.groupingBy(Repo::getLanguage, Collectors.counting())).entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream().max((entry1, entry2) -> Long.compare(entry1.getKey(), entry2.getKey()));

		return max.isPresent() ? max.get().getValue() : null;
	}

	/**
	 * Private method to build request url to query user repos
	 * 
	 * @param userName
	 *            Encoded URL userName
	 * @return String with URL to query user repos
	 */
	private String builRequestUrl(String userName) {
		StringBuilder builder = new StringBuilder();

		builder.append(proto).append(host).append(":").append(port).append(path.replace(":user", userName));

		return builder.toString();

	}

}
