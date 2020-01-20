package com.fibeso.captacion.pfuneraria.service;

import com.fibeso.captacion.pfuneraria.entity.Clientes;
import com.fibeso.captacion.pfuneraria.exception.ClienteIdNoExiste;

public interface ClientesService {

	public Iterable<Clientes> getAllClientes();
	
	public Clientes crearCliente(Clientes cliente) throws Exception;
	
	public Clientes actualizarCliente(Clientes cliente) throws Exception;
	
	public Clientes getClienteById(Integer id) throws Exception;
	
	public Clientes getClienteByRfc(String rfc) throws Exception;
	
	public int eliminarClienteLogica(Integer id) throws ClienteIdNoExiste;
	
}
