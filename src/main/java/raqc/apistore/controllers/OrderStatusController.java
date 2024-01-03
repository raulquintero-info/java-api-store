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
import raqc.apistore.model.OrderStatus;
import raqc.apistore.model.Product;
import raqc.apistore.service.OrderService;
import raqc.apistore.service.OrderStatusService;



@RestController
@RequestMapping("/api")
public class OrderStatusController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderStatusService orderStatusService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenstatus")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderStatus> allOrdersStatus(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> orderStatus getAll <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		return orderStatusService.findAll();		
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenstatus/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  orderStatusById(@PathVariable Long id){
		
		OrderStatus orderStatus = null;
		String response = "";
		try {
			orderStatus = orderStatusService.findById(id);
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(orderStatus==null) {
			response ="La orden con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<OrderStatus>(orderStatus, HttpStatus.OK);	
	}
	
	
	
	
	
}
