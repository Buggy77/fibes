package com.fibeso.captacion.pfuneraria.exception;

public class Cat_estadosIdNoExiste extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7018563698136379619L;

	public Cat_estadosIdNoExiste() {
		super("ID de estados no existe en repositorio");
	}
	
	public Cat_estadosIdNoExiste(String mensaje) {
		super(mensaje);
	}
}
