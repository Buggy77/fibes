package com.fibeso.captacion.pfuneraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;
import com.fibeso.captacion.pfuneraria.exception.UsuarioOperadorNoExiste;
import com.fibeso.captacion.pfuneraria.repository.UsuariosOperadorRepository;

@Service
public class UsuariosOperadorServiceImpl implements UsuariosOperadorService {

	@Autowired
	UsuariosOperadorRepository repository;
	
	@Override
	public Iterable<UsuariosOperador> getAllUsuariosOperador() {
		return repository.findAllByActivo(true);
	}

	@Override
	public UsuariosOperador getUsuarioOperadorById(String idUsrOpera) throws UsuarioOperadorNoExiste {
		return repository.findByIdOperador(idUsrOpera).orElseThrow(() -> new UsuarioOperadorNoExiste("Clave de usuario operador no existe."));
	}

}
