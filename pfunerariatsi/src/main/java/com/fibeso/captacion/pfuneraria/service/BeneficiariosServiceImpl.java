package com.fibeso.captacion.pfuneraria.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;
import com.fibeso.captacion.pfuneraria.exception.BeneficiarioNoExiste;
import com.fibeso.captacion.pfuneraria.repository.BeneficiariosRepository;

@Service
public class BeneficiariosServiceImpl implements BeneficiariosService {

	@Autowired
	BeneficiariosRepository beneficiariosRepo;
	
	@Override
	public Iterable<Beneficiarios> getAllBeneficiarios() {
		return beneficiariosRepo.findAll();
	}

	@Override
	public Iterable<Beneficiarios> getBenefXRfcAndAnioAsegurado(String rfcTitular, String anioAsegurado)
			throws Exception {
		return beneficiariosRepo.findAllByClientesRfcAndActivoAndAnioAsegurado(rfcTitular, true, anioAsegurado);
	}
	
	
	//VALIDACIONES
	@Override
	public boolean verificarExisteBeneficiario(Beneficiarios benef) throws Exception {
		Optional<Beneficiarios> benefexiste = beneficiariosRepo.findById(benef.getIdBeneficiario());
		return benefexiste.isPresent();
	}

	@Override
	@Transactional
	public Beneficiarios actualizarBeneficiario(Beneficiarios beneficiario) throws Exception {
		Beneficiarios beneficiarioA = getBeneficiarioById(beneficiario.getIdBeneficiario());
		mapBeneficiario(beneficiario, beneficiarioA);
		return beneficiariosRepo.save(beneficiarioA);
	}

	protected void mapBeneficiario(Beneficiarios from, Beneficiarios to) {
		to.setRfcTitular(from.getRfcTitular());
		to.setNombre(from.getNombre());
		to.setAppPBenef(from.getAppPBenef());
		to.setAppMBenef(from.getAppMBenef());
		to.setAsegurado(from.getAsegurado());
		to.setCostoAsegurado(from.getCostoAsegurado());
		to.setEnfePreexiste(from.getEnfePreexiste());
		to.setIdParentesco(from.getIdParentesco());
		to.setActivo(from.getActivo());
		//to.setFchCreReg(from.getFchCreReg());
		//to.setUsrCreReg(from.getUsrCreReg());
	}

	@Override
	public Beneficiarios getBeneficiarioById(Integer id) throws BeneficiarioNoExiste {
		return beneficiariosRepo.findById(id).orElseThrow(() -> new BeneficiarioNoExiste("Id de Beneficiario no existe."));
	}

	@Override
	public Beneficiarios crearBeneficiario(Beneficiarios benef) throws Exception {
		benef = beneficiariosRepo.save(benef);
		return benef;
	}

	@Override
	@Transactional
	public void eliminarBeneficiarioFisica(Integer id) throws BeneficiarioNoExiste {
		Beneficiarios beneficiario = getBeneficiarioById(id);
		beneficiariosRepo.delete(beneficiario);
		//return null;
	}
	
}
