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

import raqc.apistore.dto.HumanDto;
import raqc.apistore.dto.RolDto;
import raqc.apistore.model.Category;
import raqc.apistore.model.Human;
import raqc.apistore.model.Rol;
import raqc.apistore.repository.IHumanRepository;




@Service
public class HumanService {

	@Autowired
	private IHumanRepository humanRepository;
	
	@Transactional(readOnly = true)
	public List<Human> findAll(){
		return (List<Human>)humanRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	@Transactional(readOnly=true)
	public  Human findById(Long id) {
		return (Human) humanRepository.findById(id).get();
	}
	
	@Transactional(readOnly=true)
	public  Human findHumanByUserId(Long id) {
		return (Human) humanRepository.findHumanByUserId(id);
	}
	
	@Transactional
	public Human update(Human human) {
		
		System.out.println("human>>>>>" + human.toString());

		Human humanEntity = humanRepository.findById(human.getId())
				.orElseThrow(()-> new NoSuchElementException("Humano no encontrado con el id: " + human.getId()));
		
		System.out.println("humanId>>>>>" + human.getId().toString());
		humanEntity.setId(human.getId());
		humanEntity.setName(human.getName());
		humanEntity.setLastname(human.getLastname());
		humanEntity.setUser(human.getUser());
		humanEntity.setEmail(human.getEmail());
		humanEntity.setAddress1(human.getAddress1());
		humanEntity.setAddress2(human.getAddress2());
		humanEntity.setCity(human.getCity());
		humanEntity.setCountry(human.getCountry());
		humanEntity.setTelephone(human.getTelephone());
		humanEntity.setPostalcode(human.getPostalcode());
		
		return humanRepository.save(humanEntity);
		
		
	}
	
	
	public Human create(Human human) {
	
		Human humanEntity = new Human();
		
		humanEntity.setName(human.getName());
		humanEntity.setLastname(human.getLastname());
		humanEntity.setUser(human.getUser());
		humanEntity.setEmail(human.getEmail());
		humanEntity.setAddress1(human.getAddress1());
		humanEntity.setAddress2(human.getAddress2());
		humanEntity.setCity(human.getCity());
		humanEntity.setCountry(human.getCountry());
		humanEntity.setTelephone(human.getTelephone());
		humanEntity.setPostalcode(human.getPostalcode());
		
		
		
		return humanRepository.save(humanEntity);
		
	}
	
	
	
	
}
