package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.EmployeeDto;
import raqc.apistore.model.User;
import raqc.apistore.service.UserService;


@RestController
@RequestMapping("/api")

public class EmployeeController {

	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados")
	@ResponseStatus(HttpStatus.OK)
	public List< User > consulta(){
		
	return userService.findAllEmployees();	
		
	}
	


	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		User customer = null;
//		String response="";
//		System.out.println("error aqui");
//		
//		try {
//			System.out.println("error aqui 2: " + id);
//
//			customer = employeeService.findById(id);
//
//		}catch(DataAccessException e) {
//			response = "Error al realizar la consulta.";
//			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
//			System.out.println("error aqui 3");
//
//			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//			
//		}
//		
//
//		if(customer==null) {
//			
//			response ="El Registro con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
//			System.out.println(response);
//			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
//		}
		return new ResponseEntity<User>(customer, HttpStatus.OK);
			
	}
	
	
	@CrossOrigin
	@PostMapping("/empleados")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody EmployeeDto customerDto){
//		
		User employeeNew = new User();
//		employeeNew.setId(0L);
		Map<String, Object> response = new HashMap<>();
//		try {
//			employeeNew = this.employeeService.create(customerDto);
//			
//		}catch(DataAccessException e) {
//			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
//			response.put("mensaje", "Error al tratar de actualizar el registo " + employeeNew.getId());
//			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
//		}
//		
//		
//		response.put("mensaje", "REgistro Grabado con exito, con el ID " + employeeNew.getId() +" "  );
		response.put("employee", employeeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/empleados")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody EmployeeDto customerDto){
		
		User employeeNew = null;
		Map<String, Object> response = new HashMap<>();
//		try {
//			employeeNew = this.employeeService.update(customerDto);
//			
//		}catch(DataAccessException e) {
//			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
//			response.put("mensaje", "Error al tratar de actualizar el registo " + employeeNew.getId());
//			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
//		}
//		
//		
//		response.put("mensaje", "Registro actualizado con exito, con el ID "+employeeNew.getId() +" "  );
		response.put("employee", employeeNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	

		
}
