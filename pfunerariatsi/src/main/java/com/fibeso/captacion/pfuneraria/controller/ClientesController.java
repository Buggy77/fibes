package com.fibeso.captacion.pfuneraria.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fibeso.captacion.pfuneraria.dto.BeneficiariosDto;
import com.fibeso.captacion.pfuneraria.dto.BeneficiariosTDto;
import com.fibeso.captacion.pfuneraria.dto.DireccionesDto;
import com.fibeso.captacion.pfuneraria.entity.Asentamientos;
import com.fibeso.captacion.pfuneraria.entity.Beneficiarios;
import com.fibeso.captacion.pfuneraria.entity.Cat_asentamientos;
import com.fibeso.captacion.pfuneraria.entity.Cat_cps;
import com.fibeso.captacion.pfuneraria.entity.Cat_estados;
import com.fibeso.captacion.pfuneraria.entity.Cat_mnpios;
import com.fibeso.captacion.pfuneraria.entity.Clientes;
import com.fibeso.captacion.pfuneraria.entity.Convenios;
import com.fibeso.captacion.pfuneraria.entity.Direcciones;
import com.fibeso.captacion.pfuneraria.entity.Paquetespfs;
import com.fibeso.captacion.pfuneraria.entity.Parentescos;
import com.fibeso.captacion.pfuneraria.entity.Pfdetalle;
import com.fibeso.captacion.pfuneraria.entity.UsuariosOperador;
import com.fibeso.captacion.pfuneraria.exception.ClienteIdNoExiste;
import com.fibeso.captacion.pfuneraria.repository.DireccionesRepository;
import com.fibeso.captacion.pfuneraria.service.BeneficiariosService;
import com.fibeso.captacion.pfuneraria.service.Cat_estadosService;
import com.fibeso.captacion.pfuneraria.service.ClientesService;
import com.fibeso.captacion.pfuneraria.service.ConveniosService;
import com.fibeso.captacion.pfuneraria.service.PaquetespfsService;
import com.fibeso.captacion.pfuneraria.service.ParentescosService;
import com.fibeso.captacion.pfuneraria.service.PfdetalleService;
import com.fibeso.captacion.pfuneraria.service.UsuariosOperadorService;
import com.fibeso.captacion.pfuneraria.util.Generos;
import com.fibeso.captacion.pfuneraria.util.Sino;

@Controller
public class ClientesController {

	@Autowired
	ClientesService clientesService;
	
	@Autowired
	ParentescosService parentescoService;
	
	@Autowired
	DireccionesRepository direccionesrepo;
	
	@Autowired
	PfdetalleService pfdetalleService;
	
	@Autowired
	PaquetespfsService paquetesService;
	
	@Autowired
	BeneficiariosService benefService;
	
	@Autowired
	ConveniosService conveniosService;
	
	@Autowired
	Cat_estadosService cat_estadosService;
	
	@Autowired
	UsuariosOperadorService usroperadorService;
	
	//AuditorAwareImpl authentication;
	
