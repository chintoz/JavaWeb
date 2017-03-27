package com.ciklum.service;

import java.io.IOException;
import java.util.List;

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
	 * @throws IOException When I/O exception occurs
	 */
	List<String> favouriteLanguages(String userName) throws IOException;

}
