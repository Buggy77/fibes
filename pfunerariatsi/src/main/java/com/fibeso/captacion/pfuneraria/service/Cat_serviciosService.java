package com.fibeso.captacion.pfuneraria.service;

import com.fibeso.captacion.pfuneraria.entity.Cat_servicios;

public interface Cat_serviciosService {

	public Iterable<Cat_servicios> getAllCat_serviciosActivos();
	
	public Cat_servicios getCat_servicioById(Integer idReg) throws Exception;
	
	public Cat_servicios getByIdTipoContratacion(String idTipoCont) throws Exception;
	
}
