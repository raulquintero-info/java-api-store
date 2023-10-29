package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.dto.ProductsDto;



@RestController
@RequestMapping("/api")

public class ProductController {

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List< ProductsDto > consulta(){
		
		
		List<ProductsDto> productsDto = new ArrayList<ProductsDto>(); 
		productsDto.add(new ProductsDto("Lentes Oakley SteelGray", "", (float) 100.00, "", (long) 1));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 1));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 2));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 2));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 3));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 3));
		productsDto.add(new ProductsDto("", "", (float) 100.00, "", (long) 4));
		
		

		
		return productsDto;
		
	}
	
	
	
}
