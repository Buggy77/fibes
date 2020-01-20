package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;
import com.fibeso.captacion.pfuneraria.entity.Clientes;

@Repository
public interface BeneficiariosRepository extends CrudRepository<Beneficiarios, Integer> {

	//public Set<Beneficiarios> findAllByRfcTitular(Clientes rfcTitular);
	
	//public Set<Beneficiarios> findAllByClientesRfcAndActivoAndAnioAsegurado(String rfcTitular, Boolean activo, String anioAsegurado);
	public Iterable<Beneficiarios> findAllByClientesRfcAndActivoAndAnioAsegurado(String rfcTitular, Boolean activo, String anioAsegurado);
	
	//VALIDACIONES
	public Optional<Beneficiarios> findByIdBeneficiario(Integer id);
}
