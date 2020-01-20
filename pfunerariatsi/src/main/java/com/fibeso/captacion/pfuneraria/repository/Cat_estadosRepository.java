package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Cat_estados;

@Repository
public interface Cat_estadosRepository extends CrudRepository<Cat_estados, String> {

	public Iterable<Cat_estados> findAll();
	
	public Optional<Cat_estados> findById(String idEstado);
	
}
