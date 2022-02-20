package ecse428.hermes.controller;

import ecse428.hermes.dto.UserAccountDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Array;

import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.model.UserAccount;

public class ControllerHelper {

	
	public static UserAccountDto convertToDto(UserAccount userAccount) throws Exception {
		if (userAccount == null) {
			throw new IllegalArgumentException("UserAccount does not exist.");
		}
		
		if (userAccount.getHistory() != null) {
//			List<ArticleDto> services = userAccount.getHistory().stream().map(r -> ControllerHelper.convertToDto(r))
//					.collect(Collectors.toList());
//			TechnicianDto technicianDto = new TechnicianDto(technician.getFirstName(), technician.getLastName(),
//					technician.getEmail(), technician.getPassword(), availabilities);
//			technicianDto.setServices(services);
//			return technicianDto;
			return null;
		}else { // user account has no related history

			UserAccountDto userAccountDto = new UserAccountDto(userAccount.getUserName(), userAccount.getPassword(),
				userAccount.getFirstName(), userAccount.getLastName(), new ArrayList<>(), new ArrayList<>());
		
		return userAccountDto;
		}
		
	}
	
}
