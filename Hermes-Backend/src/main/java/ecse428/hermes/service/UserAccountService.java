package ecse428.hermes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ecse428.hermes.dao.UserAccountRepository;
import ecse428.hermes.model.UserAccount;

@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository userAccountRepository;
	
	
	/**
	 * Creates a user account with the provide arguments.
	 * @param aUserName
	 * @param aPassword
	 * @param aFirstName
	 * @param aLastName
	 * @author Zichen
	 * @return the account created.
	 */
	@Transactional
	public UserAccount createUserAccount(String aUserName, String aPassword, String aFirstName, String aLastName) { 

		// TODO: I decide not to introduce hash code value inside the database.
		if (userAccountRepository.findUserAccountByUserName(String.valueOf(aUserName)) != null) {
			throw new IllegalArgumentException("ERROR: UserAccount with the provided username exists.");
		}

		UserAccount userAccount = new UserAccount();

		if (!aUserName.isEmpty()) {
			if (ServiceHelper.isValidUserName(aUserName)) {
				userAccount.setUserName(aUserName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid userName.");
			}
		}
		
		if (!aPassword.isEmpty()) {
			if (ServiceHelper.isValidPassWord(aPassword)) {
				userAccount.setPassword(aPassword);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid password.");
			}
		}
		
		if (!aFirstName.isEmpty()) {
			if (ServiceHelper.isValidFirstName(aFirstName)) {
				userAccount.setFirstName(aFirstName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid firstName.");
			}
		}
		
		if (!aLastName.isEmpty()) {
			if (ServiceHelper.isValidLastName(aLastName)) {
				userAccount.setLastName(aLastName);
			} else {
				throw new IllegalArgumentException("ERROR: Invalid lastName.");
			}
		}

		userAccountRepository.save(userAccount);

		return userAccount;
	}
	
	
	/*********************************************************
	 * Jiatong Niu's workspace
	 *********************************************************/
	
	
}