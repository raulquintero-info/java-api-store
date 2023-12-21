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


import raqc.apistore.dto.OrderDto;
import raqc.apistore.model.Order;
import raqc.apistore.service.OrderService;



@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenes")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> allOrders(){
		return orderService.findAll();		
	}
	
}
