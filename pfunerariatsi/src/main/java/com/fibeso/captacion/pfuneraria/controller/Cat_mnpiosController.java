package com.fibeso.captacion.pfuneraria.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;
import com.fibeso.captacion.pfuneraria.service.Cat_mnpiosService;

@Controller
public class Cat_mnpiosController {

	@Autowired
	Cat_mnpiosService cat_mnpiosService;
	
	/*
	@RequestMapping("/obtmnpiosestado")
	public @ResponseBody ResponseEntity<Iterable<Cat_mnpios>> obtenerMnpiosEstadoAjax(@RequestParam("cvmnpio") String cvmnpio, 
			HttpSession session, Model model){
		
		Iterable<Cat_mnpios> mnpiosI = cat_mnpiosService.getAllCat_mnpiosxEstado(Objects.isNull(cvmnpio)?"0":cvmnpio);
		
		return ResponseEntity.ok(mnpiosI);
	}
	*/
	
	
	@RequestMapping("/obtmnpiosestado")
	public @ResponseBody ResponseEntity<?> obtenerMnpiosEstadoAjax(@RequestParam("cvmnpio") String cvmnpio, 
			HttpSession session, Model model){
		
		//Iterable<Cat_mnpios> mnpiosI = cat_mnpiosService.getAllCat_mnpiosxEstado(Objects.isNull(cvmnpio)?"0":cvmnpio);
		Set<Cat_mnpios> mnpiosS = cat_mnpiosService.getAllCat_mnpiosxEstado(Objects.isNull(cvmnpio)?"0":cvmnpio);
		//Set<Cat_mnpios> mnpiosS = new HashSet<>();
		//mnpiosI.forEach(mnpiosS::add);
		//mnpiosS.forEach(action);
		
		//return ResponseEntity.ok(mnpiosS);
		return ResponseEntity.ok(mnpiosS);
	}
}
