package com.fibeso.captacion.pfuneraria.exception;

public class UsuarioOperadorNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5181767869047325302L;

	public UsuarioOperadorNoExiste() {
		super("ID usuario operador no existe en repositorio");
	}
	
	public UsuarioOperadorNoExiste(String mensaje) {
		super(mensaje);
	}
}
