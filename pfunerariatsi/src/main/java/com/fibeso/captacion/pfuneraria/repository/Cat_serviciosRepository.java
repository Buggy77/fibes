package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Cat_servicios;

@Repository
public interface Cat_serviciosRepository extends CrudRepository<Cat_servicios, Integer> {

	//public Set<Cat_servicios> findAllByActivo(Boolean activo);
	public Iterable<Cat_servicios> findAllByActivo(Boolean activo);
	
	public Optional<Cat_servicios> findByIdTipoContratacionAndActivo(String idTipo, Boolean activo);
	
}
