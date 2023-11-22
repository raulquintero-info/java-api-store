package raqc.apistore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import raqc.apistore.model.Cart;
import raqc.apistore.service.CartService;
import raqc.apistore.dto.UserDto;



@RestController
@RequestMapping("/api")
public class CartController {

	
	
	@Autowired
	private CartService cartService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/carrito")
	@ResponseStatus(HttpStatus.OK)
	public List<Cart> getCart(){
	

		return cartService.findAll();	
		
	}
	
	
}
