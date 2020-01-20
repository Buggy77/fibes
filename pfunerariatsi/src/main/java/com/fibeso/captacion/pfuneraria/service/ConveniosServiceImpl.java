package com.fibeso.captacion.pfuneraria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Convenios;
import com.fibeso.captacion.pfuneraria.exception.ConveniosNoExiste;
import com.fibeso.captacion.pfuneraria.repository.ConveniosRepository;

@Service
public class ConveniosServiceImpl implements ConveniosService {

	@Autowired
	ConveniosRepository conveniosrepo;
	
	@Override
	public Iterable<Convenios> getAllConvenios() {
		return conveniosrepo.findAll();
	}

	@Override
	public Iterable<Convenios> getAllConveniosActivosporOperador(String idOperador) {
		return conveniosrepo.findAllByUsuariosOperadorIdOperadorAndActivo(idOperador, true);
	}

	@Override
	public Convenios getConvenioById(Integer idReg) throws ConveniosNoExiste {
		return conveniosrepo.findById(idReg).orElseThrow(() -> new ConveniosNoExiste("Id de Convenio no existe."));
	}

	
}
