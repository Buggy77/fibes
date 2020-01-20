package com.fibeso.captacion.pfuneraria.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;

@Repository
public interface UsuariosOperadorRepository extends CrudRepository<UsuariosOperador, Integer> {
//public interface UsuariosOperadorRepository extends JpaRepository<UsuariosOperador, Integer> {

	//public Set<UsuariosOperador> findByIdOperador(String idOperador);
	public Optional<UsuariosOperador> findByIdOperador(String idOperador);
	public Set<UsuariosOperador> findByNombre(String nombre);
	public Set<UsuariosOperador> findAllByActivo(Boolean activo);
}
