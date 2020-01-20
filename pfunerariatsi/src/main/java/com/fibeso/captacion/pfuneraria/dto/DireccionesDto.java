package com.fibeso.captacion.pfuneraria.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DireccionesDto {

	@NotNull
	private long cp;
	private String idRegEstadoS;
	private String descEstado;
	private String idRegMnpioS;
	private String descMnpio;
	private String idRegAsentaS;
	private String descAsentaS;
	private String idRegTipoS;
	private String descAsentamiento;
	
	public DireccionesDto() {
		
	}
	
	/*
	public DireccionesDto(long cp, String idRegEstadoS, String descEstado, String idRegMnpioS, 
			String descMnpio, String idRegAsentaS, String descAsentaS, String idRegTipoS,
			String descAsentamiento) {
		this.cp = cp;
		
	}
	*/
}