	@GetMapping("/clienteForm")
	public String userForm(Model model) {
		model.addAttribute("clienteForm", new Clientes());
		model.addAttribute("direccionesDto", new DireccionesDto());
		//12Ene2020
		model.addAttribute("cpC", new Cat_cps());
		model.addAttribute("asentamientoC", new Asentamientos());
		model.addAttribute("estadoC", new Cat_estados());
		model.addAttribute("municipioC", new Cat_mnpios());
		//12Ene2020
		//model.addAttribute("listasentamientos", new Asentamientos());
		model.addAttribute("clienteList", clientesService.getAllClientes());
		//Map<String,String> generosClie = new LinkedHashMap<String, String>();
		//generosClie.put("F", "Femenino");
		//generosClie.put("M", "Másculino");
		//model.addAttribute("generos",generosClie);
		model.addAttribute("generos", Generos.values());
		model.addAttribute("listTab","active");
		//return "user_form/cliente-list";
		
		//15Ene2020
		BeneficiariosTDto beneficiariosDto = new BeneficiariosTDto();
		for(int i = 1; i <= 3; i++) {
			beneficiariosDto.addBeneficiariosTitular(new Beneficiarios());
		}
		
		/*
		Set<Beneficiarios> b = beneficiariosDto.getBeneficiariosTitular();
		//b.forEach(action);
		Iterator<Beneficiarios> itr = b.iterator();

		Iterator<Beneficiarios> c = beneficiariosDto.iterator();
		while(itr.hasNext()) {
			Beneficiarios d = (Beneficiarios) itr.next();
			//d.getN
			System.out.println("Iterator");
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        */

		
		model.addAttribute("beneficiarioForm", beneficiariosDto);
		model.addAttribute("listaParentescos", parentescoService.getAllParentescos());
		model.addAttribute("listaAsegurados", Sino.values());
		
		//CONVENIOS
		//19Ene2020 - MAGG
		
		LocalDateTime fchHoy = LocalDateTime.now();
		LocalDateTime fchAnioAnt = fchHoy.minusYears(1);
		LocalDateTime fchHoy20 = fchHoy.plusDays(20);
		System.out.println("La fecha con un año posterior: " + fchAnioAnt);
		System.out.println("La fecha con 20 días de más: " + fchHoy20);
		//Integer anioInt = fchHoy.getYear();
		//String anio = Integer.toString(anioInt);
		//String fchVigPre = anio+"-12-31 00:00:00";
		//DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//LocalDateTime fechaPreVig = LocalDateTime.parse(fchVigPre, formateador);
		
		String usuariolog="";
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			usuariolog = authentication.getName();
		}
		model.addAttribute("convenioList", conveniosService.getAllConveniosActivosporOperador(usuariolog));
		UsuariosOperador operador = new UsuariosOperador();
		//@SuppressWarnings("unchecked")
		//Iterable<Paquetespfs> paquetesI = (Iterable<Paquetespfs>) new Paquetespfs();
		Iterable<Paquetespfs> paquetesI = null;
		try {
			operador = usroperadorService.getUsuarioOperadorById(usuariolog);
			paquetesI = paquetesService.getAllPaquetespfsxVelatorio(operador.getIdVelatorio());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("convenioForm", new Convenios());
		//model.addAttribute("listaPaquetes", paquetesService.getAllPaquetespfs());
		model.addAttribute("listaPaquetes", paquetesI);
		model.addAttribute("listaEstados", cat_estadosService.getAllCat_estados());
		//model.addAttribute("listaMnpios", attributeValue);
		//19Ene2020 - MAGG
		
		//15Ene2020
		//return "user_form/cliente-form";
		//13Ene2020 -  MAGG
		return "user_form/cliente-view";
		//13Ene2020 -  MAGG
	}
	
