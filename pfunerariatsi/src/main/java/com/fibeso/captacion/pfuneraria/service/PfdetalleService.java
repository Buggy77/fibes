package com.fibeso.captacion.pfuneraria.service;

import java.time.LocalDateTime;

import com.fibeso.captacion.pfuneraria.entity.Pfdetalle;

public interface PfdetalleService {

	public Pfdetalle getPFxIdAndFchVigPrec(String idPaqPF, LocalDateTime fechVigPrec, String anioPF) throws Exception;
	
}
