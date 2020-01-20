package com.fibeso.captacion.pfuneraria.util;

public enum Generos {
	F("F"), 
	M("M");
	
	private final String generoStr;
	
	Generos(String generoStr){
		this.generoStr = generoStr;
	}
	
	public String getGeneroStr() {
		return generoStr;
	}
}
