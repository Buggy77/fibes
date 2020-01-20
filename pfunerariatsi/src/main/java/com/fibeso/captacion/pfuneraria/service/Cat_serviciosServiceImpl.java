package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Cat_servicios;
import com.fibeso.captacion.pfuneraria.exception.Cat_serviciosNoExiste;
import com.fibeso.captacion.pfuneraria.repository.Cat_serviciosRepository;

@Service
public class Cat_serviciosServiceImpl implements Cat_serviciosService {

	@Autowired
	Cat_serviciosRepository cat_servRepository;
	
	@Override
	public Iterable<Cat_servicios> getAllCat_serviciosActivos() {
		return cat_servRepository.findAllByActivo(true);
	}

	@Override
	public Cat_servicios getCat_servicioById(Integer idReg) throws Cat_serviciosNoExiste{
		return cat_servRepository.findById(idReg).orElseThrow(() -> new Cat_serviciosNoExiste("Id registro de Servicio no existe."));
	}

	@Override
	public Cat_servicios getByIdTipoContratacion(String idTipoCont) throws Cat_serviciosNoExiste{
		return cat_servRepository.findByIdTipoContratacionAndActivo(idTipoCont, true).orElseThrow(() -> new Cat_serviciosNoExiste("Clave de Servicio no existe"));
	}

}
