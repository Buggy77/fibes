package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "\"cat_roles\"", schema = "esqfibeso")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3193163895438023031L;

	//@Id
	//@GenericGenerator(name = "nat1", strategy = "native")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Basic(optional = false)
	//@Column(name = "IdReg", nullable = false)
	//@Id
    //@SequenceGenerator(name="cust1",
    //                   sequenceName="cat_roles_IdReg_seq",
    //                   allocationSize=1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,
    //                generator="cust1")
	//@Column(name ="&quot;IdReg&quot;", updatable=false, nullable = false)
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="custseq1",
    //sequenceName="`cat_roles_idreg_seq`",
	sequenceName="`cat_roles_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custseq1")
	//@GenericGenerator(name = "native", strategy = "native")
	@Column(name ="`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@Column(name = "`IdRol`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 5)
	//@Size(min = 1)
	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(name = "usr_operadores_rol",
	//	joinColumns = @JoinColumn(name = "IdRol", nullable = false, updatable = false),
	//	inverseJoinColumns = @JoinColumn(name = "IdOperador", nullable = false, updatable = false))
	private String idRol;
	
	@Column(name = "`DescripcionRol`",nullable = false)
	@NotNull
	@NotEmpty
	private String descripcionRol;
	
	@Column(name = "`FchCreReg`",nullable = false)
	@NotNull
	@NotEmpty
	@DateTimeFormat
	private Date fchCreReg;
	
	@Column(name = "`UsrCreReg`",nullable = false)
	@NotNull
	@NotEmpty
	private String usrCreReg;
	
	@Column(name = "`FchModReg`",nullable = true)
	@DateTimeFormat
	private Date fchModReg;
	
	@Column(name = "`UsrModReg`",nullable = true)
	private String usrModReg;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcionRol == null) ? 0 : descripcionRol.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + (int) (idReg ^ (idReg >>> 32));
		result = prime * result + ((idRol == null) ? 0 : idRol.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		if (descripcionRol == null) {
			if (other.descripcionRol != null)
				return false;
		} else if (!descripcionRol.equals(other.descripcionRol))
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
		if (idReg != other.idReg)
			return false;
		if (idRol == null) {
			if (other.idRol != null)
				return false;
		} else if (!idRol.equals(other.idRol))
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
	public String toString() {
		return "Roles [idReg=" + idReg + ", idRol=" + idRol + ", descripcionRol=" + descripcionRol + ", fchCreReg="
				+ fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg + ", usrModReg=" + usrModReg
				+ "]";
	}
	
	
}
