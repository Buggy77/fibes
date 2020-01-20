package com.fibeso.captacion.pfuneraria.exception;

public class ClienteIdNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9164018783840930500L;

	public ClienteIdNoExiste() {
		super("ID de cliente no existe en repositorio");
	}
	
	public ClienteIdNoExiste(String mensaje) {
		super(mensaje);
	}
}
