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

import raqc.apistore.model.Cart;
import raqc.apistore.repository.ICartRepository;



@Service
public class CartService {

	
	@Autowired
	private ICartRepository cartRepository;
	
	@Transactional(readOnly = true)
	public List<Cart> findAll(){
		return (List<Cart>)cartRepository.findAll(Sort.by(Sort.Direction.ASC,"brandname"));
	}
	
	
}
