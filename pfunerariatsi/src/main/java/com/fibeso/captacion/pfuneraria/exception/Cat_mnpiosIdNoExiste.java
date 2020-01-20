package com.fibeso.captacion.pfuneraria.exception;

public class Cat_mnpiosIdNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3513945750929787431L;

	public Cat_mnpiosIdNoExiste() {
		super("ID de municipio no existe en repositorio");
	}
	
	public Cat_mnpiosIdNoExiste(String mensaje) {
		super(mensaje);
	}
	
}
