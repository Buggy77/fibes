package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name="Cat_estados")
@Table(name="\"cat_estados\"", schema="esqfibeso")
public class Cat_estados implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2420389357664135052L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`IdRegEstadoS`", nullable = false)
	private String idRegEstadoS;
	
	@Column(name = "`DescEstado`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 100)
	private String descEstado;
	
	//@OneToOne(mappedBy = "estado")
	//private Clientes cliente;
	@OneToMany(mappedBy = "estado",
			cascade = CascadeType.ALL)
			//orphanRemoval = true)
	//@JoinColumn(name = "`IdRegEstadoS`", referencedColumnName = "`estado`", insertable = false, updatable = false)
	private Set<Clientes> clientes;
	
	public void addCliente(Clientes cliente) {
		clientes.add(cliente);
		cliente.setEstado(this);
	}
	
	public void removeCliente(Clientes cliente) {
		clientes.remove(cliente);
		//cliente.setEstado(this);
		cliente.setEstado(null);
	}
	
	//@OneToMany(mappedBy = "idRegEstadoS",
	@OneToMany(mappedBy = "cat_estados",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Direcciones> direcciones;
	
	public void addDireccion(Direcciones direccion) {
		direcciones.add(direccion);
		//direccion.setIdRegEstadoS(this);
		direccion.setCat_estados(this);
	}
	
	public void removeDireccion(Direcciones direccion) {
		direcciones.remove(direccion);
		//direccion.setIdRegEstadoS(this);
		//direccion.setCat_estados(this);
		direccion.setCat_estados(null);
	}
	
	@OneToMany(mappedBy = "estados",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenio(Convenios convenio) {
		convenios.add(convenio);
		convenio.setEstados(this);
	}
	
	public void removeConvenio(Convenios convenio) {
		convenios.add(convenio);
		//convenio.setEstados(this);
		convenio.setEstados(null);
	}
	
	//public Cat_estados(String descEstado) {
	//	this.descEstado = descEstado;
	//}
	
	public Cat_estados() {
		super();
	}
	
	public Cat_estados(String id) {
		super();
		this.idRegEstadoS = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat_estados other = (Cat_estados) obj;
		if (descEstado == null) {
			if (other.descEstado != null)
				return false;
		} else if (!descEstado.equals(other.descEstado))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descEstado == null) ? 0 : descEstado.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cat_estados [descEstado=" + descEstado + "]";
	}
	
	
	
}
