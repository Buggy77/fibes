package com.fibeso.captacion.pfuneraria.exception;

public class VelatoriosNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2012694050656559196L;

	public VelatoriosNoExiste() {
		super("ID de velatorio no existe en repositorio");
	}
	
	public VelatoriosNoExiste(String mensaje) {
		super(mensaje);
	}
	
}
