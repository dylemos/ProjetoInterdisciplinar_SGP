package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.interfacesJDBC.IRepositorioClienteJDBC;

public class RepositorioClienteJDBC implements IRepositorioClienteJDBC{

	@Override
	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerCliente(String cpf)
			throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente procurarCliente(String cpf)
			throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listarClientes() {
		// TODO Auto-generated method stub
		
	}

}
