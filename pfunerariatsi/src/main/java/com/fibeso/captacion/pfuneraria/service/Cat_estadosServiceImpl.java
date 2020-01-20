package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Cat_estados;
import com.fibeso.captacion.pfuneraria.exception.Cat_estadosIdNoExiste;
import com.fibeso.captacion.pfuneraria.repository.Cat_estadosRepository;

@Service
public class Cat_estadosServiceImpl implements Cat_estadosService{

	@Autowired
	Cat_estadosRepository cat_estadosRepository;

	@Override
	public Iterable<Cat_estados> getAllCat_estados() {
		return cat_estadosRepository.findAll();
	}

	@Override
	public Cat_estados getCat_estadoById(String idEstado) throws Cat_estadosIdNoExiste {
		return cat_estadosRepository.findById(idEstado).orElseThrow(() -> new Cat_estadosIdNoExiste("Clave de estado no existe."));
	}	
	
}