	@PostMapping("/clienteForm")
	public String crearCliente(@Valid @ModelAttribute("clienteForm") Clientes cliente, 
			//BindingResult resultado, @RequestParam("cp") String cp, ModelMap model) { //Funcional
			BindingResult resultado, @ModelAttribute("cpC") Cat_cps objCp, @ModelAttribute("direccionesDto") DireccionesDto listadto, 
			@ModelAttribute("municipioC") Cat_mnpios objMunicipio, @ModelAttribute("estadoC") Cat_estados objEstado,
			@ModelAttribute("asentamientoC") Asentamientos objAsentamiento, 
			@RequestParam("cp") String cp, ModelMap model) {
		
			
			//BindingResult resultado, @RequestParam("asentamientos") List<String> listadto, ModelMap model) {
			//BindingResult resultado, @ModelAttribute("direccionesDto") DireccionesDto listadto, ModelMap model) {
		//String lcp = "";
		if (cp == null) { 
			cp = "0"; 
		} else if (cp=="") {
			cp = "0"; 
		}
		if(resultado.hasErrors()) {
			//System.out.println("Valor devuelto: " + listadto);
			model.addAttribute("clienteForm", cliente);
			//model.addAttribute("listasentamientos", cliente.getAsentamientos());
			model.addAttribute("direccionesDto", llenardireccionxcp(cp));
			
			//12Ene2020
			model.addAttribute("municipioC", objMunicipio);
			model.addAttribute("estadoC", objEstado);
			model.addAttribute("cpC", objCp);
			model.addAttribute("asentamientoC", objAsentamiento);
			model.addAttribute("formTab","active");
			//12Ene2020
			
			//model.addAttribute("formTab", "active");
		} else {
			try {
				//12Ene2020
				cliente.setMunicipio(objMunicipio);
				//objMunicipio.getClientes().add(cliente);
				cliente.setEstado(objEstado);
				//objEstado.getClientes().add(cliente);
				cliente.setCat_cps(objCp);
				//objCp.getClientes().add(cliente);
				cliente.setAsentamientos(objAsentamiento);
				//objAsentamiento.getClientes().add(cliente);
				//12Ene2020
				//Clientes cli = new Clientes()
				clientesService.crearCliente(cliente);
				
				//13Ene2020 - MAGG
				model.addAttribute("clienteForm", new Clientes());
				model.addAttribute("listTab","active");
				//13Ene2020 - MAGG
				
			}catch (Exception e) {
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("clienteForm", cliente);
				model.addAttribute("direccionesDto", llenardireccionxcp(cp));
				
				//12Ene2020 -  MAGG
				model.addAttribute("municipioC", objMunicipio);
				model.addAttribute("estadoC", objEstado);
				model.addAttribute("cpC", objCp);
				model.addAttribute("asentamientoC", objAsentamiento);
				//12Ene2020 - MAGG
				model.addAttribute("formTab", "active");
			}
		}
		
		//model.addAttribute("clienteForm", cliente);
		model.addAttribute("clienteList", clientesService.getAllClientes());
		model.addAttribute("generos", Generos.values());
		//model.addAttribute("formTab","active");
		
		//13Ene2020 -  MAGG
		//return "user_form/cliente-form";
		return "user_form/cliente-view";
		//13Ene2020 -  MAGG
			
		//return "";
	}
	
