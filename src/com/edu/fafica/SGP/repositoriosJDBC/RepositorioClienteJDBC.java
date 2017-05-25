package com.edu.fafica.SGP.repositoriosJDBC;

import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidadesDAO.ClienteDAO;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioCliente;

public class RepositorioClienteJDBC implements IRepositorioCliente{

	private ClienteDAO clienteDAO;
	
	public RepositorioClienteJDBC() throws ClassNotFoundException {
		this.clienteDAO = new ClienteDAO();
	}
	
	@Override
	public Cliente cadastrarCliente(Cliente cliente) throws ClassNotFoundException, ClienteJaCadastradoException, ClienteCpfInvalidoException, Exception {
		this.clienteDAO.cadastrarClienteNoBancoDeDados(cliente);
		return cliente;
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws Exception, ClienteCpfInvalidoException, Exception {
		this.clienteDAO.atualizarClienteNoBancoDeDados(cliente);
	}

	@Override
	public void removerCliente(String cpf) throws Exception {
		this.clienteDAO.removerClienteNoBancoDeDados(cpf);
	}

	@Override
	public Cliente procurarCliente(String cpf) throws Exception {
		this.clienteDAO.procurarClienteNoBancoDeDados(cpf);
		return null;
	}

	@Override
	public HashSet<Cliente> listarClientes() throws Exception {
		HashSet<Cliente> lista = clienteDAO.listarClientesNoBancoDeDados();
		return lista;
	}


	
	
}
