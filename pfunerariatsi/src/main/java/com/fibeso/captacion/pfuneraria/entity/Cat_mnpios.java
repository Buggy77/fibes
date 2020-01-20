package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity(name="Cat_mnpios")
@Table(name="\"cat_mnpios\"", schema="esqfibeso")
public class Cat_mnpios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -575671984265644670L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`IdRegMnpioS`", nullable = false)
	private String idRegMnpioS;
	
	@Column(name = "`DescMnpio`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 100)
	private String descMnpio;
	
	//@OneToOne(mappedBy = "municipio")
	//private Clientes cliente;
	
	@OneToMany(mappedBy = "municipio",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Clientes> clientes;
	
	public void addCliente(Clientes cliente) {
		clientes.add(cliente);
		cliente.setMunicipio(this);
	}
	
	public void removeCliente(Clientes cliente) {
		clientes.remove(cliente);
		//cliente.setMunicipio(this);
		cliente.setMunicipio(null);
	}
	
	//@OneToMany(mappedBy = "idRegMnpioS",
	@OneToMany(mappedBy = "cat_mnpios",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Direcciones> direcciones;
	
	public void addDireccion(Direcciones direccion) {
		direcciones.add(direccion);
		//direccion.setIdRegMnpioS(this);
		direccion.setCat_mnpios(this);
	}
	
	public void removeDireccion(Direcciones direccion) {
		direcciones.remove(direccion);
		//direccion.setIdRegMnpioS(this);
		//direccion.setCat_mnpios(this);
		direccion.setCat_mnpios(null);
	}
		
	@OneToMany(mappedBy = "municipios",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenios(Convenios convenio) {
		convenios.add(convenio);
		convenio.setMunicipios(this);
	}
	
	public void removeConvenios(Convenios convenio) {
		convenios.remove(convenio);
		//convenio.setMunicipios(this);
		convenio.setMunicipios(null);
	}
	//public Cat_mnpios(String descMnpio) {
		//	this.descMnpio = descMnpio;
		//}
	
	public Cat_mnpios() {
		super();
	}
	
	public Cat_mnpios(String id) {
		super();
		this.idRegMnpioS = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat_mnpios other = (Cat_mnpios) obj;
		if (descMnpio == null) {
			if (other.descMnpio != null)
				return false;
		} else if (!descMnpio.equals(other.descMnpio))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descMnpio == null) ? 0 : descMnpio.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cat_mnpios [descMnpio=" + descMnpio + "]";
	}

	
	
}
