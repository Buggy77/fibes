package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Velatorios;
import com.fibeso.captacion.pfuneraria.exception.VelatoriosNoExiste;
import com.fibeso.captacion.pfuneraria.repository.VelatoriosRepository;

@Service
public class VelatoriosServiceImpl implements VelatoriosService {

	@Autowired
	VelatoriosRepository velaRepository;

	@Override
	public Iterable<Velatorios> getAllVelatorios() {
		return velaRepository.findAll();
	}

	@Override
	public Velatorios getVelatorioByIdVelatorio(String idVela) throws VelatoriosNoExiste {
		return velaRepository.findByIdVelatorio(idVela).orElseThrow(()-> new VelatoriosNoExiste("Clave de velatorio no existe."));
	}

	@Override
	public Velatorios getVelatorioByNombreVelatorio(String nombre) throws VelatoriosNoExiste {
		return velaRepository.findByNomVelatorio(nombre).orElseThrow(() -> new VelatoriosNoExiste("Nombre de velatorio no existe."));
	}
	
}
