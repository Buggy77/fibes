package com.fibeso.captacion.pfuneraria.exception;

public class Cat_serviciosNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5506921412699973021L;

	public Cat_serviciosNoExiste() {
		super("ID de servicio no existe en repositorio");
	}
	
	public Cat_serviciosNoExiste(String mensaje) {
		super(mensaje);
	}
}
