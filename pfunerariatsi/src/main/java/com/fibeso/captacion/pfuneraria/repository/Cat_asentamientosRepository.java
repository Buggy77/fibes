package com.fibeso.captacion.pfuneraria.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Cat_asentamientos;

@Repository
public interface Cat_asentamientosRepository extends CrudRepository<Cat_asentamientos, String>{

	public Cat_asentamientos findByDescAsentamiento(String descAsentamiento);
	
}
