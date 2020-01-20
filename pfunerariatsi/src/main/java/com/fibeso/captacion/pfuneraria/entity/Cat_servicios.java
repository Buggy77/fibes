package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fibeso.captacion.pfuneraria.util.Generos;

import lombok.Data;

@Data
@Entity(name="Cat_servicios")
@Table(name="\"cat_servicios\"", schema="esqfibeso")
public class Cat_servicios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7298102510056493146L;

	@Id
	@SequenceGenerator(name="aliseq10",
    //sequenceName="cat_servicios_IdReg_seq",
			sequenceName="`cat_servicios_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq10")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@NaturalId
	@Column(name = "`IdTipoContratacion`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 1)
	private String idTipoContratacion;
	
	@OneToMany(mappedBy = "catservicios",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenio(Convenios convenio) {
		convenios.add(convenio);
		convenio.setCatservicios(this);
	}
	
	public void removeConvenio(Convenios convenio) {
		convenios.remove(convenio);
		//convenio.setCatservicios(this);
		convenio.setCatservicios(null);
	}
	
	@Column(name = "`DescTipoContrata`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String descTipoContrata;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	@NotEmpty
	private Boolean activo;
	
	@Column(name = "`FchCreReg`",nullable = false)
	@NotNull
	@NotEmpty
	@DateTimeFormat
	@CreationTimestamp
	private Date fchCreReg;
	
	@Column(name = "`UsrCreReg`",nullable = false)
	@NotNull
	@NotEmpty
	private String usrCreReg;
	
	@Column(name = "`FchModReg`",nullable = true)
	@DateTimeFormat
	@UpdateTimestamp
	private Date fchModReg;
	
	@Column(name = "`UsrModReg`",nullable = true)
	private String usrModReg;
	
	public Cat_servicios() {
		super();
	}
	
	public Cat_servicios(Integer id) {
		super();
		this.idReg = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat_servicios other = (Cat_servicios) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (descTipoContrata == null) {
			if (other.descTipoContrata != null)
				return false;
		} else if (!descTipoContrata.equals(other.descTipoContrata))
			return false;
		if (fchCreReg == null) {
			if (other.fchCreReg != null)
				return false;
		} else if (!fchCreReg.equals(other.fchCreReg))
			return false;
		if (fchModReg == null) {
			if (other.fchModReg != null)
				return false;
		} else if (!fchModReg.equals(other.fchModReg))
			return false;
		if (idTipoContratacion == null) {
			if (other.idTipoContratacion != null)
				return false;
		} else if (!idTipoContratacion.equals(other.idTipoContratacion))
			return false;
		if (usrCreReg == null) {
			if (other.usrCreReg != null)
				return false;
		} else if (!usrCreReg.equals(other.usrCreReg))
			return false;
		if (usrModReg == null) {
			if (other.usrModReg != null)
				return false;
		} else if (!usrModReg.equals(other.usrModReg))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activo == null) ? 0 : activo.hashCode());
		result = prime * result + ((descTipoContrata == null) ? 0 : descTipoContrata.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((idTipoContratacion == null) ? 0 : idTipoContratacion.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Cat_servicios [idTipoContratacion=" + idTipoContratacion + ", descTipoContrata=" + descTipoContrata
				+ ", activo=" + activo + ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg="
				+ fchModReg + ", usrModReg=" + usrModReg + "]";
	}
	
	
}
