package com.fibeso.captacion.pfuneraria.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fibeso.captacion.pfuneraria.entity.Clientes;
import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;
import com.fibeso.captacion.pfuneraria.service.ClientesService;
import com.fibeso.captacion.pfuneraria.service.UsuariosOperadorService;
import com.fibeso.captacion.pfuneraria.util.Generos;

@Controller
public class UserController {

	@Autowired
	UsuariosOperadorService usuariosOperadorService;
	
	@Autowired
	ClientesService clientesService;
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	//@GetMapping("/userForm")
	//public String userForm() {
	//	return "user_form/user-form";
	//}
	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("clienteForm", new Clientes());
		model.addAttribute("clienteList", clientesService.getAllClientes());
		//Map<String,String> generosClie = new LinkedHashMap<String, String>();
		//generosClie.put("F", "Femenino");
		//generosClie.put("M", "Másculino");
		//model.addAttribute("generos",generosClie);
		model.addAttribute("generos", Generos.values());
		model.addAttribute("listTab","active");
		//return "user_form/cliente-list";
		return "user_form/cliente-form";
	}
}
