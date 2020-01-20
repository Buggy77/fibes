
package com.fibeso.captacion.pfuneraria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fibeso.captacion.pfuneraria.entity.Clientes;
import com.fibeso.captacion.pfuneraria.exception.ClienteIdNoExiste;
import com.fibeso.captacion.pfuneraria.repository.ClientesRepository;
//import com.fibeso.captacion.pfuneraria.repository.Trasactional;

@Service
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	ClientesRepository cliRepository;
	
	@Override
	public Iterable<Clientes> getAllClientes() {

		return cliRepository.findAllByActivo(true);
	}
	
	//VAL
	private boolean verificarRfcCurpExiste(Clientes cliente) throws Exception{
		Optional<Clientes> clienteExiste = 
				cliRepository.findByRfcOrCurp(cliente.getRfc(), cliente.getCurp());
		if(clienteExiste.isPresent()) {
			throw new Exception("Cliente ya existe");
		}
		return false;
	}

	@Override
	public Clientes crearCliente(Clientes cliente) throws Exception {
		if(!verificarRfcCurpExiste(cliente)) {
			cliente = cliRepository.save(cliente);
		}
		return cliente;
	}

	@Override
	public Clientes getClienteById(Integer id) throws ClienteIdNoExiste{
		return cliRepository.findById(id).orElseThrow(() -> new ClienteIdNoExiste("Id de Cliente no existe."));
	}
	
	@Override
	@Transactional
	public int eliminarClienteLogica(Integer id) throws ClienteIdNoExiste {
		int resp = cliRepository.guardarEstatusInactivo(id);
		//Clientes cliente = getClienteById(id);
		//cliRepository
		return resp;
	}

	@Override
	@Transactional
	public Clientes actualizarCliente(Clientes cliente) throws Exception {
		Clientes clienteA = getClienteById(cliente.getIdCliente());
		//System.out.println("Valor de clienteA" + clienteA.getIdCliente().toString());
		//System.out.println("Valor de clienteA" + clienteA.getNombre());
		//System.out.println("Valor de clienteA" + clienteA.getAsentamientos().getIdRegAsentaS());
		//System.out.println("Valor de clienteA" + Long.toString(clienteA.getCat_cps().getCp()));
		//clienteA = mapCliente(cliente, clienteA);
		mapCliente(cliente, clienteA);
		//System.out.println("Después Valor de clienteA" + clienteA.getIdCliente().toString());
		//System.out.println("Después Valor de clienteA" + clienteA.getNombre());
		//System.out.println("Después Valor de clienteA" + clienteA.getAsentamientos().getIdRegAsentaS());
		//System.out.println("Después Valor de clienteA" + Long.toString(clienteA.getCat_cps().getCp()));
		return cliRepository.save(clienteA);
	}
	
	//protected Clientes mapCliente(Clientes from,Clientes to) {
	protected void mapCliente(Clientes from,Clientes to) {
		//to.setIdCliente(from.getIdCliente());
		to.setNombre(from.getNombre());
		to.setAppP(from.getAppP());
		to.setAppM(from.getAppM());
		to.setFchNacimiento(from.getFchNacimiento());
		to.setGenero(from.getGenero());
		to.setCorreoElect(from.getCorreoElect());
		to.setFolioife(from.getFolioife());
		to.setRfc(from.getRfc());
		to.setCurp(from.getCurp());
		to.setCalle(from.getCalle());
		to.setNoExt(from.getNoExt());
		to.setNoInt(from.getNoInt());
		to.setAsentamientos(from.getAsentamientos());
		to.setIdRegAsentaS(from.getIdRegAsentaS());
		to.setCat_cps(from.getCat_cps());
		to.setCp(from.getCp());
		to.setMunicipio(from.getMunicipio());
		to.setIdRegMnpioS(from.getIdRegMnpioS());
		to.setEstado(from.getEstado());
		to.setIdRegEstadoS(from.getIdRegEstadoS());
		to.setDesDireccion(from.getDesDireccion());
		to.setEnfePreexiste(from.getEnfePreexiste());
		to.setActivo(from.getActivo());
		to.setFchCreReg(from.getFchCreReg());
		to.setUsrCreReg(from.getUsrCreReg());
		//return to;
	}

	@Override
	public Clientes getClienteByRfc(String rfc) throws ClienteIdNoExiste {
		return cliRepository.findByRfcAndActivo(rfc, true).orElseThrow(() -> new ClienteIdNoExiste("RFC de Cliente no existe.")) ;
	}
	

}
