package com.fibeso.captacion.pfuneraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.
Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;
import com.fibeso.captacion.pfuneraria.service.BeneficiariosService;
import com.fibeso.captacion.pfuneraria.service.PaquetespfsService;
import com.fibeso.captacion.pfuneraria.service.ParentescosService;
import com.fibeso.captacion.pfuneraria.util.Generos;
import com.fibeso.captacion.pfuneraria.util.Sino;

@Controller
public class BeneficiariosController {

	@Autowired
	ParentescosService parentescoService;
	
	@Autowired
	PaquetespfsService paquetesService;
	
	@Autowired
	BeneficiariosService benefService;
	
	@GetMapping("/beneficiarioForm")
	public String beneficiarioForm(Model model) {
		model.addAttribute("beneficiarioForm", new Beneficiarios());
		model.addAttribute("listaParentescos", parentescoService.getAllParentescos());
		model.addAttribute("listaAsegurados", Sino.values());
		return "user_form/cliente-view";
	}
	
	
}
