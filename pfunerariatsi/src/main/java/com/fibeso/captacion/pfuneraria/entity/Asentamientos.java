package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="Asentamientos")
@Table(name="\"asentamientos\"", schema="esqfibeso")
@EqualsAndHashCode
public class Asentamientos implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8747152647883284082L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`IdRegAsentaS`", nullable = false)
	private String idRegAsentaS;
	
	@Column(name = "`DescAsentaS`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 250)
	private String descAsentaS;
	
	//@OneToOne(mappedBy = "colonia")
	//private Clientes cliente;
	
	//@OneToMany(mappedBy = "colonia",
	//		cascade = CascadeType.ALL,
	//		orphanRemoval = true)
	@OneToMany(mappedBy = "asentamientos",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Clientes> clientes;
	//private List<Clientes> clientes;
	
	public void addCliente(Clientes cliente) {
		clientes.add(cliente);
		//cliente.setColonia(this);
		cliente.setAsentamientos(this);
	}
	public void removeCliente(Clientes cliente) {
		clientes.remove(cliente);
		//cliente.setColonia(this);
		//cliente.setAsentamientos(this);
		cliente.setAsentamientos(null);
	}
	
	//@OneToMany(mappedBy = "idRegAsentaS",
	@OneToMany(mappedBy = "asentamientos",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Direcciones> direcciones;
	
	public void addDireccion(Direcciones direccion) {
		direcciones.add(direccion);
		//direccion.setIdRegAsentaS(this);
		direccion.setAsentamientos(this);
	}
	
	public void removeDireccion(Direcciones direccion) {
		direcciones.remove(direccion);
		//direccion.setIdRegAsentaS(this);
		//direccion.setAsentamientos(this);
		direccion.setAsentamientos(null);
	}
	
	//@Size(min = 1)
	//@OneToOne(fetch = FetchType.LAZY, 
	//		cascade = CascadeType.ALL)
	//@JoinColumn(name = "`IdRegTipoS`")  //Corresponde a la columna de la clase (this)
	//private Cat_asentamientos idRegTipoS;
	
	@Column(name = "`IdRegTipoS`", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 2)
	private String idRegTipoS;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "`IdRegTipoS`",unique = true)
	//@JoinColumn(name = "`IdRegTipoS`", insertable=false, updatable=false)
	@JoinColumn(name = "`IdRegTipoS`", referencedColumnName = "`IdRegTipoS`", insertable=false, updatable=false)
	private Cat_asentamientos cat_asentamientos;
	
	public Asentamientos() {
		super();
	}
	
	public Asentamientos(String id) {
		super();
		this.idRegAsentaS = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asentamientos other = (Asentamientos) obj;
		if (descAsentaS == null) {
			if (other.descAsentaS != null)
				return false;
		} else if (!descAsentaS.equals(other.descAsentaS))
			return false;
		if (idRegTipoS == null) {
			if (other.idRegTipoS != null)
				return false;
		} else if (!idRegTipoS.equals(other.idRegTipoS))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descAsentaS == null) ? 0 : descAsentaS.hashCode());
		result = prime * result + ((idRegTipoS == null) ? 0 : idRegTipoS.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "Asentamientos [descAsentaS=" + descAsentaS + ", idRegTipoS=" + idRegTipoS + "]";
	}
	
	
	//public Asentamientos(String descAsentaS, Cat_asentamientos idRegTipoS) {
	//	this.descAsentaS = descAsentaS;
	//	this.idRegTipoS = idRegTipoS;
	//}
}
