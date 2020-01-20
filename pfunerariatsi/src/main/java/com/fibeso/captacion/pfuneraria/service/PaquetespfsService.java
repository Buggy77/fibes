package com.fibeso.captacion.pfuneraria.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fibeso.captacion.pfuneraria.entity.Paquetespfs;

public interface PaquetespfsService {

	//public Paquetespfs getPaqFunxId(String idPaqPF) throws Exception;
	
	//public Paquetespfs getPaqFunxNombre(String nombrePaqPF) throws Exception;
	
	public Iterable<Paquetespfs> getAllPaquetespfs();
	
	public Iterable<Paquetespfs> getAllPaquetespfsxVelatorio(String idVela);
	
	public Paquetespfs getPFxIdAndFchVigPrec(String idPaqPF, String fechVigPrec) throws Exception;
	
	public Paquetespfs getPFxIdAndFchVigPrec(String idPaqPF, LocalDateTime fechVigPrec) throws Exception;
}
