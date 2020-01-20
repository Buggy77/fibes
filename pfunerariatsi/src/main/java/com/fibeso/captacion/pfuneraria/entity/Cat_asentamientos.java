package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name="Cat_asentamientos")
@Table(name="\"cat_asentamientos\"", schema="esqfibeso")
public class Cat_asentamientos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4411949987816221566L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "`IdRegTipoS`", nullable = false)
	private String idRegTipoS;
	
	@Column(name = "`DescAsentamiento`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 25)
	private String descAsentamiento;
	
	//@OneToOne(mappedBy = "idRegTipoS")
	//private Asentamientos asentamiento;
	
	//@OneToMany(mappedBy = "idRegTipoS",
	@OneToMany(mappedBy = "cat_asentamientos",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Asentamientos> asentamientos;
	
	public void addColonia(Asentamientos asentamiento) {
		asentamientos.add(asentamiento);
		//asentamiento.setIdRegTipoS(this);
		asentamiento.setCat_asentamientos(this);
	}
	
	public void removeColonia(Asentamientos asentamiento) {
		asentamientos.remove(asentamiento);
		//asentamiento.setIdRegTipoS(this);
		//asentamiento.setCat_asentamientos(this);
		asentamiento.setCat_asentamientos(null);
	}
	
	
	public Cat_asentamientos() {
		super();
	}
	
	public Cat_asentamientos(String id) {
		this.idRegTipoS = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat_asentamientos other = (Cat_asentamientos) obj;
		if (descAsentamiento == null) {
			if (other.descAsentamiento != null)
				return false;
		} else if (!descAsentamiento.equals(other.descAsentamiento))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descAsentamiento == null) ? 0 : descAsentamiento.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cat_asentamientos [descAsentamiento=" + descAsentamiento + "]";
	}
	
	
	//public Cat_asentamientos(String descAsentamiento) {
	//	this.descAsentamiento = descAsentamiento;
	//}
}
