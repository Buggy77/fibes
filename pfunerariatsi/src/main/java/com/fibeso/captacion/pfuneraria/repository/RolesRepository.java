package com.fibeso.captacion.pfuneraria.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer> {

	public Set<Roles> findByDescripcionRol(String descripcionRol);
}
