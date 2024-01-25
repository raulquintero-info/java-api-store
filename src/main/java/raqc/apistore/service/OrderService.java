package raqc.apistore.service;

import  java.util.NoSuchElementException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import raqc.apistore.dto.OrderDto;
import raqc.apistore.dto.OrderProductsDto;
import raqc.apistore.model.Order;
import raqc.apistore.model.OrderProducts;
import raqc.apistore.model.OrderStatus;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IOrderRepository;
import raqc.apistore.repository.IOrderStatusRepository;
import raqc.apistore.repository.IOrderProductsRepository;



@Service
public class OrderService {

	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private IOrderProductsRepository orderProductsRepository;
	
	@Autowired
	private IOrderStatusRepository orderStatusRepository;
	
	@Transactional(readOnly = true)
	public List<Order> findAllByUserId(Long id){
		return (List<Order>)orderRepository.findAllByUserId(id);
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAll(){
		System.out.println("hello");
		return (List<Order>)orderRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Long totalOrders() {
		return orderRepository.count();
	}
	
	@Transactional(readOnly=true)
	public  Order findById(Long id) {
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderService::findById() \n   id: " + id);
		return (Order) orderRepository.findById(id).orElse(null);
	}
	
	
	@Transactional
	public  Order update(OrderDto orderDto) {
//	public  void register(OrderDto orderDto) {
		
		Order order = (Order) orderRepository.findById(orderDto.getId()).orElse(null);
		
//		order.setId(orderDto.getId());
//		order.setUser(orderDto.getUser());
//		order.setDate(order.getDate());
//		order.setAddress1(orderDto.getAddress1());
//		order.setAddress2(orderDto.getAddress2());
//		order.setCity(orderDto.getCity());
//		order.setCountry(orderDto.getCountry());
//		order.setTotal(orderDto.getTotal());
//		order.setPickup(orderDto.isPickup());
		
//		if( order.getId()>0) {
			order.setOrderstatus(orderDto.getOrderstatus());
			order = orderRepository.save(order);
//		}
		
		System.out.println("\n* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderService::update() \n     "
				+  order.toString());
		
		return order;

	}
	@Transactional
	public  Order register(OrderDto orderDto) {
//	public  void register(OrderDto orderDto) {
		
		OrderStatus status = new OrderStatus(2L, "nueva");
		Order order = new Order();
		order.setUser(orderDto.getUser());
		order.setDate(new Date());
		order.setAddress1(orderDto.getAddress1());
		order.setAddress2(orderDto.getAddress2());
		order.setCity(orderDto.getCity());
		order.setCountry(orderDto.getCountry());
		order.setTotal(orderDto.getTotal());
		order.setPickup(orderDto.isPickup());
		order.setOrderstatus(status);
		
		
		order = orderRepository.save(order);
	
//		orderDto.getOrderproducts().forEach((oProdDto)->{
//			
//		});
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderService::register() \n     "
				+ "orderDto " + orderDto.getOrderproducts().toString() + "\n    "
				+ "order response: " + order + "\n    ");
		
		for (int i=0; i<orderDto.getOrderproducts().size(); i++) {
		
			System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderService::register() \n     "
					+ "orderProducts: " + orderDto.getOrderproducts().get(i).toString());
			
			OrderProducts oProd = new OrderProducts();
			Product prod = new Product();
			
			
			oProd.setProductId(orderDto.getOrderproducts().get(i).getId());
			oProd.setName(orderDto.getOrderproducts().get(i).getName());
			oProd.setBrand(orderDto.getOrderproducts().get(i).getBrand().getBrandname());
			oProd.setOfferPrice(orderDto.getOrderproducts().get(i).getOfferPrice());
			oProd.setPrice(orderDto.getOrderproducts().get(i).getPrice());
			oProd.setQuantity(orderDto.getOrderproducts().get(i).getQuantity());
			oProd.setImage(orderDto.getOrderproducts().get(i).getImage());
			oProd.setIsOffer(orderDto.getOrderproducts().get(i).getIsOffer());
			oProd.setOrder(order);
			
			orderProductsRepository.save(oProd);
			
		}
		System.out.println("* [" + new Throwable().getStackTrace()[0].getLineNumber() + "]OrderService::register() \n     "
				+ "orderProducts: " + orderDto.getOrderproducts().get(0).toString());
		
		return order;
		
		
//		System.out.println("[ + new Throwable().getStackTrace()[0].getLineNumber() + \"]OrderService::register() \n   orderDto: " + orderDto.toString());
//		return (Order) orderRepository.register(OrderDto);
	}
	
	
	
}
