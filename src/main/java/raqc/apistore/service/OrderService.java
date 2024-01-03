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
import raqc.apistore.model.Order;
import raqc.apistore.model.OrderStatus;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IOrderRepository;



@Service
public class OrderService {

	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<Order> findAllByUserId(Long id){
		return (List<Order>)orderRepository.findAllByUserId(id);
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAll(){
		System.out.println("hello");
		return (List<Order>)orderRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public  Order findById(Long id) {
		System.out.println("[41]OrderService::findById() \n   id: " + id);
		return (Order) orderRepository.findById(id).orElse(null);
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
		
		return orderRepository.save(order);
		
		
//		System.out.println("[ + new Throwable().getStackTrace()[0].getLineNumber() + \"]OrderService::register() \n   orderDto: " + orderDto.toString());
//		return (Order) orderRepository.register(OrderDto);
	}
	
	
	
}
