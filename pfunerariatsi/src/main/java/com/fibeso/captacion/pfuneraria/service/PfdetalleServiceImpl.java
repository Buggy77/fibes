package com.fibeso.captacion.pfuneraria.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Pfdetalle;
import com.fibeso.captacion.pfuneraria.repository.PfdetalleRepository;

@Service
public class PfdetalleServiceImpl implements PfdetalleService {

	@Autowired
	PfdetalleRepository pfdetalleRepository;

	@Override
	public Pfdetalle getPFxIdAndFchVigPrec(String idPaqPF, LocalDateTime fechVigPrec, String anioPF) throws Exception {
		return pfdetalleRepository.findByIdPFAndActivoAndFchVigPrecPaqAndAnioPFActual(idPaqPF, fechVigPrec, anioPF);
	}
	
	
}