	@PostMapping("/modificarCliente")
	public String portModificarClienteForm(@Valid @ModelAttribute("clienteForm") Clientes cliente,
			BindingResult resultado, @ModelAttribute("direccionesDto") DireccionesDto listadto, 
			@ModelAttribute("municipioC") Cat_mnpios objMunicipio, @ModelAttribute("estadoC") Cat_estados objEstado,
			@ModelAttribute("cpC") Cat_cps objCp, @ModelAttribute("asentamientoC") Asentamientos objAsentamiento, 
			@RequestParam("cp") String cp, ModelMap model) {
		
		if (cp == null) { 
			cp = "0"; 
		} else if (cp=="") {
			cp = "0"; 
		}
		if(resultado.hasErrors()) {
			model.addAttribute("clienteForm", cliente);
			model.addAttribute("direccionesDto", llenardireccionxcp(cp));
			model.addAttribute("municipioC", objMunicipio);
			model.addAttribute("estadoC", objEstado);
			model.addAttribute("cpC", objCp);
			model.addAttribute("asentamientoC", objAsentamiento);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
		}else{
			try {
				cliente.setMunicipio(objMunicipio);
				cliente.setEstado(objEstado);
				cliente.setCat_cps(objCp);
				cliente.setAsentamientos(objAsentamiento);
				clientesService.actualizarCliente(cliente);
				model.addAttribute("clienteForm", new Clientes());
				model.addAttribute("listTab","active");
			} catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
				model.addAttribute("formErrorMessage", e.getMessage());
				model.addAttribute("clienteForm", cliente);
				model.addAttribute("direccionesDto", llenardireccionxcp(cp));
				model.addAttribute("municipioC", objMunicipio);
				model.addAttribute("estadoC", objEstado);
				model.addAttribute("cpC", objCp);
				model.addAttribute("asentamientoC", objAsentamiento);
				model.addAttribute("formTab", "active");
				model.addAttribute("editMode","true");
			}
		}
		model.addAttribute("clienteList", clientesService.getAllClientes());
		model.addAttribute("generos", Generos.values());
		return "user_form/cliente-view";
	}
	
	
	@PostMapping("/beneficiarioCliente")
	public String guardarBeneficiarios(@ModelAttribute BeneficiariosTDto form, Model model) {
		
		List<Beneficiarios> lbenef = form.getBeneficiariosTitular();
		
		String idPaqPF_e = "PAQ ECO";
		String idPaqPF_b = "PAQ BAS";
		String idPaqPF_c = "PAQ CREM";
		LocalDateTime fechaHoy = LocalDateTime.now();
		Integer annioInt = fechaHoy.getYear();
		String annio = Integer.toString(annioInt);
		String fechaVigPre = annio+"-12-31 00:00:00";
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fechaPreVig = LocalDateTime.parse(fechaVigPre, formateador);
		
		for(Beneficiarios beneficiario : lbenef) {
			
			if(beneficiario.isRegistrar()) {
				//PREGUNTAR SI EXISTE REGISTRO EN AÑO ACTUAL EL ID SERIAL
				//if(!Objects.isNull(beneficiario.getIdBeneficiario())) {
				try {
					Pfdetalle paquete = pfdetalleService.getPFxIdAndFchVigPrec(idPaqPF_e, fechaPreVig, annio);
					
					if(!Objects.isNull(beneficiario.getIdBeneficiario())) {
						boolean bexiste = benefService.verificarExisteBeneficiario(beneficiario);
						//SI EXISTE ACTUALIZO
						if(bexiste) {
							//SETEAR DATOS FALTANTES
							beneficiario.setIdParentesco(beneficiario.getParentesco().getIdParentesco());
							beneficiario.setRfcTitular(beneficiario.getClientes().getRfc());
							Parentescos parentescotmp = parentescoService.getParentescoByIdParentesco(beneficiario.getParentesco().getIdParentesco());
							beneficiario.setParentesco(parentescotmp);
							Clientes clientetmp = clientesService.getClienteByRfc(beneficiario.getClientes().getRfc());
							beneficiario.setClientes(clientetmp);
							
							beneficiario.setCostoAsegurado((beneficiario.getAsegurado())?(Objects.isNull(paquete)?0:paquete.getPrecioAse()):null);
							benefService.actualizarBeneficiario(beneficiario);
						}
					}else {
						//SI NO EXISTE REGISTRO
						//SETEAR DATOS FALTANTES
						beneficiario.setIdParentesco(beneficiario.getParentesco().getIdParentesco());
						beneficiario.setRfcTitular(beneficiario.getClientes().getRfc());
						Parentescos parentescotmp = parentescoService.getParentescoByIdParentesco(beneficiario.getParentesco().getIdParentesco());
						beneficiario.setParentesco(parentescotmp);
						Clientes clientetmp = clientesService.getClienteByRfc(beneficiario.getClientes().getRfc());
						beneficiario.setClientes(clientetmp);
						beneficiario.setCostoAsegurado((beneficiario.getAsegurado())?(Objects.isNull(paquete)?0:paquete.getPrecioAse()):null);
						
						benefService.crearBeneficiario(beneficiario);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				//CASUISTICA PARA CUANDO LOS BENEFICIARIOS YA FUERON REGISTRADOS (EXISTEN PERO YA NO SE DESEAN 
				//REGISTRAR AL MOMENTO DE UNA RENOVACIÓN-UPGRADES)
				try {
					if(!Objects.isNull(beneficiario.getIdBeneficiario())) {
						boolean bexiste = benefService.verificarExisteBeneficiario(beneficiario);
						//SI EXISTE ELIMINO(FISICAMENTE)
						if(bexiste) {
							benefService.eliminarBeneficiarioFisica(beneficiario.getIdBeneficiario());
						}
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		//SETEAR VALORES PARA MOSTRAR FORMULARIOS
		
		//model.addAttribute("clienteForm", new Clientes());
		//model.addAttribute("listTab","active");
		return "redirect:/clienteForm";
		//return "user_form/cliente-view";
	}
	
	@GetMapping("/beneficiarioCliente/{rfct}")
	public String obtBeneficiariosForm(Model model, @PathVariable(name = "rfct")String rfct)throws Exception{
		
		//TODO: Obtener variable de session para tipo de servicio, folio y tipo de paquete.
		LocalDateTime fechaHoy = LocalDateTime.now();
		//Date fechaHoy = new Date();
		Integer SERVICIO_OBTENIDO_SESSION = 1;
		Integer tiposervicio = 0;
		//TODO
		tiposervicio = SERVICIO_OBTENIDO_SESSION;
		Integer annioInt = fechaHoy.getYear();
		String annio = Integer.toString(annioInt);
		String annioPrev = Integer.toString(tiposervicio==1?annioInt:annioInt-1);
		System.out.println("El año actual: " + annio);
		System.out.println("El año previo: " + annioPrev);
		//String annio = Integer.toString(fechaHoy.getYear());
		String folioConvenio = "";
		String tipoServicio = "";
		String idPaqPF_e = "PAQ ECO";
		String idPaqPF_b = "PAQ BAS";
		String idPaqPF_c = "PAQ CREM";
		//String fechaVigPre = annio+"-31-12";
		//String fechaVigPre = annio+"-31-12 00:00:00";
		
		boolean rprev = false;
		
		String fechaVigPre = annio+"-12-31 00:00:00";
		//String fechaVigPre = "2018-12-31 00:00:00";
		
		//String fechaVigPre = "12-31-"+annio;
		BeneficiariosTDto beneficiariosDto = new BeneficiariosTDto();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime fechaPreVig = LocalDateTime.parse(fechaVigPre, formateador);
		try {
			//Paquetespfs paquete = paquetesService.getPFxIdAndFchVigPrec(idPaqPF_e, fechaVigPre);
			//VALIDAR EL PAQUETE DESDE EL INICIO PARA BLOQUEAR TODO EL SISTEMA, DEBIDO A QUE PUEDE CAUSAR
			//INCOSISTENCIAS AL DEJAR PASAR EL FLUJO DEL PROCESO
			Pfdetalle paquete = pfdetalleService.getPFxIdAndFchVigPrec(idPaqPF_e, fechaPreVig, annio);
			//Paquetespfs paquete = paquetesService.getPFxIdAndFchVigPrec(idPaqPF_e, fechaPreVig);
			
			//CASO DE RENOVACIÓN O ACTUALIZACIÓN, PREGUNTAR PRIMERO SI EXISTE REGISTROS EN EL AÑO ACTUAL
			//SI EXITE POR LO MENOS UNO, YA NO RECUPERO LOS PREVIOS
			//SI NO EXISTE NINGUNO RECUPERO LOS PREVIOS
			
			Iterable<Beneficiarios> beneficiarioT = benefService.getBenefXRfcAndAnioAsegurado(rfct, (annio));
			
			//Set<Beneficiarios> beneficiarioS = benefService.getBenefXRfcAndAnioAsegurado(rfct, annio);
			
			//Iterator<Beneficiarios> beneficiarioT = beneficiarioS.iterator();
			//beneficiarioT.
			long numbenef = StreamSupport.stream(beneficiarioT.spliterator(), false).count();
			//int numbenef = Objects.isNull(beneficiarioS)?0:beneficiarioS.size();
			System.out.println("Cantidad recuperada: " + Long.toString(numbenef));
			int existentes = (int)numbenef;
			System.out.println("Cantidad recuperada seteada: " + existentes);
			if (tiposervicio > 1 && existentes == 0) {
				beneficiarioT = benefService.getBenefXRfcAndAnioAsegurado(rfct, (annioPrev));
				numbenef = StreamSupport.stream(beneficiarioT.spliterator(), false).count();
				existentes = (int)numbenef;
				rprev = true;
			}
			//int existentes = numbenef;
			//if (numbenef >= 1) {
			int restantes = 3;
			restantes = restantes - existentes;
			//}
			//CICLO PARA POBLAR LOS EXISTENTES
			Iterator<Beneficiarios> beneficiariosItera = beneficiarioT.iterator();
			//Iterator<Beneficiarios> beneficiariosItera = beneficiarioS.iterator();
			while(beneficiariosItera.hasNext()) {
				Beneficiarios e = (Beneficiarios) beneficiariosItera.next();
				if(tiposervicio == 1) {
					beneficiariosDto.addBeneficiariosTitular(e);
				}else if(tiposervicio == 2 || tiposervicio == 3) {
					if(rprev) {
						e.setIdBeneficiario(null);
						e.setFolioConvenio(null);
						e.setCostoAsegurado((e.getAsegurado())?(Objects.isNull(paquete)?0:paquete.getPrecioAse()):0);
						e.setAnioAsegurado(annio);
						e.setUsrCreReg(null);
						e.setFchCreReg(null);
						e.setUsrModReg(null);
						e.setFchModReg(null);
					}
					beneficiariosDto.addBeneficiariosTitular(e);
					System.out.println("El valor de ID Beneficiario:" + e.getIdBeneficiario());
					System.out.println("El costo asegurado: " + e.getCostoAsegurado());
					System.out.println("El rfcTitular:" + e.getRfcTitular());
					System.out.println("El rfcTitularB:" + e.getClientes().getRfc());
					System.out.println("El año asegurado: " + e.getAnioAsegurado());
				}
			}
			
			//CICLO PARA POBLAR LOS FALTANTES
			for(int i = 1; i <= restantes; i++) {
				Beneficiarios benefComp = new Beneficiarios();
				
				//if(tiposervicio == 1) {
					benefComp.setClientes(new Clientes());
					benefComp.getClientes().setRfc(rfct);
					//benefComp.setRfcTitular(rfct);
					//benefComp.setCostoAsegurado(Objects.isNull(paquete)?0:paquete.getPrecioAse());
					benefComp.setAnioAsegurado(annio);
					benefComp.setActivo(true);
				//} if(tiposervicio == 2) {
				//	benefComp.setRfcTitular(rfct);
				//	benefComp.setCostoAsegurado(Objects.isNull(paquete)?0:paquete.getPrecioAse());
				//	benefComp.setAnioAsegurado(annio);
				//}
				
				beneficiariosDto.addBeneficiariosTitular(benefComp);
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		//OBJETOS PARA EL FORMULARIO DE CIENTES Y LISTADO DE CLIENTES
		model.addAttribute("clienteForm", new Clientes());
		model.addAttribute("direccionesDto", new DireccionesDto());
		model.addAttribute("cpC", new Cat_cps());
		model.addAttribute("asentamientoC", new Asentamientos());
		model.addAttribute("estadoC", new Cat_estados());
		model.addAttribute("municipioC", new Cat_mnpios());
		model.addAttribute("clienteList", clientesService.getAllClientes());
		model.addAttribute("generos", Generos.values());
		//model.addAttribute("listTab","active");
		//OBJETOS PARA EL FORMULARIO DE CIENTES Y LISTADO DE CLIENTES
		
		
		model.addAttribute("beneficiarioForm", beneficiariosDto);
		model.addAttribute("listaParentescos", parentescoService.getAllParentescos());
		model.addAttribute("listaAsegurados", Sino.values());
		
		model.addAttribute("formbTab", "active");
		return "user_form/cliente-view";
	}
	
	@GetMapping("/modificarCliente/{id}")
	public String obtModificarClienteForm(Model model, @PathVariable(name = "id")Integer id)throws Exception{
		Clientes clienteEditar = clientesService.getClienteById(id);
		model.addAttribute("clienteForm", clienteEditar);
		String cp = Long.toString((Objects.isNull(clienteEditar.getCat_cps()))?0:clienteEditar.getCat_cps().getCp());
		Set<DireccionesDto> direccionesDtoL = new HashSet<>();
		direccionesDtoL = llenardireccionxcp(cp);
		model.addAttribute("direccionesDto", direccionesDtoL);
		model.addAttribute("municipioC", Objects.isNull(clienteEditar.getMunicipio())?new Cat_mnpios():clienteEditar.getMunicipio());
		model.addAttribute("estadoC", Objects.isNull(clienteEditar.getEstado())?new Cat_estados():clienteEditar.getEstado());
		model.addAttribute("cpC", Objects.isNull(clienteEditar.getCat_cps())?new Cat_cps():clienteEditar.getCat_cps());
		model.addAttribute("asentamientoC", Objects.isNull(clienteEditar.getAsentamientos())?new Asentamientos():clienteEditar.getAsentamientos());
		model.addAttribute("generos", Generos.values());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		return "user_form/cliente-view";
	}
	
	@GetMapping("/eliminarCliente/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Integer id) {
		try {
			//userService.deleteUser(id);
			int resp = -1;
			resp = clientesService.eliminarClienteLogica(id);
		} 
		catch (ClienteIdNoExiste in) {
			model.addAttribute("listErrorMessage",in.getMessage());
		}
		return userForm(model);
	}
	
	@GetMapping("/clienteForm/cancelar")
	public String cancelarEditarUsuario(ModelMap model) {
		return "redirect:/clienteForm";
	}
	
	@ModelAttribute("dir")
	public Set<DireccionesDto> llenardireccionxcp(String cp) {
		String lcp = "";
		if (cp == null) { 
			lcp = "0"; 
		} else if (cp=="") {
			lcp = "0"; 
		} else 
			lcp = cp;
		Set<Direcciones> direcciones = direccionesrepo.findAllByCp(Long.parseLong(lcp));
		Set<DireccionesDto> listadirecciones = new HashSet<>();
		Iterator<Direcciones> direccion = direcciones.iterator();
		
		while(direccion.hasNext()) {
			Direcciones d = (Direcciones) direccion.next();
			DireccionesDto dtmp = new DireccionesDto();
			System.out.println("CP: " + d.getCp());
			dtmp.setCp(d.getCp());
			
			Cat_asentamientos catasent = d.getAsentamientos().getCat_asentamientos();
			dtmp.setIdRegTipoS(catasent.getIdRegTipoS());
			dtmp.setDescAsentamiento(catasent.getDescAsentamiento());
			
			Asentamientos a = d.getAsentamientos();
			dtmp.setIdRegAsentaS(a.getIdRegAsentaS());
			dtmp.setDescAsentaS(a.getDescAsentaS() + "/" + catasent.getDescAsentamiento());
			
			
			Cat_estados catestados = d.getCat_estados();
			dtmp.setIdRegEstadoS(catestados.getIdRegEstadoS());
			dtmp.setDescEstado(catestados.getDescEstado());
			Cat_mnpios catmnpio = d.getCat_mnpios();
			dtmp.setIdRegMnpioS(catmnpio.getIdRegMnpioS());
			dtmp.setDescMnpio(catmnpio.getDescMnpio());
			listadirecciones.add(dtmp);
		}
		
		return listadirecciones;
	}
	
}
