package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.RolDto;
import raqc.apistore.model.Category;
import raqc.apistore.model.Rol;
import raqc.apistore.service.RoleService;



@RestController
@RequestMapping("/api")

public class RolController {


	@Autowired
	private RoleService roleService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/roles")
	@ResponseStatus(HttpStatus.OK)
	public  List<Rol> consulta(){
	
		return roleService.findAll();	

	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/roles/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		Rol role = null;
		String response="";
		
		try {
			role = roleService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(role==null) {
			response ="El Rol con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Rol>(role, HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Rol productDelete = this.roleService.findById(id);
			if(productDelete==null) {
				response.put("mensaje", "Error al eliminar. Este producto ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			roleService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Rol eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/roles")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody RolDto roleDto){
		
		Rol roleNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			roleNew = this.roleService.create(roleDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + roleNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Roleo Grabado con exito, con el ID "+roleNew.getId() +" "  );
		response.put("role", roleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/roles")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody RolDto roleDto){
		
		Rol roleNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			roleNew = this.roleService.update(roleDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + roleNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Rol actualizado con exito, con el ID "+roleNew.getId() +" "  );
		response.put("role", roleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	



	
}
