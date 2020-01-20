package com.fibeso.captacion.pfuneraria.service;

import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;

public interface UsuariosOperadorService {

	public Iterable<UsuariosOperador> getAllUsuariosOperador();
	
	public UsuariosOperador getUsuarioOperadorById(String idUsrOpera) throws Exception;
}
