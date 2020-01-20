package com.fibeso.captacion.pfuneraria.service;

import java.util.Set;

import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;

public interface Cat_mnpiosService {

	public Iterable<Cat_mnpios> getAllCat_mnpios();
	
	//public Iterable<Cat_mnpios> getAllCat_mnpiosxEstado(String idEstado);
	public Set<Cat_mnpios> getAllCat_mnpiosxEstado(String idEstado);
	
	public Cat_mnpios getCat_mnpioById(String idMnpio) throws Exception;
	
}
