package com.fibeso.captacion.pfuneraria.dto;

import java.util.HashSet;
import java.util.Set;

import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;

public class BeneficiariosDto {
	
	private Set<Beneficiarios> beneficiariosl;

	public BeneficiariosDto(){
		this.beneficiariosl = new HashSet<>();
	}
	
	public Set<Beneficiarios> getBeneficiariosTitular(){
		return beneficiariosl;
	}
	
	public void setBeneficiarios(Set<Beneficiarios> beneficiarios) {
		this.beneficiariosl = beneficiarios;
	}
	
	public void addBeneficiarios(Beneficiarios beneficiario) {
		this.beneficiariosl.add(beneficiario);
	}
	
}
