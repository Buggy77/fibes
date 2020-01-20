package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Parentescos;

@Repository
public interface ParentescosRepository extends CrudRepository<Parentescos, Integer> {

	public Set<Parentescos> findAllByActivo(Boolean activo);
	
	public Optional<Parentescos> findById(Integer id);
	
	public Optional<Parentescos> findByIdParentesco(String idParentesco);
}
