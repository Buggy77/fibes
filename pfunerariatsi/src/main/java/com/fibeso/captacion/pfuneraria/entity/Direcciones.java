package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
//import java.util.Date;

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

//import com.fibeso.captacion.pfuneraria.util.Generos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity(name="Direcciones")
@Table(name="\"direcciones\"", schema="esqfibeso")
@EqualsAndHashCode
public class Direcciones implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4921651763632993409L;
	
	@Id
	@SequenceGenerator(name="aliseq4",
    //sequenceName="direcciones_IdReg_seq",
			sequenceName="`direcciones_IdReg_seq`",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq4")
	@Column(name = "`IdReg`", updatable=false, nullable = false)
	private Integer idReg;
	
	@Column(name = "`IdRegAsentaS`", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 15)
	private String idRegAsentaS;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "`IdRegAsentaS`",unique = true)
	//@JoinColumn(name = "`IdRegAsentaS`", insertable=false, updatable=false)
	@JoinColumn(name = "`IdRegAsentaS`", referencedColumnName = "`IdRegAsentaS`", insertable=false, updatable=false)
	//private Asentamientos idRegAsentaS;
	private Asentamientos asentamientos;
	
	@Column(name = "`CP`", nullable = false, columnDefinition = "NUMERIC")
	private long cp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "`CP`",unique = true)
	//@JoinColumn(name = "`CP`", insertable=false, updatable=false)
	@JoinColumn(name = "`CP`", referencedColumnName = "`CP`", insertable=false, updatable=false)
	//private Cat_cps cp;
	private Cat_cps cat_cps;
	
	@Column(name = "`IdRegMnpioS`", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 13)
	private String idRegMnpioS;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "`IdRegMnpioS`",unique = true)
	//@JoinColumn(name = "`IdRegMnpioS`", insertable=false, updatable=false)
	@JoinColumn(name = "`IdRegMnpioS`", referencedColumnName = "`IdRegMnpioS`", insertable=false, updatable=false)
	//private Cat_mnpios idRegMnpioS;
	private Cat_mnpios cat_mnpios;
	
	@Column(name = "`IdRegEstadoS`", nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 1, max = 2)
	private String idRegEstadoS;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@ManyToOne(fetch = FetchType.EAGER)
	//@JoinColumn(name = "`IdRegEstadoS`",unique = true)
	//@JoinColumn(name = "`IdRegEstadoS`", insertable=false, updatable=false)
	@JoinColumn(name = "`IdRegEstadoS`", referencedColumnName = "`IdRegEstadoS`", insertable=false, updatable=false)
	//private Cat_estados idRegEstadoS;
	private Cat_estados cat_estados;
	
	public Direcciones() {
		super();
	}
	
	public Direcciones(Integer id) {
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
		Direcciones other = (Direcciones) obj;
		if (cp != other.cp)
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
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cp ^ (cp >>> 32));
		result = prime * result + ((idRegAsentaS == null) ? 0 : idRegAsentaS.hashCode());
		result = prime * result + ((idRegEstadoS == null) ? 0 : idRegEstadoS.hashCode());
		result = prime * result + ((idRegMnpioS == null) ? 0 : idRegMnpioS.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Direcciones [idRegAsentaS=" + idRegAsentaS + ", cp=" + cp + ", idRegMnpioS=" + idRegMnpioS
				+ ", idRegEstadoS=" + idRegEstadoS + "]";
	}
	
}
