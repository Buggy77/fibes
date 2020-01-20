package com.fibeso.captacion.pfuneraria.service;

import java.util.Set;

import com.fibeso.captacion.pfuneraria.entity.Cat_cps;
import com.fibeso.captacion.pfuneraria.entity.Direcciones;

public interface DireccionesService {

	public Iterable<Direcciones> getAllDirecciones();
	
	public Set<Direcciones> getAllDireccionesByCp(Cat_cps cp);
}
