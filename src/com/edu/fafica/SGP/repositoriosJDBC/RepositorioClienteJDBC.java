package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidadesDAO.ClienteDAO;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioCliente;

public class RepositorioClienteJDBC implements IRepositorioCliente{

	private ClienteDAO clienteDAO;
	
	public RepositorioClienteJDBC() throws ClassNotFoundException {
		this.clienteDAO = new ClienteDAO();
	}
	
	@Override
	public void cadastrarCliente(Cliente cliente) throws ClassNotFoundException, ClienteJaCadastradoException, ClienteCpfInvalidoException, Exception {
		this.clienteDAO.cadastrarClienteNoBancoDeDados(cliente);
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
	public HashSet<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
