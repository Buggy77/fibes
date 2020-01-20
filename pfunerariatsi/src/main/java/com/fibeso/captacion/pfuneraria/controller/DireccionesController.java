package com.fibeso.captacion.pfuneraria.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fibeso.captacion.pfuneraria.dto.DireccionesDto;
import com.fibeso.captacion.pfuneraria.entity.Asentamientos;
import com.fibeso.captacion.pfuneraria.entity.Cat_asentamientos;
import com.fibeso.captacion.pfuneraria.entity.Cat_cps;
import com.fibeso.captacion.pfuneraria.entity.Cat_estados;
import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;
import com.fibeso.captacion.pfuneraria.entity.Direcciones;
import com.fibeso.captacion.pfuneraria.repository.DireccionesRepository;
import com.fibeso.captacion.pfuneraria.service.DireccionesService;

@Controller
public class DireccionesController {

	@Autowired
	DireccionesService direccionessrv;
	
	@Autowired
	DireccionesRepository direccionesrepo;
	
	//@PostMapping("/obtDireccionesB")
	//public ResponseEntity<?> obtenerDireccionesAjax(
	//		@Validated @RequestBody SearchCriteria datos, Errors errores){
		
	//}
	//@RequestMapping("/obtDireccionesB")
	//public List<Object> obtenerDireccionesAjax
	
	@RequestMapping("/obtDireccionesB")
	public @ResponseBody ResponseEntity<?> obtenerDireccionesAjax(@RequestParam("cp") String cp, 
			HttpSession session, Model model){
		
		String lcp = "";
		if (cp == null) { 
			lcp = "0"; 
		} else if (cp=="") {
			lcp = "0"; 
		} else 
			lcp = cp;
		
		Set<Direcciones> direcciones = direccionesrepo.findAllByCp(Long.parseLong(lcp));
		Integer cantidad = direcciones.size();
		
		Set<DireccionesDto> listadirecciones = new HashSet<>();
		//
		Set<Asentamientos> asentamientos = new HashSet<>();
		//
		Iterator<Direcciones> direccion = direcciones.iterator();
		while(direccion.hasNext()) {
			Direcciones d = (Direcciones) direccion.next();
			DireccionesDto dtmp = new DireccionesDto();
			System.out.println("CP: " + d.getCp());
			dtmp.setCp(d.getCp());
			Asentamientos a = d.getAsentamientos();
			//
			Asentamientos aa = a;
			//
			dtmp.setIdRegAsentaS(a.getIdRegAsentaS());
			dtmp.setDescAsentaS(a.getDescAsentaS());
			Cat_asentamientos catasent = d.getAsentamientos().getCat_asentamientos();
			dtmp.setIdRegTipoS(catasent.getIdRegTipoS());
			dtmp.setDescAsentamiento(catasent.getDescAsentamiento());
			Cat_estados catestados = d.getCat_estados();
			dtmp.setIdRegEstadoS(catestados.getIdRegEstadoS());
			dtmp.setDescEstado(catestados.getDescEstado());
			Cat_mnpios catmnpio = d.getCat_mnpios();
			dtmp.setIdRegMnpioS(catmnpio.getIdRegMnpioS());
			dtmp.setDescMnpio(catmnpio.getDescMnpio());
			listadirecciones.add(dtmp);
			//
			asentamientos.add(aa);
			//
		}
		
		for(Iterator<DireccionesDto> it = listadirecciones.iterator(); it.hasNext();) { 
			DireccionesDto x = it.next();
		    System.out.println(x.getCp() + ", " + x.getIdRegEstadoS() + ", " + x.getDescEstado()
		    + ", " + x.getIdRegMnpioS() + ", " + x.getDescMnpio() + ", " + x.getIdRegAsentaS()
		    + ", " + x.getDescAsentaS() + ", " + x.getIdRegTipoS() + ", " + x.getDescAsentamiento());
		}
		//
		System.out.println("Valor de asentas: " + asentamientos.size());
		model.addAttribute("listasentamientos", asentamientos);
		model.addAttribute("direccionesDTO", listadirecciones);
		//
		
		return ResponseEntity.ok(listadirecciones);
	}
	
