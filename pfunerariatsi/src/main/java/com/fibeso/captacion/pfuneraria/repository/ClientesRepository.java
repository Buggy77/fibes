package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer>{

	//public Set<Clientes> findByRfc(String rfc);
	
	//COMENTADO POR CAMBIO DE VALIDACION
	//public Set<Clientes> findByRfcAndActivo(String rfc, Boolean activo);
	
	public Iterable<Clientes> findAllByActivo(Boolean activo);
	
	public Optional<Clientes> findByRfcAndActivo(String rfc, Boolean activo);
	
	//Validaciones
	public Optional<Clientes> findByRfcOrCurp(String rfc, String curp);
	//public Optional<Clientes> findByCurp(String curp);
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Clientes c SET c.activo = false WHERE c.idCliente = (:pId)")
	int guardarEstatusInactivo(@Param("pId") Integer id);
	
}
