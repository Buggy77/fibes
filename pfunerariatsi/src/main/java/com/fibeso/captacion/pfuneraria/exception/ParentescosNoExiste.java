package com.fibeso.captacion.pfuneraria.exception;

public class ParentescosNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7657354867785188572L;

	public ParentescosNoExiste() {
		super("ID de parentesco no existe en repositorio");
	}
	
	public ParentescosNoExiste(String mensaje) {
		super(mensaje);
	}
}
