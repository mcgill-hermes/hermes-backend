package ecse428.hermes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecse428.hermes.dto.UserAccountDto;
import ecse428.hermes.model.UserAccount;
import ecse428.hermes.service.UserAccountService;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserAccountService userAccountService;
    
    /**
     * Sign up a user account.
     * @param userName
     * @param firstName
     * @param lastName
     * @param password
     * @author Zichen
     * @return a UserAccountDto with specified information.
     * @throws Exception
     */
    @PostMapping(value = { "/auth/signup", "/auth/signup/" })
    public UserAccountDto createUserAccount(@RequestParam String userName, @RequestParam String firstName,
    		@RequestParam String lastName, @RequestParam String password) throws Exception {
    	try {
    		UserAccount userAccount = userAccountService.createUserAccount(userName, password, firstName, lastName);
    		return ControllerHelper.convertToDto(userAccount);
    	} catch (IllegalArgumentException e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }
    
    /**
     * login a user.
     * @param userName
     * @param password
     * @author Zichen
     * @return UserAccountDto if password match with userName
     * @throws Exception
     */
    @PostMapping(value = { "/auth/login", "/auth/login/" })
    public UserAccountDto createTechnicianProfile(@RequestParam String userName, @RequestParam String password) throws Exception {
    	try {
    		UserAccount userAccount = userAccountService.verifyUserAccountPassword(userName, password);
    		return ControllerHelper.convertToDto(userAccount);
    	} catch (RuntimeException e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }
}
