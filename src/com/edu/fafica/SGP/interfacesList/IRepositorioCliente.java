package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;


public interface IRepositorioCliente {

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClassNotFoundException, ClienteCpfInvalidoException, Exception;

	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException;

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException;

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException;

	public HashSet<Cliente> listarClientes();

}
