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

import raqc.apistore.dto.BrandDto;
import raqc.apistore.dto.OrderDto;
import raqc.apistore.model.Order;
import raqc.apistore.model.Product;
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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenes/usuario/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<Order> allOrdersByUserId(@PathVariable Long id){
		System.out.println("* ------- /ordenes/usuario/" + id);
		List<Order> order = orderService.findAllByUserId(id);
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::allOrdersByUserId() \n     size: " + order.size());
		return order;
	}
	
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  orderById(@PathVariable Long id){
		System.out.println("* ------- /ordenes/" + id);
		Order order = null;
		String response = "";
		try {
			
			order = orderService.findById(id);
			
		}catch(DataAccessException e) {
			response = "Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::orderById() \n     " + response);
			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(order==null) {
			response ="La orden con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::orderById() \n     " + response);
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::orderByid() \n     " + order.getOrderproducts().toString());
		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	}
	
	
	
	@CrossOrigin
	@PostMapping("/checkout")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  save(@RequestBody OrderDto orderDto){
		System.out.println("* ------- /checkout     ");
		Order order = null;
		String response = "";
		try {
			
			order = orderService.register(orderDto);


			
		}catch(DataAccessException e) {
			response = "* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n   Error al tratar de registrar la orden \n";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n     " + response);

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(order==null) {
			response ="No ha sido posible registrar la orden";
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n     " + response);
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n     " + response 
				+ "\n " + order.toString());
		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/ordenes/update-status")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  update(@RequestBody OrderDto orderDto){
		System.out.println("* ------- /ordenes/update-status     ");
		System.out.println("\n* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::update() \n    " + orderDto.toString());
		Order order = null;
		String response = "";
		try {
			
			order = orderService.update(orderDto);


			
		}catch(DataAccessException e) {
			response = "* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n   Error al tratar de registrar la orden \n";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n     " + response);

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(order==null) {
			response ="No ha sido posible registrar la orden";
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::save() \n     " + response);
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}
		System.out.println("\n* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::update() \n     " 
				+  order.toString());
		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	
	}
	
}
