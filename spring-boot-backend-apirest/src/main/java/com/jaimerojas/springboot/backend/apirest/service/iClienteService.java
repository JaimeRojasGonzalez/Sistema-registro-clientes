package com.jaimerojas.springboot.backend.apirest.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimerojas.springboot.backend.apirest.models.entity.Cliente;
import com.jaimerojas.springboot.backend.apirest.models.entity.Region;

public interface iClienteService {

	public List<Region> findAllRegiones();
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);

	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);

	public void delete(Long id);

}
