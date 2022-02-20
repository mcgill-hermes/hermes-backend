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
    
    
    @PostMapping(value = { "/technician/create", "/technician/create/" })
    public UserAccountDto createTechnicianProfile(@RequestParam String userName, @RequestParam String firstName,
    		@RequestParam String lastName, @RequestParam String password) throws Exception {
    	try {
    		UserAccount userAccount = userAccountService.createUserAccount(userName, password, firstName, lastName);
    		return ControllerHelper.convertToDto(userAccount);
    	} catch (IllegalArgumentException e) {
    		throw new RuntimeException(e.getMessage());
    	}
    }
}
