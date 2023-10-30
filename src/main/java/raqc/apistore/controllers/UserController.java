package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.ProductDto;
import raqc.apistore.dto.UserDto;
import raqc.apistore.dto.RolDto;



@RestController
@RequestMapping("/api")

public class UserController {

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<UserDto> getAllUsers(){
	
		List<UserDto> usersDto = new ArrayList<UserDto>(); 
		
		usersDto.add(new UserDto((long) 1,"admin", "", new RolDto( "admin")));
		usersDto.add(new UserDto((long) 2,"customer", "", new RolDto( "customer")));
		
		return usersDto;
	}
}
