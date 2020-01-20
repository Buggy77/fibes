package com.fibeso.captacion.pfuneraria.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fibeso.captacion.pfuneraria.entity.Paquetespfs;
import com.fibeso.captacion.pfuneraria.repository.PaquetespfsRepository;

@Service
public class PaquetespfsServiceImpl implements PaquetespfsService{

	@Autowired
	PaquetespfsRepository pfRepository;

	@Override
	public Paquetespfs getPFxIdAndFchVigPrec(String idPaqPF, String fechVigPrec) throws Exception {
		return pfRepository.findByIdPFAndActivoAndFchVigPrecPaq(idPaqPF, fechVigPrec);
	}

	@Override
	public Paquetespfs getPFxIdAndFchVigPrec(String idPaqPF, LocalDateTime fechVigPrec) throws Exception {
		return pfRepository.findByIdPFAndActivoAndFchVigPrecPaq(idPaqPF, fechVigPrec);
	}

	@Override
	public Iterable<Paquetespfs> getAllPaquetespfs() {
		return pfRepository.findAll();
	}

	@Override
	public Iterable<Paquetespfs> getAllPaquetespfsxVelatorio(String idVela) {
		return pfRepository.findAll(idVela);
	}
	
	

}
