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

import raqc.apistore.dto.WidgetsDto;
import raqc.apistore.service.CustomerService;
import raqc.apistore.service.OrderService;
import raqc.apistore.service.ProductService;




@RestController
@RequestMapping("/api")
public class DashboardCoontroller {

	
	@Autowired
	private ProductService productService;


	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/widgets")
	@ResponseStatus(HttpStatus.OK)
	public WidgetsDto widgetsidgets(){
		System.out.println("  *************** obteniendo info de widgets   ");
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]DashboardController::widgets() \n   ");
		
		WidgetsDto widgets = new WidgetsDto();
		
		widgets.setTotalProducts(productService.getCount());
		widgets.setTotalCustomers(customerService.totalCustomers());
		widgets.setTotalOrders(orderService.totalOrders());
		
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]DashboardController::widgets() \n   " + widgets);
		
		return widgets;
		
		
	}

	
	
	
	
}
