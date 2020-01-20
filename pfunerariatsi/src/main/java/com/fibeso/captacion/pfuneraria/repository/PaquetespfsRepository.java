package com.fibeso.captacion.pfuneraria.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Paquetespfs;

@Repository
public interface PaquetespfsRepository extends CrudRepository<Paquetespfs, Integer> {

	public Set<Paquetespfs> findAllByIdPaqPF(String idPaqPF);
	public Set<Paquetespfs> findAllByNombrePaq(String nombrePaq);
	
	public Iterable<Paquetespfs> findAll();
	
	@Query("SELECT p FROM Paquetespfs p\r\n" + 
			"WHERE p.idPaqPF = (:pIdPF) and p.activo = true and p.fchVigPrecPaq = (:pFchVigPF)")
	public Paquetespfs findByIdPFAndActivoAndFchVigPrecPaq(@Param("pIdPF") String idPF, @Param("pFchVigPF") String fchVigPF);	
	
	@Query("SELECT p FROM Paquetespfs p\r\n" + 
			"WHERE p.idPaqPF = (:pIdPF) and p.activo = true and p.fchVigPrecPaq = (:pFchVigPF)")
	public Paquetespfs findByIdPFAndActivoAndFchVigPrecPaq(@Param("pIdPF") String idPF, @Param("pFchVigPF") LocalDateTime fchVigPF);
	
	@Query("SELECT b FROM Paquetespfs b \r\n" + 
			"INNER JOIN Paquetexvelatorios d ON b.idPaqPF = d.idPaqPF\r\n" + 
			"WHERE d.idVelatorio = (:pIdVela)")
	public Iterable<Paquetespfs> findAll(@Param("pIdVela") String idVela);
	
}
