package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fibeso.captacion.pfuneraria.util.Generos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name="Clientes")
@EntityListeners(AuditingEntityListener.class)
@Table(name="\"clientes\"", schema="esqfibeso")
public class Clientes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7062025956260110152L;

	@Id
	@SequenceGenerator(name="aliseq3",
    //sequenceName="clientes_IdCliente_seq",
			sequenceName="`clientes_IdCliente_seq`",
    schema = "esqfibeso",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq3")
	@Column(name = "`IdCliente`", updatable=false, nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Integer idCliente;
	
	@Column(name = "`Nombre`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 50, message = "El campo nombre no puede ser vacío.")
	private String nombre;
	
	@Column(name = "`AppP`")
	@Size(min = 3, max = 50)
	private String appP;
	
	@Column(name = "`AppM`")
	@Size(min = 3, max = 50)
	private String appM;
	
	@Column(name = "`FchNacimiento`",nullable = false, columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date fchNacimiento;
	
	//@Column(name = "`Genero`",nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 1, max = 1)
	//private String genero;
	@Column(name = "`Genero`",nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Generos genero;
	
	@Column(name = "`CorreoElect`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 5, max = 320)
	private String correoElect;
	
	@Column(name = "`Folioife`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 10, max = 13)
	private String folioife;
	
	@NaturalId
	@Column(name = "`Rfc`",nullable = false, unique = true)
	@NotNull
	@NotEmpty
	@Size(min = 10, max = 13)
	private String rfc;
	
	//@OneToMany(mappedBy = "rfcTitular",
	//		cascade = CascadeType.ALL,
	//		orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "clientes",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Beneficiarios> beneficiarios;
	
	public void addBeneficiario(Beneficiarios beneficiario) {
		beneficiarios.add(beneficiario);
		//beneficiario.setRfcTitular(this);
		beneficiario.setClientes(this);
	}
	
	public void removeBeneficiario(Beneficiarios beneficiario) {
		beneficiarios.remove(beneficiario);
		//beneficiario.setRfcTitular(this);
		//beneficiario.setClientes(this);
		beneficiario.setClientes(null);
	}
	
	@OneToMany(mappedBy = "clientes",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Convenios> convenios;
	
	public void addConvenio(Convenios convenio) {
		convenios.add(convenio);
		convenio.setClientes(this);
	}
	
	public void removeConvenio(Convenios convenio) {
		convenios.add(convenio);
		//convenio.setClientes(this);
		convenio.setClientes(null);
	}
	
	@Column(name = "`Curp`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 18, max = 18)
	private String curp;
	
	@Column(name = "`Calle`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 100)
	private String calle;
	
	@Column(name = "`NoExt`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 10)
	private String noExt;
	
	@Column(name = "`NoInt`")
	@Size(max = 10)
	private String noInt;
	
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`Colonia`", nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 3, max = 15)
	//private String colonia;
	//private String idRegAsentaS;
	@Transient
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 15)
	private transient String idRegAsentaS;
	
	
	//@Size(min = 1)
	//@OneToOne(fetch = FetchType.LAZY,
	//	cascade = CascadeType.ALL)
	//@JoinColumn(name = "`Colonia`",unique = true)
	//private Asentamientos colonia;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "`Colonia`",unique = true)
	//private Asentamientos colonia;
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`Colonia`",unique = true)
	//@JoinColumn(name = "`Colonia`", referencedColumnName = "`IdRegAsentaS`", insertable=false, updatable=false, nullable = false)
	@JoinColumn(name = "`Colonia`", referencedColumnName = "`IdRegAsentaS`", insertable=true, updatable=true)
	//private Asentamientos colonia;
	private Asentamientos asentamientos;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`Municipio`", nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 3, max = 13)
	//private String municipio;
	//private String idRegMnpioS;
	@Transient
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 13)
	private transient String idRegMnpioS;
	
	//@Size(min = 1)
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(unique = true, referencedColumnName = "`IdRegMnpioS`")
	//private Cat_mnpios municipio;
	
	//@Size(min = 1)
	//@OneToOne(fetch = FetchType.LAZY, 
	//		cascade = CascadeType.ALL)
	//@JoinColumn(name = "`Municipio`")  //Corresponde a la columna de la clase (this)
	//private Cat_mnpios municipio;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`Municipio`",unique = true)
	@JoinColumn(name = "`Municipio`", referencedColumnName = "`IdRegMnpioS`", insertable=true, updatable=true)
	private Cat_mnpios municipio;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`CP`", nullable = false, columnDefinition = "NUMERIC")
	//private long cp;
	@Transient
	//private transient long cp;
	@NotNull
	@Min(1)
	private long cp;
	
	//@Size(min = 1)
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(unique = true, referencedColumnName = "`CP`")
	//private Cat_cps cp;
	
	//@Size(min = 1)
	//@OneToOne(fetch = FetchType.LAZY, 
	//		cascade = CascadeType.ALL)
	//@JoinColumn(name = "`CP`")  //Corresponde a la columna de la clase (this)
	//private Cat_cps cp;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`CP`",unique = true)
	//@JoinColumn(name = "`CP`", referencedColumnName = "`CP`", insertable=false, updatable=false, nullable = false)
	@JoinColumn(name = "`CP`", referencedColumnName = "`CP`", insertable=true, updatable=true)
	//private Cat_cps cp;
	private Cat_cps cat_cps;
	
	//REVISAR CON LA PERSISTENCIA TRANSIENT
	//@Column(name = "`Estado`", nullable = false)
	//@NotNull
	//@NotEmpty
	//@Size(min = 2, max = 2)
	//private String idRegEstadoS;
	@Transient
	@NotNull
	@NotEmpty
	@Size(min = 2, max = 2)
	private transient String idRegEstadoS;
	
	//@Size(min = 1)
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(unique = true, referencedColumnName = "`IdRegEstadoS`")
	//private Cat_estados estado;
	
	//@Size(min = 1)
	//@OneToOne(fetch = FetchType.LAZY, 
	//		cascade = CascadeType.ALL)
	//@JoinColumn(name = "`Estado`")  //Corresponde a la columna de la clase (this)
	//private Cat_estados estado;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "`Estado`",unique = true)
	//@JoinColumn(name = "`Estado`", referencedColumnName = "`IdRegEstadoS`", insertable=false, updatable=false, nullable = true)
	@JoinColumn(name = "`Estado`", referencedColumnName = "`IdRegEstadoS`", insertable=true, updatable=true)
	private Cat_estados estado;
	
	
	@Column(name = "`DesDireccion`")
	@Size(max = 200)
	private String desDireccion;
	
	@Column(name = "`EnfePreexiste`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 250)
	private String enfePreexiste;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	private Boolean activo;
	
	@CreatedDate
	//@Column(name = "`FchCreReg`",nullable = false)
	@Column(name = "`FchCreReg`", nullable = false, updatable = false)
	//@NotNull
	@DateTimeFormat
	//@CreationTimestamp
	private Date fchCreReg;
	
	@CreatedBy
	//@Column(name = "`UsrCreReg`",nullable = false)
	@Column(name = "`UsrCreReg`",nullable = false, updatable = false)
	//@NotNull
	//@NotEmpty
	private String usrCreReg;
	
	@LastModifiedDate
	//@Column(name = "`FchModReg`",nullable = true)
	@Column(name = "`FchModReg`",nullable = true)
	@DateTimeFormat
	//@UpdateTimestamp
	private Date fchModReg;
	
	@LastModifiedBy
	@Column(name = "`UsrModReg`",nullable = true)
	private String usrModReg;
	
	public Clientes() {
		super();
	}
	
	public Clientes(Integer idCliente) {
		super();
		this.idCliente = idCliente;
	}
	
	
	/*
	//public Clientes(String nombre, String appP, String appM, Date fchNacimiento, String genero,
	public Clientes(String nombre, String appP, String appM, Date fchNacimiento, Generos genero,
			String folioife,  String curp, String calle, String noExt, String noInt, 
			Asentamientos colonia, Cat_mnpios municipio, Cat_cps cp, Cat_estados estado, String desDireccion,
			String enfePreexiste, Boolean activo, Date fchCreReg, String usrCreReg, Date fchModReg,
			String usrModReg) {
		this.nombre = nombre;
		this.appP = appP;
		this.appM = appM;
		this.fchNacimiento = fchNacimiento;
		this.genero = genero;
		this.folioife = folioife;
		//this.rfc = rfc;  --> Revisar la relación
		this.curp = curp;
		this.calle = calle;
		this.noExt = noExt;
		this.noInt = noInt;
		//this.colonia = colonia;
		//this.colonia.setCliente(this);
		//this.colonia. .setClientes(this);
		this.municipio = municipio;
		//this.municipio.setCliente(this);
		//this.cp = cp;
		//this.cp.setCliente(this);
		this.estado = estado;
		//this.estado.setCliente(this);
		this.desDireccion = desDireccion;
		this.enfePreexiste = enfePreexiste;
		this.activo = activo;
		this.fchCreReg = fchCreReg;
		this.usrCreReg = usrCreReg;
		this.fchModReg = fchModReg;
		this.usrModReg = usrModReg;
	}
	*/


	
	/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (activo == null) {
			if (other.activo != null)
				return false;
		} else if (!activo.equals(other.activo))
			return false;
		if (appM == null) {
			if (other.appM != null)
				return false;
		} else if (!appM.equals(other.appM))
			return false;
		if (appP == null) {
			if (other.appP != null)
				return false;
		} else if (!appP.equals(other.appP))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (correoElect == null) {
			if (other.correoElect != null)
				return false;
		} else if (!correoElect.equals(other.correoElect))
			return false;
		if (cp != other.cp)
			return false;
		if (curp == null) {
			if (other.curp != null)
				return false;
		} else if (!curp.equals(other.curp))
			return false;
		if (desDireccion == null) {
			if (other.desDireccion != null)
				return false;
		} else if (!desDireccion.equals(other.desDireccion))
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
		if (fchNacimiento == null) {
			if (other.fchNacimiento != null)
				return false;
		} else if (!fchNacimiento.equals(other.fchNacimiento))
			return false;
		if (folioife == null) {
			if (other.folioife != null)
				return false;
		} else if (!folioife.equals(other.folioife))
			return false;
		if (genero != other.genero)
			return false;
		if (idRegAsentaS == null) {
			if (other.idRegAsentaS != null)
				return false;
		} else if (!idRegAsentaS.equals(other.idRegAsentaS))
			return false;
		if (idRegEstadoS == null) {
			if (other.idRegEstadoS != null)
				return false;
		} else if (!idRegEstadoS.equals(other.idRegEstadoS))
			return false;
		if (idRegMnpioS == null) {
			if (other.idRegMnpioS != null)
				return false;
		} else if (!idRegMnpioS.equals(other.idRegMnpioS))
			return false;
		if (noExt == null) {
			if (other.noExt != null)
				return false;
		} else if (!noExt.equals(other.noExt))
			return false;
		if (noInt == null) {
			if (other.noInt != null)
				return false;
		} else if (!noInt.equals(other.noInt))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (rfc == null) {
			if (other.rfc != null)
				return false;
		} else if (!rfc.equals(other.rfc))
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
		result = prime * result + ((appM == null) ? 0 : appM.hashCode());
		result = prime * result + ((appP == null) ? 0 : appP.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((correoElect == null) ? 0 : correoElect.hashCode());
		result = prime * result + (int) (cp ^ (cp >>> 32));
		result = prime * result + ((curp == null) ? 0 : curp.hashCode());
		result = prime * result + ((desDireccion == null) ? 0 : desDireccion.hashCode());
		result = prime * result + ((enfePreexiste == null) ? 0 : enfePreexiste.hashCode());
		result = prime * result + ((fchCreReg == null) ? 0 : fchCreReg.hashCode());
		result = prime * result + ((fchModReg == null) ? 0 : fchModReg.hashCode());
		result = prime * result + ((fchNacimiento == null) ? 0 : fchNacimiento.hashCode());
		result = prime * result + ((folioife == null) ? 0 : folioife.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idRegAsentaS == null) ? 0 : idRegAsentaS.hashCode());
		result = prime * result + ((idRegEstadoS == null) ? 0 : idRegEstadoS.hashCode());
		result = prime * result + ((idRegMnpioS == null) ? 0 : idRegMnpioS.hashCode());
		result = prime * result + ((noExt == null) ? 0 : noExt.hashCode());
		result = prime * result + ((noInt == null) ? 0 : noInt.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((rfc == null) ? 0 : rfc.hashCode());
		result = prime * result + ((usrCreReg == null) ? 0 : usrCreReg.hashCode());
		result = prime * result + ((usrModReg == null) ? 0 : usrModReg.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Clientes [nombre=" + nombre + ", appP=" + appP + ", appM=" + appM + ", fchNacimiento=" + fchNacimiento
				+ ", genero=" + genero + ", correoElect=" + correoElect + ", folioife=" + folioife + ", rfc=" + rfc
				+ ", curp=" + curp + ", calle=" + calle + ", noExt=" + noExt + ", noInt=" + noInt + ", idRegAsentaS="
				+ idRegAsentaS + ", idRegMnpioS=" + idRegMnpioS + ", cp=" + cp + ", idRegEstadoS=" + idRegEstadoS
				+ ", desDireccion=" + desDireccion + ", enfePreexiste=" + enfePreexiste + ", activo=" + activo
				+ ", fchCreReg=" + fchCreReg + ", usrCreReg=" + usrCreReg + ", fchModReg=" + fchModReg + ", usrModReg="
				+ usrModReg + "]";
	}
	
	*/
	
	
}
