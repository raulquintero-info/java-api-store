package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.UsersDto;



@RestController
@RequestMapping("/api")

public class RolController {

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/rols")
	@ResponseStatus(HttpStatus.OK)
	public  void consulta(){
	
		
	
	}
}
