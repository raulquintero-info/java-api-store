package raqc.apistore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.CredentialsDto;
import raqc.apistore.dto.UserLoggedDto;



@RestController
@RequestMapping("/auth")
public class AuthController {

	@CrossOrigin
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody CredentialsDto credentialsDto) {
		
		UserLoggedDto userLoggedDto;

		System.out.println(credentialsDto);
		
		if(credentialsDto.getEmail().equalsIgnoreCase("admin")){
			userLoggedDto = new UserLoggedDto(1,"admin@mystore.com", "administrator","", "1");
		} else {
			userLoggedDto = new UserLoggedDto(1,"customer@server.com", "customer","perez", "2");

		}
		
		
		
		return new ResponseEntity<UserLoggedDto>(userLoggedDto, HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PostMapping(value = "register")
	public String register() {
		return "register from public endpoint";
	}
	
	
	
}