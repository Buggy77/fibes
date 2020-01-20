package com.fibeso.captacion.pfuneraria.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Asentamientos;

@Repository
public interface AsentamientosRepository extends CrudRepository<Asentamientos, String> {

	
}
