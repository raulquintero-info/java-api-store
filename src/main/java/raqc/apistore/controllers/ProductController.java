package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.ProductDto;
import raqc.apistore.dto.CategoryDto;



@RestController
@RequestMapping("/api")

public class ProductController {

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List< ProductDto > consulta(){
		
		
		List<ProductDto> productsDto = new ArrayList<ProductDto>(); 

		productsDto.add(new ProductDto((long) 1,"s21 ultra", "", (float)100.00, 10,"https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" , 1, "Samsung"));
		productsDto.add(new ProductDto((long) 2,"iphone 14", "", (float)100.00, 15,"https://cdn1.coppel.com/images/catalog/pm/2256663-1.jpg?iresize=width:300,height:240" ,  3, "Apple"));
		productsDto.add(new ProductDto((long) 3,"1phone 12", "", (float)100.00, 12,"https://cdn1.coppel.com/images/catalog/pm/2468993-1.jpg?iresize=width:300,height:240" ,  3, "Apple"));
		productsDto.add(new ProductDto((long) 4,"g5", "", (float)100.00, 23, "https://cdn1.coppel.com/images/catalog/pm/2842023-1.jpg?iresize=width:300,height:240" ,  2, "Motorola"));
		productsDto.add(new ProductDto((long) 5,"Moto g42", "", (float)100.00, 32, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" ,  2, "Motorola"));
		productsDto.add(new ProductDto((long) 6,"s20 plus", "", (float)100.00, 12, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));
		productsDto.add(new ProductDto((long) 7,"Galaxy A04E", "", (float)100.00, 7, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));
		productsDto.add(new ProductDto((long) 8,"Galaxy S22", "", (float)100.00, 9, "https://cdn1.coppel.com/images/catalog/pm/2965613-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));
		productsDto.add(new ProductDto((long) 9,"Moto E20", "", (float)100.00, 11, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" ,  2, "Motorola"));
		productsDto.add(new ProductDto((long) 10,"Aura Z", "", (float)100.00, 54,"https://cdn1.coppel.com/images/catalog/pm/2795193-1.jpg?iresize=width:300,height:240" ,  4, "Zuum"));
		productsDto.add(new ProductDto((long) 11,"Moto E32", "", (float)100.00, 42, "https://cdn1.coppel.com/images/catalog/pm/2788493-1.jpg?iresize=width:300,height:240" ,  2, "Motorola"));
		productsDto.add(new ProductDto((long) 12,"A57", "", (float)100.00, 8,"https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));
		productsDto.add(new ProductDto((long) 13,"Galaxy tab s6", "", (float)100.00, 9, "https://cdn1.coppel.com/images/catalog/pm/2810093-1.jpg?iresize=width:300,height:240" ,  1, "samsung"));
		productsDto.add(new ProductDto((long) 14,"Toy Story 7\"", "", (float)100.00, 13, "https://cdn1.coppel.com/images/catalog/pm/2953873-1.jpg?iresize=width:300,height:240" ,  5, "kempler & strauss"));
		productsDto.add(new ProductDto((long) 15,"play tab 2", "", (float)100.00, 46, "https://cdn1.coppel.com/images/catalog/pm/2140113-1.jpg?iresize=width:300,height:240" ,  6, "protab"));
		productsDto.add(new ProductDto((long) 16,"m9", "", (float)100.00, 98, "https://cdn1.coppel.com/images/catalog/pm/2128583-1.jpg?iresize=width:300,height:240" ,  7, "lenovo"));
		productsDto.add(new ProductDto((long) 17,"ipad 10", "", (float)100.00, 82, "https://cdn1.coppel.com/images/catalog/pm/2958593-1.jpg?iresize=width:300,height:240" ,  3, "apple"));
		productsDto.add(new ProductDto((long) 18,"A57", "", (float)100.00, 65, "https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));
		productsDto.add(new ProductDto((long) 19,"A57", "", (float)100.00, 19, "https://cdn1.coppel.com/images/catalog/pm/2952983-1.jpg?iresize=width:300,height:240" ,  1, "Samsung"));

		

		
		return productsDto;
		
	}
	
	
	
}
