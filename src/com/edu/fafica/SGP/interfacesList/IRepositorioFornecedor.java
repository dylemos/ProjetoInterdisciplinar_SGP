package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;

public interface IRepositorioFornecedor {

	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException, Exception;

	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException, Exception;

	public void removerFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, Exception;

	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, Exception;

	public HashSet<Fornecedor> listarFornecedores() throws ClassNotFoundException;
	
}
