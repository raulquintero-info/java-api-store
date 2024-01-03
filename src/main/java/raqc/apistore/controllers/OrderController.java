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
		return orderService.findAllByUserId(id);		
	}
	
	
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/ordenes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  orderById(@PathVariable Long id){
		
		Order order = null;
		String response = "";
		try {
			System.out.println("[50]OrderController::orderById() \n   obteniendo la orden id: " + id);
			order = orderService.findById(id);
			
		}catch(DataAccessException e) {
			response = "[52]OrderController::orderById() \n   Error al realizar la consulta.";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("error aqui 3");

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(order==null) {
			response ="La orden con el ID: ".concat(id.toString()).concat(" no existe en base de datos");
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/checkout")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  saveOrder(@RequestBody OrderDto orderDto){
		
		Order order = null;
		String response = "";
		try {
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::orderById() \n     "
					+ "cartitems" + orderDto.toString());
			order = orderService.register(orderDto);


			
		}catch(DataAccessException e) {
			response = "* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::saveOrder() \n   Error al tratar de registrar la orden";
			response = response.concat(e.getMessage().concat(e.getMostSpecificCause().toString()));
			System.out.println("* [" +new Throwable().getStackTrace()[0].getLineNumber() + "]OrderController::saveOrder() \n   " + response.concat(e.getMessage().concat(e.getMostSpecificCause().toString())));

			return new ResponseEntity<String>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(order==null) {
			response ="No ha sido posible registrar la orden";
			return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Order>(order, HttpStatus.OK);	
	
	}
	
	
}
