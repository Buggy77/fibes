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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity(name="Cat_cps")
@Table(name="\"cat_cps\"", schema="esqfibeso")
public class Cat_cps implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4462745711019686838L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Min(1)
	@Column(name = "`CP`", nullable = false, columnDefinition = "NUMERIC")
	private long cp;
	
	//@OneToOne(mappedBy = "cp")
	//private Clientes cliente;
	
	//@OneToMany(mappedBy = "cp",
	//		cascade = CascadeType.ALL,
	//		orphanRemoval = true)
	@OneToMany(mappedBy = "cat_cps",
	cascade = CascadeType.ALL,
	orphanRemoval = true)
	private Set<Clientes> clientes;
	
	public void addCliente(Clientes cliente) {
		clientes.add(cliente);
		//cliente.setCp(this);
		cliente.setCat_cps(this);
	}
	
	public void removeCliente(Clientes cliente) {
		clientes.remove(cliente);
		//cliente.setCp(this);
		//cliente.setCat_cps(this);
		cliente.setCat_cps(null);
	}
	
	//@OneToMany(mappedBy = "cp",
	@OneToMany(mappedBy = "cat_cps",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Direcciones> direcciones;
	
	public void addDireccion(Direcciones direccion) {
		direcciones.add(direccion);
		//direccion.setCp(this);
		direccion.setCat_cps(this);
	}
	
	public void removeDireccion(Direcciones direccion) {
		direcciones.remove(direccion);
		//direccion.setCp(this);
		//direccion.setCat_cps(this);
		direccion.setCat_cps(null);
	}
	
	public Cat_cps() {
		super();
	}
	
	public Cat_cps(long id) {
		super();
		this.cp = id;
	}
	
}
