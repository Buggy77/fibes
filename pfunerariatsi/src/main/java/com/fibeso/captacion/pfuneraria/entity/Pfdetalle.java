package com.fibeso.captacion.pfuneraria.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity(name="Pfdetalle")
@Table(name="\"pfdetalle\"", schema="esqfibeso")
public class Pfdetalle implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -2550166595537510856L;
	
	@Id
	@SequenceGenerator(name="aliseq12",
			sequenceName="`pfdetalle_IdRegpfd_seq`",
    schema = "esqfibeso",
    allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "aliseq12")
	@Column(name = "`IdRegpfd`", updatable=false, nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Integer idRegpfd;
	
	@Transient
	private transient String idPaqPF;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`IdPaqPF`", referencedColumnName = "`IdPaqPF`", insertable=true, updatable=true)
	private Paquetespfs paquetespfs;
	
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
	private LocalDateTime fchVigPrecPaq;
	
	@Column(name = "`AnioPF`",nullable = false)
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 4)
	private String anioPF;
	
	@Column(name = "`Activo`",nullable = false)
	@NotNull
	private Boolean activo;
	
	@Column(name = "`FchCreReg`", nullable = false, updatable = false)
	@DateTimeFormat
	private Date fchCreReg;
	
	@Column(name = "`UsrCreReg`",nullable = false, updatable = false)
	private String usrCreReg;
	
	@Column(name = "`FchModReg`",nullable = true)
	@DateTimeFormat
	private Date fchModReg;
	
	@Column(name = "`UsrModReg`",nullable = true)
	private String usrModReg;
	
	public Pfdetalle() {
		super();
	}
	
	public Pfdetalle(Integer id) {
		super();
		this.idRegpfd = id;
	}

}
