package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.model.User;
import raqc.apistore.dto.UserDto;
import raqc.apistore.model.User;
import raqc.apistore.model.Human;
import raqc.apistore.model.Rol;
import raqc.apistore.service.UserService;
import raqc.apistore.service.HumanService;



@RestController
@RequestMapping("/api")

public class UserController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private HumanService humanService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getAllUsers(){

		return userService.findAll();	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		User user = null;
		String response="";
		
		try {
			user = userService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(user==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/usuarios/full/{id}")
	public ResponseEntity<?> consultaPorIdCompleta(@PathVariable Long id){
		
		
		User user = null;
		String response="";
		
		try {
			user = userService.findHumanByUserId(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(user==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
		
	}
	
	
}
