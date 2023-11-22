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

import raqc.apistore.dto.BrandDto;
import raqc.apistore.model.Brand;
import raqc.apistore.repository.IBrandRepository;




@Service
public class BrandService {

	@Autowired
	private IBrandRepository brandRepository;
	
	@Transactional(readOnly = true)
	public List<Brand> findAll(){
		return (List<Brand>)brandRepository.findAll(Sort.by(Sort.Direction.ASC,"brandname"));
	}
	

	@Transactional(readOnly=true)
	public  Brand findById(Long id) {
		return (Brand) brandRepository.findById(id).get();
	}
	
	
	

	

	@Transactional
	public Brand create(BrandDto brandDto) {
		
		Brand brandEntity = new Brand();
		
//		brandEntity.setId(brandDto.getId());
		brandEntity.setBrandname(brandDto.getBrandname());
		return brandRepository.save(brandEntity);
		
		
	}
	
	@Transactional
	public Brand update(BrandDto brandDto) {
		
		Brand brandEntity = brandRepository.findById(brandDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Marca no encontrado con el id: " + brandDto.getId()));
		
		brandEntity.setId(brandDto.getId());
		brandEntity.setBrandname(brandDto.getBrandname());
		return brandRepository.save(brandEntity);
		
		
	}
	
	public void delete(Long id) {
		brandRepository.deleteById(id);
	}
	

	
	
}
