package raqc.apistore.controllers;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.CredentialsDto;
import raqc.apistore.dto.TokenDto;
import raqc.apistore.dto.UserDto;
import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.service.UserService;
import raqc.apistore.model.User;



@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	

	
	
	@CrossOrigin
	@PostMapping(value = "token")
	public ResponseEntity<?> validateToken(@RequestBody TokenDto token) {
		Map<String, Object> response = new HashMap<>();
		User user;
		try { 
			user = userService.validateToken(token.getToken());
		} catch (DataAccessException e) {
			response.put("error", "Error al realizar la consulta.");
			response.put("message", e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	    response.put("token", token  );
		response.put("user", user);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	
	@SuppressWarnings("unused")
	@CrossOrigin
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@RequestBody CredentialsDto credentialsDto) {
		User user = null;
		UserLoggedDto uLDto = new UserLoggedDto();
		TokenDto token = new TokenDto();

		String password = "";
		
		String response = "";
		

		System.out.println("--[" +  new Throwable().getStackTrace()[0].getLineNumber()+ "]AuthController::login() \n    " 
				+  credentialsDto);
		
		
		try {
			user = userService.findByUsername(credentialsDto.getUsername());
			
			if(user==null) {
				throw new NoSuchElementException();
			} else {
				
			
				if(user.getToken() == null) {
	//				token.setToken(generateToken());
					user.setToken(generateToken());
					userService.updateToken(user);
				} else {
					token.setToken(user.getToken());
				}
				System.out.println("--[" +  new Throwable().getStackTrace()[0].getLineNumber()+ "]AuthController::login() \n    "  
						+ user.toString());
				password = user.getPassword();
				
				uLDto.setId(user.getId());
				uLDto.setUsername(user.getUsername());
				uLDto.setRol(user.getRol());
				uLDto.setToken(user.getToken());
				uLDto.setName(user.getName());
				uLDto.setLastname(user.getLastname());
			}
//		} catch (DataAccessException e) {
		}catch(NoSuchElementException e) {
			response = "Credenciales Invalidas.";
//			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.UNAUTHORIZED);
		}
		
		
		
		if(user==null) {
			response ="Credenciales Incorrectas";

			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		System.out.println("--[" +  new Throwable().getStackTrace()[0].getLineNumber()+ "]AuthController::login() \\n    " 
				+ "success  - " + token.toString());
		return new ResponseEntity<UserLoggedDto>(uLDto, HttpStatus.OK);
		
		
		
	}

	
	
	@CrossOrigin
	@PostMapping(value = "register")
	public String register() {
		return "register from public endpoint";
	}
	
	
	
	private String generateToken() {
		 int leftLimit = 48; // numeral '0'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 10;
		    Random random = new Random();

		    String generatedString = random.ints(leftLimit, rightLimit + 1)
		      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		      .limit(targetStringLength)
		      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		      .toString();
		    
		   return generatedString;
		    
		    
	}
	
	
}