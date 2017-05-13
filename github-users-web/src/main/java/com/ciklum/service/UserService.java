package com.ciklum.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.web.client.RestClientException;

/**
 * Interface for User Service to query favourite language
 * 
 * @author Jacinto J. Mena Lomeña
 *
 */
public interface UserService {

	/**
	 * Method to query the favourite languages for a Github User
	 * 
	 * @param userName
	 *            Github User name to query
	 * @return List of favourite languages
	 * @throws RestClientException
	 *             When REST exception occurs
	 * @throws UnsupportedEncodingException
	 *             When Unsupported Encoding exception occurs
	 * 
	 */
	List<String> favouriteLanguages(String userName) throws RestClientException, UnsupportedEncodingException;

}
