package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Convenios;

@Repository
public interface ConveniosRepository extends CrudRepository<Convenios, Integer> {

	public Iterable<Convenios> findAllByActivo(Boolean activo);
	
	//public Optional<Convenios> findAllByIdTipoContratacionAndIdOperador
	//public Iterable<Convenios> findAllByIdOperadorAndActivo(String idOperador, Boolean activo);
	public Iterable<Convenios> findAllByUsuariosOperadorIdOperadorAndActivo(String idOperador, Boolean activo);
	public Optional<Convenios> findById(Integer id);
}
