package com.fibeso.captacion.pfuneraria.service;

import java.util.Optional;

import com.fibeso.captacion.pfuneraria.entity.Convenios;

public interface ConveniosService {
	
	public Iterable<Convenios> getAllConvenios();
	
	public Iterable<Convenios> getAllConveniosActivosporOperador(String idOperador);
	
	public Convenios getConvenioById(Integer idReg) throws Exception;

}
