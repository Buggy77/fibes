package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Velatorios;

@Repository
public interface VelatoriosRepository extends CrudRepository<Velatorios, Integer> {

	public Set<Velatorios> findAllByIdVelatorio(String idVelatorio);
	public Set<Velatorios> findAllByNomVelatorio(String nomVelatorio);
	
	public Iterable<Velatorios> findAll();
	public Optional<Velatorios> findByIdVelatorio(String idVela);
	public Optional<Velatorios> findByNomVelatorio(String nomVela);
	
}
