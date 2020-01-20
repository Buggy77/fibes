package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;

@Repository
public interface Cat_mnpiosRepository extends CrudRepository<Cat_mnpios, String> {

	public Iterable<Cat_mnpios> findAll();
	
	public Optional<Cat_mnpios> findById(String idMnpio);
	
	//@Query("SELECT b FROM Cat_mnpios b WHERE b.idRegMnpioS IN  \r\n" + 
	//		"(SELECT DISTINCT d.idRegMnpioS FROM Direcciones d WHERE d.idRegEstadoS = (:pIdEstado))")
	//public Iterable<Cat_mnpios> findAll(@Param("pIdEstado") String idEstado);
	@Query("SELECT b FROM Cat_mnpios b WHERE b.idRegMnpioS IN  \r\n" + 
			"(SELECT DISTINCT d.idRegMnpioS FROM Direcciones d WHERE d.idRegEstadoS = (:pIdEstado))")
	public Set<Cat_mnpios> findAll(@Param("pIdEstado") String idEstado);
	
}
