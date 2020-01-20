package com.fibeso.captacion.pfuneraria.service;

import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Parentescos;

@Repository
public interface ParentescosService {

	public Iterable<Parentescos> getAllParentescos();
	
	public Parentescos getParentescoById(Integer id) throws Exception;
	
	public Parentescos getParentescoByIdParentesco(String idParentesco) throws Exception;
	
}
