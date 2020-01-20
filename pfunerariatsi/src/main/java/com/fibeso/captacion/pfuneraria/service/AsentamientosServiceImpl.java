package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Asentamientos;
import com.fibeso.captacion.pfuneraria.repository.AsentamientosRepository;

@Service
public class AsentamientosServiceImpl implements AsentamientosService {

	@Autowired
	AsentamientosRepository asentamientosrepo;
	
	@Override
	public Iterable<Asentamientos> getAllAsentamientos() {
		return asentamientosrepo.findAll();
	}

}
