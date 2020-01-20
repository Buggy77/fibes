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
@Entity(name="Velatorios")
@Table(name="\"velatorios_ori\"", schema="esqfibeso")
public class Velatorios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7335292648126729285L;

	@Id
	@SequenceGenerator(name="aliseq7",
    //sequenceName="velatorios_ori_IdReg_seq",
	sequenceName="`velatorios_ori_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq7")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@NaturalId
	@Column(name = "`IdVelatorio`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 3)
	private String idVelatorio;
	
	@OneToMany(mappedBy = "velatorios",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Paquetexvelatorios> paquetexvelatorios;
	
	public void addPaquetexvelatorio(Paquetexvelatorios paquetexvelatorio) {
		paquetexvelatorios.add(paquetexvelatorio);
		paquetexvelatorio.setVelatorios(this);
	}
	
	public void removePaquetexvelatorio(Paquetexvelatorios paquetexvelatorio) {
		paquetexvelatorios.remove(paquetexvelatorio);
		//paquetexvelatorio.setVelatorios(this);
		paquetexvelatorio.setVelatorios(null);
	}
	
	@OneToMany(mappedBy = "velatorios",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenios(Convenios convenio) {
		convenios.add(convenio);
		convenio.setVelatorios(this);
	}
	
	public void removeConvenios(Convenios convenio) {
		convenios.remove(convenio);
		//convenio.setVelatorios(this);
		convenio.setVelatorios(null);
	}
	
	@OneToMany(mappedBy = "velatorio",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<UsuariosOperador> usuarioOperador;
	
	public void addUsuarioOperador(UsuariosOperador usrOperador) {
		usuarioOperador.add(usrOperador);
		usrOperador.setVelatorio(this);
	}
	
	public void removeUsuarioOperador(UsuariosOperador usrOperador) {
		usuarioOperador.remove(usrOperador);
		//usrOperador.setVelatorio(this);
		usrOperador.setVelatorio(null);
	}
	
	@Column(name = "`NomVelatorio`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nomVelatorio;
	
	@Column(name = "`DirComVelatorio`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 400)
	private String dirComVelatorio;
	
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
	
	public Velatorios() {
		super();
	}
	
	public Velatorios(Integer id) {
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
		Velatorios other = (Velatorios) obj;
		if (dirComVelatorio == null) {
			if (other.dirComVelatorio != null)
				return false;
		} else if (!dirComVelatorio.equals(other.dirComVelatorio))
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
		if (idVelatorio == null) {
			if (other.idVelatorio != null)
				return false;
		} else if (!idVelatorio.equals(other.idVelatorio))
			return false;
		if (nomVelatorio == null) {
			if (other.nomVelatorio != null)
				return false;
		} else if (!nomVelatorio.equals(other.nomVelatorio))
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
		result = prime * result + ((dirComVelatorio == null) ? 0 : dirComVelatorio.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((idVelatorio == null) ? 0 : idVelatorio.hashCode());
		result = prime * result + ((nomVelatorio == null) ? 0 : nomVelatorio.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Velatorios [idVelatorio=" + idVelatorio + ", nomVelatorio=" + nomVelatorio + ", dirComVelatorio="
				+ dirComVelatorio + ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg
				+ ", usrModReg=" + usrModReg + "]";
	}
	
	
}
