package ecse428.hermes.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceHelper {

	/**
	 * Method to verify a legal username.
	 * @param aUserName
	 * @author Zichen
	 * @return a boolean indicate if username is valid.
	 */
	public static boolean isValidUserName(String aUserName) {
		if(!aUserName.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Method to verify a legal password.
	 * @param aPassword
	 * @author Zichen
	 * @return a boolean indicate if password is valid.
	 */
	public static boolean isValidPassWord(String aPassword) {
		if(!aPassword.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to verify a proper firstname.
	 * @param aPassword
	 * @author Zichen
	 * @return a boolean indicate if firstname is valid.
	 */
	public static boolean isValidFirstName(String aFirstName) {
		if(!aFirstName.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Method to verify a proper firstname.
	 * @param aPassword
	 * @author Zichen
	 * @return a boolean indicate if firstname is valid.
	 */
	public static boolean isValidLastName(String aLastName) {
		if(!aLastName.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public static <T> List<T> toList(Iterable<T> iterable) {
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}
