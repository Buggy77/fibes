package com.fibeso.captacion.pfuneraria.service;

import com.fibeso.captacion.pfuneraria.entity.Cat_estados;

public interface Cat_estadosService {

	public Iterable<Cat_estados> getAllCat_estados();
	
	public Cat_estados getCat_estadoById(String idEstado) throws Exception;
}
