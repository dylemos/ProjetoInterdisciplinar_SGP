package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;


public interface IRepositorioCliente {

	public Cliente cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClassNotFoundException, ClienteCpfInvalidoException, Exception;

	public Cliente atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException, Exception, ClienteCpfInvalidoException;

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException, Exception;

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException, Exception;

	public HashSet<Cliente> listarClientes() throws Exception;

}
