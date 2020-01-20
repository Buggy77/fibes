package com.fibeso.captacion.pfuneraria.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Cat_cps;
import com.fibeso.captacion.pfuneraria.entity.Direcciones;
import com.fibeso.captacion.pfuneraria.repository.DireccionesRepository;

@Service
public class DireccionesServiceImpl implements DireccionesService {

	@Autowired
	DireccionesRepository direccionesrepo;
	
	@Override
	public Iterable<Direcciones> getAllDirecciones() {
		return direccionesrepo.findAll();
	}

	@Override
	public Set<Direcciones> getAllDireccionesByCp(Cat_cps cp) {
		return direccionesrepo.findAllByCp(cp);
	}

}
