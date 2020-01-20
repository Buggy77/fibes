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
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name="Parentescos")
@Table(name="\"parentescos\"", schema="esqfibeso")
public class Parentescos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6812370776304465823L;

	@Id
	@SequenceGenerator(name="aliseq6",
    //sequenceName="parentescos_IdReg_seq",
			sequenceName="`parentescos_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq6")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Integer idReg;
	
	@NaturalId
	@Column(name = "`IdParentesco`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10)
	private String idParentesco;
	
	//@OneToMany(mappedBy = "idParentesco",
	//		cascade = CascadeType.ALL,
	//		orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "parentesco",
	cascade = CascadeType.ALL,
	orphanRemoval = true)
	private Set<Beneficiarios> beneficiarios;
	
	public void addBeneficiario(Beneficiarios beneficiario) {
		beneficiarios.add(beneficiario);
		//beneficiario.setIdParentesco(this);
		beneficiario.setParentesco(this);
	}
	
	public void removeBeneficiario(Beneficiarios beneficiario) {
		beneficiarios.remove(beneficiario);
		//beneficiario.setIdParentesco(this);
		//beneficiario.setParentesco(this);
		beneficiario.setParentesco(null);
	}
	
	@Column(name = "`NombrePar`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombrePar;
	
	@Column(name = "`DescPar`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 100)
	private String descPar;
	
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
	
	public Parentescos() {
		super();
	}
	
	public Parentescos(Integer idReg) {
		this.idReg = idReg;
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
		Parentescos other = (Parentescos) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (descPar == null) {
			if (other.descPar != null)
				return false;
		} else if (!descPar.equals(other.descPar))
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
		if (idParentesco == null) {
			if (other.idParentesco != null)
				return false;
		} else if (!idParentesco.equals(other.idParentesco))
			return false;
		if (nombrePar == null) {
			if (other.nombrePar != null)
				return false;
		} else if (!nombrePar.equals(other.nombrePar))
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
		result = prime * result + ((descPar == null) ? 0 : descPar.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((idParentesco == null) ? 0 : idParentesco.hashCode());
		result = prime * result + ((nombrePar == null) ? 0 : nombrePar.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Parentescos [idParentesco=" + idParentesco + ", nombrePar=" + nombrePar + ", descPar=" + descPar
				+ ", activo=" + activo + ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg="
				+ fchModReg + ", usrModReg=" + usrModReg + "]";
	}
	*/
	
	
	
}
