package com.fibeso.captacion.pfuneraria.dto;

import java.util.ArrayList;
import java.util.List;

import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;

public class BeneficiariosTDto {

	private List<Beneficiarios> beneficiariosl;
	
	public BeneficiariosTDto() {
		this.beneficiariosl = new ArrayList<>();
	}
	
	public BeneficiariosTDto(List<Beneficiarios> beneficiarios) {
		this.beneficiariosl = beneficiarios;
	}
	
	public List<Beneficiarios> getBeneficiariosTitular(){
		return this.beneficiariosl;
	}
	
	public void setBeneficiariosTitular(List<Beneficiarios> beneficiarios) {
		this.beneficiariosl = beneficiarios;
	}
	
	public void addBeneficiariosTitular(Beneficiarios benef) {
		this.beneficiariosl.add(benef);
	}
}
