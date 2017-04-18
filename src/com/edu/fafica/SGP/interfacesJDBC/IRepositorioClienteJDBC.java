package com.edu.fafica.SGP.interfacesJDBC;

import java.sql.SQLException;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;

public interface IRepositorioClienteJDBC {

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException;

	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException;

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException;

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException;

	public void listarClientes();

	
}
