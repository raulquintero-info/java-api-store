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

import raqc.apistore.model.Order;
import raqc.apistore.repository.IOrderRepository;



@Service
public class OrderService {

	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<Order> findAll1(){
		return (List<Order>)orderRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<Order> findAll(){
		System.out.println("hello");
		return (List<Order>)orderRepository.findAll();
	}
}
