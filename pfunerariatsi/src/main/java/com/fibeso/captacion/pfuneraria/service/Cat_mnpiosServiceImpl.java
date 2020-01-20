package com.fibeso.captacion.pfuneraria.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;
import com.fibeso.captacion.pfuneraria.exception.Cat_mnpiosIdNoExiste;
import com.fibeso.captacion.pfuneraria.repository.Cat_mnpiosRepository;

@Service
public class Cat_mnpiosServiceImpl implements Cat_mnpiosService{
	
	@Autowired
	Cat_mnpiosRepository cat_mnpiosRepository;

	@Override
	public Iterable<Cat_mnpios> getAllCat_mnpios() {
		return cat_mnpiosRepository.findAll();
	}

	@Override
	public Cat_mnpios getCat_mnpioById(String idMnpio) throws Cat_mnpiosIdNoExiste {
		return cat_mnpiosRepository.findById(idMnpio).orElseThrow(() -> new Cat_mnpiosIdNoExiste("Clave de municipio no existe."));
	}

	//@Override
	//public Iterable<Cat_mnpios> getAllCat_mnpiosxEstado(String idEstado) {
	//	return cat_mnpiosRepository.findAll(idEstado);
	//}
	@Override
	public Set<Cat_mnpios> getAllCat_mnpiosxEstado(String idEstado) {
		return cat_mnpiosRepository.findAll(idEstado);
	}

}
