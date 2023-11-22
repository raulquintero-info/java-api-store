package raqc.apistore.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import raqc.apistore.dto.RolDto;
import raqc.apistore.model.Rol;
import raqc.apistore.repository.IRoleRepository;

@Service
public class RoleService {
	

	@Autowired
	private IRoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public List<Rol> findAll(){
		return (List<Rol>)roleRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
	}
	
	
	
	@Transactional(readOnly=true)
	public  Rol findById(Long id) {
		return (Rol) roleRepository.findById(id).get();
	}
	
	
	

	@Transactional
	public Rol create(RolDto categoryDto) {
		
		Rol productEntity = new Rol();
		
//		productEntity.setId(categoryDto.getId());
		productEntity.setName(categoryDto.getName());
		return roleRepository.save(productEntity);
		
		
	}
	
	@Transactional
	public Rol update(RolDto categoryDto) {
		
		Rol productEntity = roleRepository.findById(categoryDto.getId())
				.orElseThrow(()-> new NoSuchElementException("Rol no encontrado con el id: " + categoryDto.getId()));
		
		productEntity.setId(categoryDto.getId());
		productEntity.setName(categoryDto.getName());
		return roleRepository.save(productEntity);
		
		
	}
	
	public void delete(Long id) {
		roleRepository.deleteById(id);
	}
	

	

}
