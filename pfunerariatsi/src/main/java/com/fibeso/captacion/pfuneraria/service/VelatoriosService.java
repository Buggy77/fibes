package com.fibeso.captacion.pfuneraria.service;

import com.fibeso.captacion.pfuneraria.entity.Velatorios;

public interface VelatoriosService {

	public Iterable<Velatorios> getAllVelatorios();
	
	public Velatorios getVelatorioByIdVelatorio(String idVela) throws Exception;
	
	public Velatorios getVelatorioByNombreVelatorio(String nombre) throws Exception;
	
}
