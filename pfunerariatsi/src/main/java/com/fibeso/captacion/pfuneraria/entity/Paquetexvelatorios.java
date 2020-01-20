package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fibeso.captacion.pfuneraria.util.Generos;

import lombok.Data;

@Data
@Entity(name="Paquetexvelatorios")
@Table(name="\"paquete_x_velatorios\"", schema="esqfibeso")
public class Paquetexvelatorios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6839648203267379676L;

	@Id
	@SequenceGenerator(name="aliseq8",
    //sequenceName="paquete_x_velatorios_IdReg_seq",
			sequenceName="`paquete_x_velatorios_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq8")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@Column(name = "`IdVelatorio`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 3)
	private String idVelatorio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "`IdVelatorio`", referencedColumnName = "`IdVelatorio`", unique = true)
	@JoinColumn(name = "`IdVelatorio`", referencedColumnName = "`IdVelatorio`", insertable=false, updatable=false)
	private Velatorios velatorios;
	
	@Column(name = "`IdPaqPF`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10)
	private String idPaqPF;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "`IdPaqPF`", referencedColumnName = "`IdPaqPF`", unique = true)
	@JoinColumn(name = "`IdPaqPF`", referencedColumnName = "`IdPaqPF`", insertable=false, updatable=false)
	private Paquetespfs paquetespfs;
	
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
	
	public Paquetexvelatorios() {
		super();
	}
	
	public Paquetexvelatorios(Integer id) {
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
		Paquetexvelatorios other = (Paquetexvelatorios) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
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
		if (idPaqPF == null) {
			if (other.idPaqPF != null)
				return false;
		} else if (!idPaqPF.equals(other.idPaqPF))
			return false;
		if (idVelatorio == null) {
			if (other.idVelatorio != null)
				return false;
		} else if (!idVelatorio.equals(other.idVelatorio))
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
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((idPaqPF == null) ? 0 : idPaqPF.hashCode());
		result = prime * result + ((idVelatorio == null) ? 0 : idVelatorio.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Paquetexvelatorios [idVelatorio=" + idVelatorio + ", idPaqPF=" + idPaqPF + ", activo=" + activo
				+ ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg + ", usrModReg="
				+ usrModReg + "]";
	}
	
	
}
