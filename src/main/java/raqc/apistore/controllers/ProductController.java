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
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.*;

import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;
import raqc.apistore.model.Favorite;
import raqc.apistore.dto.FavoriteDto;
import raqc.apistore.dto.ProductDatatableDto;
import raqc.apistore.dto.ProductDto;
import raqc.apistore.model.Product;
import raqc.apistore.service.CategoryService;
import raqc.apistore.service.ProductService;


@RestController
@RequestMapping("/api")

public class ProductController {


	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> consulta(@RequestParam (required=false, defaultValue = "0" ) Integer categoryid , @RequestParam (required=false,  defaultValue= "0") String page){
		System.out.println(categoryid + page);
		return productService.findAll();
//		return productService.findAllProducts(categoryid, page);
		
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos/datatable")
	@ResponseStatus(HttpStatus.OK)
	public ProductDatatableDto consultaDatatable(){
		
		ProductDatatableDto response = new ProductDatatableDto();
		
		response.setContent(productService.findAll());	
		response.setSize(response.getContent().size());
		response.setTotalElements(response.getContent().size());
		return response;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos-oferta")
	@ResponseStatus(HttpStatus.OK)
	public ProductDatatableDto consultaOfertas(){
		
		ProductDatatableDto response = new ProductDatatableDto();
		
		response.setContent(productService.findAllOffers());	
		response.setSize(response.getContent().size());
		response.setTotalElements(response.getContent().size());
		return response;
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos-nuevos")
	@ResponseStatus(HttpStatus.OK)
	public ProductDatatableDto consultaNuevos(){
		
		ProductDatatableDto response = new ProductDatatableDto();
		
		response.setContent(productService.findAllNew());	
		response.setSize(response.getContent().size());
		response.setTotalElements(response.getContent().size());
		return response;
		
	}
//===============================================
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos/page/{page}")
	public ResponseEntity<?> consultaPage(@PathVariable Integer page, String orderBy){
		
		Page<Product> pageableResult;
		String response="";
		System.out.println(orderBy);
		try {
			if (page<1) throw new Exception();
			Pageable pageable = PageRequest.of(page - 1, 5, Sort.by("id").descending());
			pageableResult = productService.findAllPage(pageable);

		} catch (Exception e) {
			response = "No es posible consultar la pagina 0.";
			return new ResponseEntity<String>(response, HttpStatus.NO_CONTENT);
		}
		


		return new ResponseEntity<Page<Product>>(pageableResult, HttpStatus.OK);
//		return productService.findAllPage(pageable);
	}
//=====================================
	
	// marcar favoritos por categoria y usuario
	@CrossOrigin
	@GetMapping("/productos/categoria/{id}/usuario/{userId}")
	public ResponseEntity<?> getByCategoryId(@PathVariable Long id, @PathVariable Long userId){
	
		List<Product> products = null;
		String response="";
		
		try {
			products = productService.getByCategoryId(id, userId);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(products==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
	
//	@CrossOrigin
//	@GetMapping("/productos/categoria/{categoryId}/usuario/{userId}")
//	public ResponseEntity<?> getByCategoryIdUserId(@PathVariable Long categoryId, @PathVariable Long userId){
//	
//		List<Product> products = null;
//		String response="";
//		
//		try {
//			products = productService.getByCategoryId(categoryId,userId);
//			
//		}catch(DataAccessException e) {
//			response = "Error al realizar la consulta.";
//			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
//			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		if(products==null) {
//			response ="El clientecon el ID: ".concat(categoryId.toString()).concat(" no existe en base de datos");
//			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
//		
//	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos/{id}")
	public ResponseEntity<?> consultaPorId(@PathVariable Long id){
		
		
		Product producto = null;
		String response="";
		System.out.println("error aqui");
		try {
			producto = productService.findById(id);
			System.out.println("error aqui 2");

		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		

		if(producto==null) {
			response ="El cliente con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(producto, HttpStatus.OK);
			
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos-favorito/{productId}/usuario/{userId}")
	public ResponseEntity<?> consultaFavoritoPorUsuarioId(@PathVariable Long productId, @PathVariable Long userId){
		
		
		Product producto = null;
		String response="";
		System.out.println("error aqui");
		try {
			producto = productService.findFavoriteByUserId(productId, userId);
			System.out.println("error aqui 2");

		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		

		if(producto==null) {
			response ="El cliente con el ID: ".concat(productId.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Product>(producto, HttpStatus.OK);
			
	}
	
	
	
//	@CrossOrigin
//	@GetMapping("/productos/favoritos/{id}")
//	public ResponseEntity<?> getFavoritesByUserId(@PathVariable Long id){
//	
//		List<Product> favorites = null;
//		String response="";
//		
//		try {
//			favorites = productService.getByCategoryId(id);
//			favorites = productService.getFavoritesByUserId(id);
//			
//		}catch(DataAccessException e) {
//			response = "Error al realizar la consulta.";
//			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
//			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		
//		if(favorites==null) {
//			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
//			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
//		}
//		
//		return new ResponseEntity<List<Product>>(favorites, HttpStatus.OK);
//		
//	}
	
	@CrossOrigin
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			Product productDelete = this.productService.findById(id);
			if(productDelete==null) {
				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			productService.delete(id);
			categoryService.minusOneQuantityProducts(productDelete.getCategory().getId()) ;

			
		}catch(DataAccessException e) {
			response.put("message", "Error al eliminar en base de datos");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("mensaje", "Registro eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> create(@RequestBody ProductDto productDto){
		
		Product productNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			System.out.println("dto" + productDto.toString());
			productNew = this.productService.create(productDto);
			System.out.println("new" + productNew.toString());
			
			//TODO: revisar por que ya no funciona este codigo, es para llevar la cuenta del numero de 
			// productos por  categoria
//			if(productNew.getId()>0) {
//			categoryService.plusOneQuantityProducts(productNew.getCategory().getId()) ;
//		}
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de grabar el registo " + productNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		

		response.put("mensaje", "Registro Grabado con exito, con el ID "+productNew.getId() +" "  );
		response.put("product", productNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
		
	
	
	@CrossOrigin
	@PutMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> update(@RequestBody ProductDto productDto){
		
		Product productNew = null;
		Map<String, Object> response = new HashMap<>();
		try {
			productNew = this.productService.update(productDto);
			System.out.println("productoNew:>>> " + productDto.toString());
			System.out.println("productoNew:>>> " + productNew.toString());
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de actualizar el registo " + productNew.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Registro actualizado con exito, con el ID "+productNew.getId() +" "  );
		response.put("product", productNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/load-info")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> loadProducts(){
		Product productNew = null;
		Map<String, Object> response = new HashMap<>();

		
		List<ProductDto> productsDto = new ArrayList<ProductDto>(); 
		
		Brand brand = new Brand();
		Category category = new Category();
		
		brand.setId(1L);
		category.setId(1L);
		productsDto.add(new ProductDto("s21 ultra", "", (Double)100.00, 10,"https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("iphone 14", "", (Double)100.00, 15,"https://cdn1.coppel.com/images/catalog/pm/2256663-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("iphone 12", "", (Double)100.00, 12,"https://cdn1.coppel.com/images/catalog/pm/2468993-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("g5", "", (Double)100.00, 23, "https://cdn1.coppel.com/images/catalog/pm/2842023-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Moto g42", "", (Double)100.00, 32, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("s20 plus", "", (Double)100.00, 12, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Galaxy A04E", "", (Double)100.00, 7, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Galaxy S22", "", (Double)100.00, 9, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Moto E20", "", (Double)100.00, 11, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Aura Z", "", (Double)100.00, 54,"https://cdn1.coppel.com/images/catalog/pm/2795193-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Moto E32", "", (Double)100.00, 42, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("A57", "", (Double)100.00, 8,"https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Galaxy tab s6", "", (Double)100.00, 9, "https://cdn1.coppel.com/images/catalog/pm/2810093-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("Toy Story 7\"", "", (Double)100.00, 13, "https://cdn1.coppel.com/images/catalog/pm/2953873-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("play tab 2", "", (Double)100.00, 46, "https://cdn1.coppel.com/images/catalog/pm/2140113-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("m9", "", (Double)100.00, 98, "https://cdn1.coppel.com/images/catalog/pm/2128583-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("ipad 10", "", (Double)100.00, 82, "https://cdn1.coppel.com/images/catalog/pm/2958593-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("A57", "", (Double)100.00, 65, "https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" , brand , category));
		productsDto.add(new ProductDto("A57", "", (Double)100.00, 19, "https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" , brand , category));

		
		try {
			productsDto.forEach(producto ->  this.productService.create(producto));
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Se agrego con exito el lote de productos. ");
		response.put("productos", productsDto);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		
	}
	
}
