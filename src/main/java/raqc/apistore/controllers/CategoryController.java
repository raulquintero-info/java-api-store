package raqc.apistore.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.CategoryDto;
import raqc.apistore.model.Category;
import raqc.apistore.service.CategoryService;


@RestController
@RequestMapping("/api")

public class CategoryController {


	@Autowired
	private CategoryService categoryService;
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/admin/categorias")
	@ResponseStatus(HttpStatus.OK)
	public List< Category > consulta(){
		
		
	return categoryService.findAll();	
		
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public List< Category > getCategoriesEnabled(){
		
	return categoryService.getCategoriesEnabled();	
	
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		Category category = null;
		String response="";
		
		try {
			category = categoryService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(category==null) {
			response ="El registro con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Category>(category, HttpStatus.OK);
		
		
	}
	
	
	
	@CrossOrigin
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Category productDelete = this.categoryService.findById(id);
			if(productDelete==null) {
				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			categoryService.delete(id);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PostMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody CategoryDto productDto){
		
		Category categoryNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoryNew = this.categoryService.create(productDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + categoryNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro Grabado con exito, con el ID "+categoryNew.getId() +" "  );
		response.put("category", categoryNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/categorias")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody CategoryDto productDto){
		
		Category categoryNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			categoryNew = this.categoryService.update(productDto);
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + categoryNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro actualizado con exito, con el ID "+categoryNew.getId() +" "  );
		response.put("category", categoryNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	

	
	
	
	
}
