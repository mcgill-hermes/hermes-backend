package ecse428.hermes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


	/*********************************************************
	 * Jiatong Niu's workspace
	 *********************************************************/

	/**
	 * @author Jiatong Niu
	 * @para userName
	 * @return an UserAccountDto
	 * @throws Exception
	 */

	@GetMapping (value = {"getAccountByUsername","getAccountByUsername/"})
	public UserAccountDto getAccountByUsername (@RequestParam("username") String username) throws Exception{
		try{
			UserAccount userAccount = userAccountService.getAccountByUsername(username);
			return ControllerHelper.convertToDto(userAccount);
		}catch(IllegalArgumentException e){
			throw new RuntimeException(e.getMessage());
		}

	}

}
