package com.fibeso.captacion.pfuneraria.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Cat_cps;
import com.fibeso.captacion.pfuneraria.entity.Direcciones;

@Repository
public interface DireccionesRepository extends CrudRepository<Direcciones, Integer> {

	/*No utilizar, no funciona debido al tipo de objeto*/
	/*
	@Query("SELECT tb.\"IdRegAsentaS\", tb.\"DescAsentaS\", tc.\"DescAsentamiento\", \r\n" + 
			"	   td.\"IdRegMnpioS\", td.\"DescMnpio\", te.\"IdRegEstadoS\", te.\"DescEstado\" \r\n" + 
			"FROM \"direcciones\" ta INNER JOIN \"asentamientos\" tb ON\r\n" + 
			"	ta.\"IdRegAsentaS\" = tb.\"IdRegAsentaS\"\r\n" + 
			"	INNER JOIN \"cat_asentamientos\" tc ON\r\n" + 
			"	tb.\"IdRegTipoS\" = tc.\"IdRegTipoS\"\r\n" + 
			"	INNER JOIN \"cat_mnpios\" td ON\r\n" + 
			"	ta.\"IdRegMnpioS\" = td.\"IdRegMnpioS\"\r\n" + 
			"	INNER JOIN \"cat_estados\" te ON\r\n" + 
			"	ta.\"IdRegEstadoS\" = te.\"IdRegEstadoS\"\r\n" + 
			"	WHERE ta.\"CP\" = (:pCp)")
	public Set<Direcciones> findByCp(@Param("pCp") Cat_cps cp);
	*/
	@Query("SELECT d FROM Direcciones d WHERE d.cp = (:pCp)")
	public Set<Direcciones> findAllByCp(@Param("pCp") long cp);
	
	public Set<Direcciones> findAllByCp(Cat_cps cp);
	
}
