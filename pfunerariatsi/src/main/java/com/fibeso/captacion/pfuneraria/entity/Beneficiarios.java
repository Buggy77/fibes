package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fibeso.captacion.pfuneraria.util.Generos;
import com.fibeso.captacion.pfuneraria.util.Sino;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name="Beneficiarios")
@EntityListeners(AuditingEntityListener.class)
@Table(name="\"beneficiarios\"", schema="esqfibeso")
public class Beneficiarios implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -159592925140955501L;

	@Id
	@SequenceGenerator(name="aliseq5",
    //sequenceName="beneficiarios_IdBeneficiario_seq",
			sequenceName="`beneficiarios_IdBeneficiario_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq5")
	@Column(name = "`IdBeneficiario`", updatable=false, nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Integer idBeneficiario;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`FolioConvenio`",nullable = false, unique = true)
	//@NotNull
	//@NotEmpty
	//@Size(min = 28, max = 29)
	//private String folioConvenio;
	@Transient
	//@NotNull
	//@NotEmpty
	//@Size(min = 28, max = 29)
	private transient String folioConvenio;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`FolioConvenio`")
	//@JoinColumn(name = "`FolioConvenio`", referencedColumnName = "`FolioConvenio`", unique = true)
	//@JoinColumn(name = "`FolioConvenio`", referencedColumnName = "`FolioConvenio`", insertable=false, updatable=false)
	@JoinColumn(name = "`FolioConvenio`", referencedColumnName = "`FolioConvenio`", insertable=true, updatable=true)
	//private Convenios folioConvenio;
	private Convenios convenio;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`RfcTitular`", nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 10, max = 13)
	//private String rfcTitular;
	@Transient
	//@Column(name = "`RfcTitular`", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 10, max = 13)
	private transient String rfcTitular;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`RfcTitular`", unique = true)
	//@JoinColumn(name = "`RfcTitular`", referencedColumnName = "`Rfc`", unique = true)
	//@JoinColumn(name = "`RfcTitular`", referencedColumnName = "`Rfc`", insertable=false, updatable=false)
	@JoinColumn(name = "`RfcTitular`", referencedColumnName = "`Rfc`", insertable=true, updatable=true)
	//private Clientes rfcTitular;
	private Clientes clientes;
	
	@Column(name = "`NombreBenef`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@Column(name = "`AppPBenef`")
	@Size(min = 3, max = 50)
	private String appPBenef;
	
	@Column(name = "`AppMBenef`")
	@Size(min = 3, max = 50)
	private String appMBenef;
	
	//@Column(name = "`Asegurado`",nullable = false)
	//@NotNull
	//private Boolean asegurado;
	@Column(name = "`Asegurado`",nullable = false)
	@NotNull
	private Boolean asegurado;
	//private Boolean asegurado;
	
	@Column(name = "`CostoAsegurado`")
	private Double costoAsegurado;
	
	@Column(name = "`EnfePreexiste`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 250)
	private String enfePreexiste;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`IdParentesco`",nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 3, max = 10)
	//private String idParentesco;
	@Transient
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10)
	private transient String idParentesco;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`IdParentesco`",unique = true)
	//@JoinColumn(name = "`IdParentesco`", referencedColumnName = "`IdParentesco`", unique = true)
	//@JoinColumn(name = "`IdParentesco`", referencedColumnName = "`IdParentesco`", insertable=false, updatable=false)
	@JoinColumn(name = "`IdParentesco`", referencedColumnName = "`IdParentesco`", insertable=true, updatable=true)
	//private Parentescos idParentesco;
	private Parentescos parentesco;
	
	@Column(name = "`AnioAsegurado`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 4)
	private String anioAsegurado;
	
	@Transient
	private boolean registrar;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	//@NotEmpty
	private Boolean activo;
	
	@CreatedDate
	//@Column(name = "`FchCreReg`",nullable = false)
	@Column(name = "`FchCreReg`",nullable = false, updatable = false)
	//@NotNull
	//@NotEmpty
	@DateTimeFormat
	//@CreationTimestamp
	private Date fchCreReg;
	
	@CreatedBy
	//@Column(name = "`UsrCreReg`",nullable = false)
	@Column(name = "`UsrCreReg`",nullable = false, updatable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 4, max = 20)
	private String usrCreReg;
	
	@LastModifiedDate
	@Column(name = "`FchModReg`",nullable = true)
	@DateTimeFormat
	//@UpdateTimestamp
	private Date fchModReg;
	
	@LastModifiedBy
	@Column(name = "`UsrModReg`",nullable = true)
	@Size(min = 4, max = 20)
	private String usrModReg;
	
	public Beneficiarios() {
		super();
	}
	
	public Beneficiarios(Integer id) {
		super();
		this.idBeneficiario = id;
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
		Beneficiarios other = (Beneficiarios) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (appMBenef == null) {
			if (other.appMBenef != null)
				return false;
		} else if (!appMBenef.equals(other.appMBenef))
			return false;
		if (appPBenef == null) {
			if (other.appPBenef != null)
				return false;
		} else if (!appPBenef.equals(other.appPBenef))
			return false;
		if (asegurado == null) {
			if (other.asegurado != null)
				return false;
		} else if (!asegurado.equals(other.asegurado))
			return false;
		if (costoAsegurado == null) {
			if (other.costoAsegurado != null)
				return false;
		} else if (!costoAsegurado.equals(other.costoAsegurado))
			return false;
		if (enfePreexiste == null) {
			if (other.enfePreexiste != null)
				return false;
		} else if (!enfePreexiste.equals(other.enfePreexiste))
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
		if (folioConvenio == null) {
			if (other.folioConvenio != null)
				return false;
		} else if (!folioConvenio.equals(other.folioConvenio))
			return false;
		if (idParentesco == null) {
			if (other.idParentesco != null)
				return false;
		} else if (!idParentesco.equals(other.idParentesco))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rfcTitular == null) {
			if (other.rfcTitular != null)
				return false;
		} else if (!rfcTitular.equals(other.rfcTitular))
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
		result = prime * result + ((appMBenef == null) ? 0 : appMBenef.hashCode());
		result = prime * result + ((appPBenef == null) ? 0 : appPBenef.hashCode());
		result = prime * result + ((asegurado == null) ? 0 : asegurado.hashCode());
		result = prime * result + ((costoAsegurado == null) ? 0 : costoAsegurado.hashCode());
		result = prime * result + ((enfePreexiste == null) ? 0 : enfePreexiste.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((folioConvenio == null) ? 0 : folioConvenio.hashCode());
		result = prime * result + ((idParentesco == null) ? 0 : idParentesco.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rfcTitular == null) ? 0 : rfcTitular.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Beneficiarios [folioConvenio=" + folioConvenio + ", rfcTitular=" + rfcTitular + ", nombre=" + nombre
				+ ", appPBenef=" + appPBenef + ", appMBenef=" + appMBenef + ", asegurado=" + asegurado
				+ ", costoAsegurado=" + costoAsegurado + ", enfePreexiste=" + enfePreexiste + ", idParentesco="
				+ idParentesco + ", activo=" + activo + ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg
				+ ", fchModReg=" + fchModReg + ", usrModReg=" + usrModReg + "]";
	}
	
	*/
	
}
