package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.model.User;
import raqc.apistore.dto.BrandDto;
import raqc.apistore.dto.UserDto;
import raqc.apistore.dto.UserLoggedDto;
import raqc.apistore.model.User;
import raqc.apistore.model.Brand;
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
	@GetMapping("/favoritos/usuario/{id}")
	public ResponseEntity<?> consultaPorIdCompleta(@PathVariable Long id){
		
		UserLoggedDto userDto = new UserLoggedDto();

		User user = null;
		String response="";
		
		try {
			
			user = userService.findHumanByUserId(id);
			if(user!=null) {
			userDto.setId(user.getId());
			userDto.setUsername(user.getUsername());
			userDto.setToken(user.getToken());
			userDto.setRol(user.getRol());
			System.out.println("user>>> " + user.getUsername());
			System.out.println("userDto>>> " + userDto.toString());
			}
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(user==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserLoggedDto>(userDto, HttpStatus.OK);
		
		
	}
	
	
	@CrossOrigin
	@PutMapping("/usuarios-favoritos")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody UserDto userDto){
		
		User userNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			userNew = this.userService.update(userDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + userNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Brand actualizado con exito, con el ID "+userNew.getId() +" "  );
		response.put("user", userDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	

}
