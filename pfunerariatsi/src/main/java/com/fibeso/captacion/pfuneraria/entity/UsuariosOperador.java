package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity(name="UsuariosOperador")
//@EntityScan(basePackages = {"com.fibeso.captacion.pfuneraria.entity"})
@Table(name="\"usr_operadores\"", schema="esqfibeso")
public class UsuariosOperador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7078303762834180561L;

	@Id
	@SequenceGenerator(name="custseq2",
    //sequenceName="usr_operadores_idreg_seq",
	sequenceName="`usr_operadores_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "custseq2")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@NaturalId
	@Column(name = "`IdOperador`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 9, max = 11)
	private String idOperador;
	
	@OneToMany(mappedBy = "usuariosOperador",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Convenios> convenios;
	
	public void addConvenio(Convenios convenio) {
		convenios.add(convenio);
		convenio.setUsuariosOperador(this);
	}
	
	public void removeConvenio(Convenios convenio) {
		convenios.remove(convenio);
		//convenio.setUsuariosOperador(this);
		convenio.setUsuariosOperador(null);
	}
	
	@Column(name = "`Pass`",nullable = false)
	@NotNull
	@NotEmpty
	private String pass;
	
	@Column(name = "`Nombre`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50)
	private String nombre;
	
	@Column(name = "`AppPOpe`")
	@Size(min = 3, max = 50)
	private String appPOpe;
	
	@Column(name = "`AppMOpe`")
	@Size(min = 3, max = 50)
	private String appMOpe;
	
	@Column(name = "`UsrAlias`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 20)
	private String usrAlias;
	
	@Column(name = "`Email`",nullable = false)
	@NotNull
	@Email
	@NotEmpty
	@Size(min = 7, max = 250)
	private String email;
	
	@Column(name = "`IdVelatorio`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 3)
	private String idVelatorio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`IdVelatorio`", referencedColumnName = "`IdVelatorio`", insertable=false, updatable=false)
	private Velatorios velatorio;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	@NotEmpty
	private Boolean activo;
	
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

	@Transient
	private String confirmaPassword;
	
	/*
	@Size(min = 1)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usr_operadores_rol",
		joinColumns = @JoinColumn(name = "idoperador", nullable = false, updatable = false, columnDefinition = "VARCHAR(11)"),
		inverseJoinColumns = @JoinColumn(name = "idrol", nullable = false, updatable = false, columnDefinition = "VARCHAR(5)"))
	private Set<Roles> roles;
	*/
	
	@Size(min = 1)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "\"usr_operadores_rol\"",
		//joinColumns = @JoinColumn(name = "`IdOperador`", nullable = false, updatable = false, columnDefinition = "VARCHAR(11)"),
			joinColumns = @JoinColumn(name = "`IdOperador`", referencedColumnName = "`IdOperador`"),
		//inverseJoinColumns = @JoinColumn(name = "`IdRol`", nullable = false, updatable = false, columnDefinition = "VARCHAR(5)"))
					inverseJoinColumns = @JoinColumn(name = "`IdRol`", referencedColumnName = "`IdRol`"),
					uniqueConstraints = @UniqueConstraint(columnNames={"`IdOperador`", "`IdRol`"}))
	private Set<Roles> roles;
	
	
	public UsuariosOperador() {
		// TODO Auto-generated constructor stub
		super();
	}
	public UsuariosOperador(Integer id) {
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
		UsuariosOperador other = (UsuariosOperador) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (appMOpe == null) {
			if (other.appMOpe != null)
				return false;
		} else if (!appMOpe.equals(other.appMOpe))
			return false;
		if (appPOpe == null) {
			if (other.appPOpe != null)
				return false;
		} else if (!appPOpe.equals(other.appPOpe))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (idOperador == null) {
			if (other.idOperador != null)
				return false;
		} else if (!idOperador.equals(other.idOperador))
			return false;
		if (idVelatorio == null) {
			if (other.idVelatorio != null)
				return false;
		} else if (!idVelatorio.equals(other.idVelatorio))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (usrAlias == null) {
			if (other.usrAlias != null)
				return false;
		} else if (!usrAlias.equals(other.usrAlias))
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
		result = prime * result + ((appMOpe == null) ? 0 : appMOpe.hashCode());
		result = prime * result + ((appPOpe == null) ? 0 : appPOpe.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((idOperador == null) ? 0 : idOperador.hashCode());
		result = prime * result + ((idVelatorio == null) ? 0 : idVelatorio.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((usrAlias == null) ? 0 : usrAlias.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "UsuariosOperador [idOperador=" + idOperador + ", pass=" + pass + ", nombre=" + nombre + ", appPOpe="
				+ appPOpe + ", appMOpe=" + appMOpe + ", usrAlias=" + usrAlias + ", email=" + email + ", idVelatorio="
				+ idVelatorio + ", activo=" + activo + ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg
				+ ", fchModReg=" + fchModReg + ", usrModReg=" + usrModReg + "]";
	}
	
	/*
	public UsuariosOperador(String idOperador) {
		super();
		this.idVelatorio = idOperador;
	}
	*/

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((activo == null) ? 0 : activo.hashCode()); result
	 * = prime * result + ((appMOpe == null) ? 0 : appMOpe.hashCode()); result =
	 * prime * result + ((appPOpe == null) ? 0 : appPOpe.hashCode()); result = prime
	 * * result + ((confirmaPassword == null) ? 0 : confirmaPassword.hashCode());
	 * result = prime * result + ((email == null) ? 0 : email.hashCode()); result =
	 * prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode()); result =
	 * prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode()); result =
	 * prime * result + ((idOperador == null) ? 0 : idOperador.hashCode()); result =
	 * prime * result + (int) (idReg ^ (idReg >>> 32)); result = prime * result +
	 * ((idVelatorio == null) ? 0 : idVelatorio.hashCode()); result = prime * result
	 * + ((nombre == null) ? 0 : nombre.hashCode()); result = prime * result +
	 * ((pass == null) ? 0 : pass.hashCode()); result = prime * result + ((roles ==
	 * null) ? 0 : roles.hashCode()); result = prime * result + ((usrAlias == null)
	 * ? 0 : usrAlias.hashCode()); result = prime * result + ((usrCreReg == null) ?
	 * 0 : usrCreReg.hashCode()); result = prime * result + ((usrModReg == null) ? 0
	 * : usrModReg.hashCode()); return result; }
	 */



//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UsuariosOperador other = (UsuariosOperador) obj;
//		if (activo == null) {
//			if (other.activo != null)
//				return false;
//		} else if (!activo.equals(other.activo))
//			return false;
//		if (appMOpe == null) {
//			if (other.appMOpe != null)
//				return false;
//		} else if (!appMOpe.equals(other.appMOpe))
//			return false;
//		if (appPOpe == null) {
//			if (other.appPOpe != null)
//				return false;
//		} else if (!appPOpe.equals(other.appPOpe))
//			return false;
//		if (confirmaPassword == null) {
//			if (other.confirmaPassword != null)
//				return false;
//		} else if (!confirmaPassword.equals(other.confirmaPassword))
//			return false;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (fchCreReg == null) {
//			if (other.fchCreReg != null)
//				return false;
//		} else if (!fchCreReg.equals(other.fchCreReg))
//			return false;
//		if (fchModReg == null) {
//			if (other.fchModReg != null)
//				return false;
//		} else if (!fchModReg.equals(other.fchModReg))
//			return false;
//		if (idOperador == null) {
//			if (other.idOperador != null)
//				return false;
//		} else if (!idOperador.equals(other.idOperador))
//			return false;
//		if (idReg != other.idReg)
//			return false;
//		if (idVelatorio == null) {
//			if (other.idVelatorio != null)
//				return false;
//		} else if (!idVelatorio.equals(other.idVelatorio))
//			return false;
//		if (nombre == null) {
//			if (other.nombre != null)
//				return false;
//		} else if (!nombre.equals(other.nombre))
//			return false;
//		if (pass == null) {
//			if (other.pass != null)
//				return false;
//		} else if (!pass.equals(other.pass))
//			return false;
//		if (roles == null) {
//			if (other.roles != null)
//				return false;
//		} else if (!roles.equals(other.roles))
//			return false;
//		if (usrAlias == null) {
//			if (other.usrAlias != null)
//				return false;
//		} else if (!usrAlias.equals(other.usrAlias))
//			return false;
//		if (usrCreReg == null) {
//			if (other.usrCreReg != null)
//				return false;
//		} else if (!usrCreReg.equals(other.usrCreReg))
//			return false;
//		if (usrModReg == null) {
//			if (other.usrModReg != null)
//				return false;
//		} else if (!usrModReg.equals(other.usrModReg))
//			return false;
//		return true;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "UsuariosOperador [idReg=" + idReg + ", idOperador=" + idOperador + ", pass=" + pass + ", nombre="
//				+ nombre + ", appPOpe=" + appPOpe + ", appMOpe=" + appMOpe + ", usrAlias=" + usrAlias + ", email="
//				+ email + ", idVelatorio=" + idVelatorio + ", activo=" + activo + ", fchCreReg=" + fchCreReg
//				+ ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg + ", usrModReg=" + usrModReg
//				+ ", confirmaPassword=" + confirmaPassword + ", roles=" + roles + "]";
//	}

	
	
	
	
}
