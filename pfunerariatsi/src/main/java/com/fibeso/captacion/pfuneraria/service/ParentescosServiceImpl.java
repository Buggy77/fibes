package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Parentescos;
import com.fibeso.captacion.pfuneraria.exception.ParentescosNoExiste;
import com.fibeso.captacion.pfuneraria.repository.ParentescosRepository;

@Service
public class ParentescosServiceImpl implements ParentescosService {

	@Autowired
	ParentescosRepository parRepository;
	
	@Override
	public Iterable<Parentescos> getAllParentescos() {
		return parRepository.findAllByActivo(true);
	}

	@Override
	public Parentescos getParentescoById(Integer id) throws ParentescosNoExiste {
		return parRepository.findById(id).orElseThrow(() -> new ParentescosNoExiste("El id de parentesco no existe."));
	}

	@Override
	public Parentescos getParentescoByIdParentesco(String idParentesco) throws ParentescosNoExiste {
		return parRepository.findByIdParentesco(idParentesco).orElseThrow(() -> new ParentescosNoExiste("El id de parentesco no existe"));
	}

}
