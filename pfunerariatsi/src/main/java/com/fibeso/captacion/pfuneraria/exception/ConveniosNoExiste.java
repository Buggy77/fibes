package com.fibeso.captacion.pfuneraria.exception;

public class ConveniosNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7131106732995349318L;

	public ConveniosNoExiste() {
		super("ID de convenio no existe en repositorio");
	}
	
	public ConveniosNoExiste(String mensaje) {
		super(mensaje);
	}
	
}
