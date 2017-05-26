package com.edu.fafica.SGP.interfacesList;

import java.util.HashSet;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.edu.fafica.SGP.entidades.Cliente;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {
	public HashSet<Cliente> listarClientes(); 
}
