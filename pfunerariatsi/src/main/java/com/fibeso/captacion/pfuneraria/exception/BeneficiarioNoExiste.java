package com.fibeso.captacion.pfuneraria.exception;

public class BeneficiarioNoExiste extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2883279133763896845L;

	public BeneficiarioNoExiste() {
		super("ID de beneficiario no existe en repositorio");
	}
	
	public BeneficiarioNoExiste(String mensaje) {
		super(mensaje);
	}
}
