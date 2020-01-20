package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fibeso.captacion.pfuneraria.util.Generos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name="Paquetespfs")
@Table(name="\"paquetes_pfs\"", schema="esqfibeso")
public class Paquetespfs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3248014228088728719L;

	@Id
	@SequenceGenerator(name="aliseq9",
    //sequenceName="paquetes_pfs_IdReg_seq",
			sequenceName="`paquetes_pfs_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq9")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Integer idReg;
	
	@NaturalId
	@Column(name = "`IdPaqPF`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10)
	private String idPaqPF;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "paquetespfs",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Paquetexvelatorios> paquetexvelatorios;
	
	public void addPaquetexvelatorios(Paquetexvelatorios paquetexvelatorio) {
		paquetexvelatorios.add(paquetexvelatorio);
		paquetexvelatorio.setPaquetespfs(this);
	}
	
	public void removePaquetexvelatorios(Paquetexvelatorios paquetexvelatorio) {
		paquetexvelatorios.remove(paquetexvelatorio);
		//paquetexvelatorio.setPaquetespfs(this);
		paquetexvelatorio.setPaquetespfs(null);
	}
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "paquetespfs",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenios(Convenios convenio) {
		convenios.add(convenio);
		convenio.setPaquetespfs(this);
	}
	
	public void removeConvenios(Convenios convenio) {
		convenios.remove(convenio);
		//convenio.setPaquetespfs(this);
		convenio.setPaquetespfs(null);
	}
	
	@Column(name = "`NombrePaq`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 30)
	private String nombrePaq;
	
	@Column(name = "`DescPaq`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 300)
	private String descPaq;
	
	@Column(name = "`ServiciosPaq`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 300)
	private String serviciosPaq;
	
	@Column(name = "`PrecioPaq`",nullable = false)
	@NotNull
	@NotEmpty
	private Double precioPaq;
	
	@Column(name = "`PrecioAse`",nullable = false)
	@NotNull
	@NotEmpty
	private Double precioAse;
	
	@Column(name = "`FchVigPrecPaq`",nullable = false)
	@NotNull
	@NotEmpty
	//@DateTimeFormat
	//@LocalDateTime
	//@CreationTimestamp
	//@DateTimeFormat(iso = ISO.DATE)
	//@Temporal(TemporalType.TIMESTAMP)
	//private Date fchVigPrecPaq;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDateTime fchVigPrecPaq;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	//@NotEmpty
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
	
	public Paquetespfs() {
		super();
	}
	
	public Paquetespfs(Integer id) {
		super();
		this.idReg = id;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquetespfs other = (Paquetespfs) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (descPaq == null) {
			if (other.descPaq != null)
				return false;
		} else if (!descPaq.equals(other.descPaq))
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
		if (fchVigPrecPaq == null) {
			if (other.fchVigPrecPaq != null)
				return false;
		} else if (!fchVigPrecPaq.equals(other.fchVigPrecPaq))
			return false;
		if (idPaqPF == null) {
			if (other.idPaqPF != null)
				return false;
		} else if (!idPaqPF.equals(other.idPaqPF))
			return false;
		if (nombrePaq == null) {
			if (other.nombrePaq != null)
				return false;
		} else if (!nombrePaq.equals(other.nombrePaq))
			return false;
		if (precioAse == null) {
			if (other.precioAse != null)
				return false;
		} else if (!precioAse.equals(other.precioAse))
			return false;
		if (precioPaq == null) {
			if (other.precioPaq != null)
				return false;
		} else if (!precioPaq.equals(other.precioPaq))
			return false;
		if (serviciosPaq == null) {
			if (other.serviciosPaq != null)
				return false;
		} else if (!serviciosPaq.equals(other.serviciosPaq))
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
		result = prime * result + ((descPaq == null) ? 0 : descPaq.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((fchVigPrecPaq == null) ? 0 : fchVigPrecPaq.hashCode());
		result = prime * result + ((idPaqPF == null) ? 0 : idPaqPF.hashCode());
		result = prime * result + ((nombrePaq == null) ? 0 : nombrePaq.hashCode());
		result = prime * result + ((precioAse == null) ? 0 : precioAse.hashCode());
		result = prime * result + ((precioPaq == null) ? 0 : precioPaq.hashCode());
		result = prime * result + ((serviciosPaq == null) ? 0 : serviciosPaq.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Paquetespfs [idPaqPF=" + idPaqPF + ", nombrePaq=" + nombrePaq + ", descPaq=" + descPaq
				+ ", serviciosPaq=" + serviciosPaq + ", precioPaq=" + precioPaq + ", precioAse=" + precioAse
				+ ", fchVigPrecPaq=" + fchVigPrecPaq + ", activo=" + activo + ", fchCreReg=" + fchCreReg
				+ ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg + ", usrModReg=" + usrModReg + "]";
	}
	*/
	
	
}
