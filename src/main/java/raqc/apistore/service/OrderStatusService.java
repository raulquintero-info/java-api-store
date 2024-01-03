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
import raqc.apistore.model.OrderStatus;
import raqc.apistore.model.Product;
import raqc.apistore.repository.IOrderRepository;
import raqc.apistore.repository.IOrderStatusRepository;



@Service
public class OrderStatusService {

	
	@Autowired
	private IOrderStatusRepository orderStatusRepository;
	

	@Transactional(readOnly = true)
	public List<OrderStatus> findAll(){
		System.out.println("hello");
		return (List<OrderStatus>)orderStatusRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public  OrderStatus findById(Long id) {
		System.out.println("[39]OrderStatusService::findById() \n   id: "+id);
		return (OrderStatus) orderStatusRepository.findById(id).get();
	}
	
	
}
