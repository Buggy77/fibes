package com.fibeso.captacion.pfuneraria.util;

public enum Sino {
	FALSE("No"), TRUE("Si");
	
	private final String sn;
	
	Sino(String v){
		this.sn = v;
	}
	
	public String getSino() {
		return sn;
	}
	
}
