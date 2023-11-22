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

import raqc.apistore.dto.CustomerDto;
import raqc.apistore.dto.HumanDto;
import raqc.apistore.dto.UserDto;
import raqc.apistore.model.Customer;
import raqc.apistore.model.Human;
import raqc.apistore.model.Product;
import raqc.apistore.model.Rol;
import raqc.apistore.model.User;
import raqc.apistore.service.CustomerService;
import raqc.apistore.service.HumanService;
import raqc.apistore.service.UserService;


@RestController
@RequestMapping("/api")

public class CustomerController {


	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private HumanService humanService;
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public List< Customer > consulta(){
		
	return customerService.findAll();	
		
	}
	


	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		

		Customer customer = null;
		String response="";
		System.out.println("error aqui");
		
		try {
			System.out.println("error aqui 2: " + id);

			customer = customerService.findById(id);

		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		

		if(customer==null) {
			
			response ="El cliente con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			System.out.println(response);
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			
	}
	
	
	@CrossOrigin
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody CustomerDto customerDto){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Create<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		Customer customerNew = new Customer();
		User userNew = new User();
		Human humanNew = new Human();
		Rol rolNew = new Rol(2L,"");
		customerNew.setId(0L);
		Map<String, Object> response = new HashMap<>();
		try {
			System.out.println("customerDto:>>> " + customerDto.toString());
			System.out.println("human:>>> " + customerDto.getHuman().toString());

			humanNew = customerDto.getHuman();
			humanNew = humanService.create(humanNew);
			

			System.out.println("humanNew:>>> " + humanNew.toString());

			customerDto.setHuman(humanNew);
			customerNew = customerService.create(customerDto);

			System.out.println("userDto:>>>>>>" + customerNew.getHuman().getUser());
			userNew = customerNew.getHuman().getUser();
			userNew.setRol(rolNew);
			userNew.setHuman(humanNew);
			userService.update(userNew);
			System.out.println("userNew:>>>>>>" + userNew);


			System.out.println("customerNew:>>> " + customerNew.toString());

		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("message", "Error al tratar de actualizar el registo " + customerNew.getId());
			System.out.println("catch:>>>" + customerDto.toString());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("message", "Cliente Grabado con exito, con el ID " + customerNew.getId() +" "  );
		response.put("customer", customerNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/clientes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody CustomerDto customerDto){
		Human humanNew = new Human();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Update<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Customer customerNew = new Customer();
		Map<String, Object> response = new HashMap<>();
		try {
			customerNew.setId(customerDto.getId());
			humanNew = customerDto.getHuman();
			humanNew = humanService.update(humanNew);
			System.out.println(customerDto.getHuman());
			customerNew.setHuman(humanNew);
//			customerNew = this.customerService.update(customerDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + customerNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Cliente actualizado con exito, con el ID "+humanNew.getId() +" "  );
		response.put("customer", customerNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Customer customerDelete = this.customerService.findById(id);
			
			if(customerDelete==null) {
				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			customerService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("message", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}

		
}