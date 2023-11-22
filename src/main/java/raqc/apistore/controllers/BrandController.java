package raqc.apistore.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.BrandDto;
import raqc.apistore.model.Brand;
import raqc.apistore.service.BrandService;


@RestController
@RequestMapping("/api")

public class BrandController {


	@Autowired
	private BrandService brandService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/marcas")
	@ResponseStatus(HttpStatus.OK)
	public List< Brand > consulta(){
		
		
	return brandService.findAll();	
		
				
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/marcas/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		Brand brand = null;
		String response="";
		
		try {
			brand = brandService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(brand==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Brand>(brand, HttpStatus.OK);
		
		
	}
	
	
	
	@CrossOrigin
	@DeleteMapping("/marcas/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Brand productDelete = this.brandService.findById(id);
			if(productDelete==null) {
				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			brandService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PostMapping("/marcas")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody BrandDto brandDto){
		
		Brand brandNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			brandNew = this.brandService.create(brandDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + brandNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+brandNew.getId() +" "  );
		response.put("brand", brandNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/marcas")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody BrandDto brandDto){
		
		Brand brandNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			brandNew = this.brandService.update(brandDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + brandNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Brand actualizado con exito, con el ID "+brandNew.getId() +" "  );
		response.put("brand", brandNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	


	
}
