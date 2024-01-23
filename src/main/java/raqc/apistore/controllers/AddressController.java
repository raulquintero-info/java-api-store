package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.AddressDto;
import raqc.apistore.dto.CategoryDto;
import raqc.apistore.model.Address;
import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;
import raqc.apistore.service.AddressService;



@RestController
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/direcciones")
	@ResponseStatus(HttpStatus.OK)
	public List<Address> allAddresses(){
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n  *************** /direcciones   ");
		return addressService.findAll();		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/direcciones/usuario/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  AddressesByUserId(@PathVariable Long id){
		
		List<Address> addresses = null;
		String response = "";
		try {
			addresses = addressService.findByUserId(id);
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(addresses == null) {
			response ="No se encontraron Direcciones para el ususario ID: ".concat(id.toString()).concat(", aun.");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Address>>(addresses, HttpStatus.OK);	
	}
	
	
	@CrossOrigin
	@PostMapping("/direcciones")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody AddressDto addressDto){
		
		
		
		Address addressNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			System.out.println(addressDto);
			addressNew = this.addressService.create(addressDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de agregar este registro " + addressNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		System.out.println(addressDto);
		System.out.println(addressNew);
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+addressNew.getId() +" "  );
		response.put("category", addressNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PutMapping("/direcciones")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody AddressDto addressDto){
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]AddressController::update() \n     "
				+ addressDto);
		Address addressNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			addressNew = this.addressService.update(addressDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + addressNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro actualizado con exito, con el ID "+ addressNew.getId() +" "  );
		response.put("address", addressNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@DeleteMapping("/direcciones/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Address addressDelete = this.addressService.findById(id);
			if(addressDelete==null) {
				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			addressService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
	
}