	@GetMapping("/obtDirecciones")
	public String refrescarAsentamientos(@RequestParam("cp") String cp, Model model) {
		
		//Cat_cps cpl;
		//cpl.setCp(Long.parseLong(cp));
		
		//Set<Direcciones> direcciones = direccionessrv.getAllDireccionesByCp(cpl);
		
		Set<Direcciones> direcciones = direccionesrepo.findAllByCp(Long.parseLong(cp));
		Integer cantidad = direcciones.size();
		
		//Set<DireccionesDto> direccionesdto = new Set<>();
		Set<DireccionesDto> listadirecciones = new HashSet<>();
		
		Iterator<Direcciones> direccion = direcciones.iterator();
		while(direccion.hasNext()) {
			Direcciones d = (Direcciones) direccion.next();
			DireccionesDto dtmp = new DireccionesDto();
			System.out.println("CP: " + d.getCp());
			dtmp.setCp(d.getCp());
			//System.out.println("Id Estado: " + d.getIdRegEstadoS());
			//dtmp.setIdRegEstadoS(d.getIdRegEstadoS());
			//System.out.println("Id Municipio: " + d.getIdRegMnpioS());
			//dtmp.setIdRegMnpioS(d.getIdRegMnpioS());
			//System.out.println("Id Asenta: " + d.getIdRegAsentaS());
			Asentamientos a = d.getAsentamientos();
			//System.out.println("IdRegAsenta: " + a.getIdRegAsentaS());
			dtmp.setIdRegAsentaS(a.getIdRegAsentaS());
			//System.out.println("IdDesAsenta: " + a.getDescAsentaS());
			dtmp.setDescAsentaS(a.getDescAsentaS());
			//System.out.println("IdRegTipoS: " + a.getIdRegTipoS());
			Cat_asentamientos catasent = d.getAsentamientos().getCat_asentamientos();
			dtmp.setIdRegTipoS(catasent.getIdRegTipoS());
			dtmp.setDescAsentamiento(catasent.getDescAsentamiento());
			Cat_estados catestados = d.getCat_estados();
			dtmp.setIdRegEstadoS(catestados.getIdRegEstadoS());
			dtmp.setDescEstado(catestados.getDescEstado());
			Cat_mnpios catmnpio = d.getCat_mnpios();
			dtmp.setIdRegMnpioS(catmnpio.getIdRegMnpioS());
			dtmp.setDescMnpio(catmnpio.getDescMnpio());
			listadirecciones.add(dtmp);
		}
		
		for(Iterator<DireccionesDto> it = listadirecciones.iterator(); it.hasNext();) { 
			DireccionesDto x = it.next();
		    System.out.println(x.getCp() + ", " + x.getIdRegEstadoS() + ", " + x.getDescEstado()
		    + ", " + x.getIdRegMnpioS() + ", " + x.getDescMnpio() + ", " + x.getIdRegAsentaS()
		    + ", " + x.getDescAsentaS() + ", " + x.getIdRegTipoS() + ", " + x.getDescAsentamiento());
		}
		
		//for(Iterator<Direccion>)
		//direcciones.forEach(System.out::println);
		System.out.println("Valor del arreglo:" + cantidad.toString());
		model.addAttribute("direcciones", direcciones);
		return "user_form/cliente-form :: #colonia";
	}
	
	@GetMapping("/getDirecciones/{cp}")
	public String getDirecciones(Model model, @PathVariable(name = "cp") Cat_cps cp) throws Exception{
		//Direcciones direcciones = direccionessrv.getAllDireccionesByCp(cp);
		Set<Direcciones> direcciones = direccionessrv.getAllDireccionesByCp(cp);
		
		direcciones.forEach(System.out::println);
		model.addAttribute("direcciones", direcciones);
		return "user_form/direcciones-form";
		//.orElseThrow(() -> new IllegalArgumentException("CP inválido:" + cp));
	}
}
