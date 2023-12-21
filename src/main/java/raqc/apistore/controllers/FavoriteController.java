package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.model.Brand;
import raqc.apistore.model.Category;
import raqc.apistore.model.Favorite;
import raqc.apistore.dto.FavoriteDto;
import raqc.apistore.dto.ProductDatatableDto;
import raqc.apistore.dto.ProductDto;
import raqc.apistore.model.Product;
import raqc.apistore.service.CategoryService;
import raqc.apistore.service.FavoriteService;
import raqc.apistore.service.ProductService;


@RestController
@RequestMapping("/api")

public class FavoriteController {


	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private ProductService productService;
	
	
	
	
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping("/favoritos")
//	
//	@ResponseStatus(HttpStatus.OK)
//	public List<Product> consulta(@PathVariable Long id){
//		
//		
//		
//		return favoriteService.findFavoritesByUserId(id);
//		
//	}
	
	
	
	
	@CrossOrigin
	@GetMapping("/favoritos/{id}")
	public ResponseEntity<?> getFavoritesByUserId(@PathVariable Long id){
	
		List<Integer> arFavorites = null;
		List<Product> favorites = null;
//		String arrayFavorites = null;
		String response="";
		
		System.out.println("UserID>>>>>" + id);
		
		
		try {
			arFavorites = favoriteService.getFavoritesIdByUserId(id);
			System.out.println(">>>arFavorites" + arFavorites);
//			arrayFavorites = this.whenCollectorsJoining_thenPrintCustom(arFavorites);
			//genera un error al ejecutar esta sentencia
//			System.out.println(StringUtils.join(arFavorites, "|"));
			favorites = productService.findFavoritesByUserId(arFavorites);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(favorites==null) {
			response ="El clientecon el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(favorites, HttpStatus.OK);
		
	}
	
	
	@CrossOrigin
	@PostMapping("/favoritos-agregar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> addFavorite(@RequestBody FavoriteDto favoriteDto){
		
		Favorite favoriteProduct = new Favorite();
		Product product = null;
		Map<String, Object> response = new HashMap<>();
		try {
			if(favoriteService.findByProductIdAndUserId(favoriteDto.getProductId(), favoriteDto.getUserId())==null) {
			favoriteProduct.setProductId(favoriteDto.getProductId());
			favoriteProduct.setUserId(favoriteDto.getUserId());
			favoriteProduct = this.favoriteService.addFavorite(favoriteProduct);
			System.out.println("Add.favoritePRoduct" + favoriteProduct.toString());
			}
			product = productService.findFavoriteByUserId(favoriteDto.getProductId(), favoriteDto.getUserId());
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de grabar el registo " + favoriteProduct.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		

		response.put("mensaje", "Favorito Agregado "+ favoriteProduct.getId() +" "  );
		response.put("favoriteProduct",product);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@PostMapping("/favoritos-eliminar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> removeFavorite(@RequestBody FavoriteDto favoriteDto){
		
		System.out.println("favoriteDto:>> " + favoriteDto.toString());
		Favorite favoriteProduct = new Favorite();
		Product product = null;
		Map<String, Object> response = new HashMap<>();
		try {
			if(favoriteService.findByProductIdAndUserId(favoriteDto.getProductId(), favoriteDto.getUserId())!= null) {
			favoriteProduct.setProductId(favoriteDto.getProductId());
			favoriteProduct.setUserId(favoriteDto.getUserId());
			System.out.println("favoriteProduct:--- " + favoriteProduct.toString());
			this.favoriteService.removeFavorite(favoriteProduct);
			System.out.println("remove.favoritePRoduct" + favoriteProduct.toString());
			}
			product = productService.findFavoriteByUserId(favoriteDto.getProductId(), favoriteDto.getUserId());
			
		}catch(DataAccessException e) {
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage().toString()));
			response.put("mensaje", "Error al tratar de eliminar el registo " + favoriteProduct.getId());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus. INTERNAL_SERVER_ERROR);
		}
		

		response.put("mensaje", "Favorito Eliminado "+ product.getId() +" "  );
		response.put("favoriteProduct",product);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		
	}
	
//	@CrossOrigin
//	@DeleteMapping("/favoritos/{id}")
//	public ResponseEntity<?> borraPorId(@PathVariable Long id) {
//		
//		Map<String, Object> response = new HashMap<>();
//		try {
//			Product productDelete = this.productService.findById(id);
//			if(productDelete==null) {
//				response.put("mensaje", "Error al eliminar. Este registro ya no existe en base de datos");
//				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//			productService.delete(id);
//			categoryService.minusOneQuantityProducts(productDelete.getCategory().getId()) ;
//
//			
//		}catch(DataAccessException e) {
//			response.put("message", "Error al eliminar en base de datos");
//			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getLocalizedMessage()));
//			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//			
//		response.put("mensaje", "Registro eliminado con exito");
//		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
//		
//	}
	
	
	
	public String whenCollectorsJoining_thenPrintCustom(List<Integer> intList) {
//	    List<Integer> intList = Arrays.asList(1, 2, 3);
	    String result = intList.stream()
	      .map(n -> String.valueOf(n))
	      .collect(Collectors.joining(",", "(", ")"));
	 
	    System.out.println(result);
	    return result;
	}
	
	
}
