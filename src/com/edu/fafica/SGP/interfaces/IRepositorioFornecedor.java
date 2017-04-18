package com.edu.fafica.SGP.interfaces;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;
import com.edu.fafica.SGP.pessoas.Fornecedor;

public interface IRepositorioFornecedor {

	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException;

	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException;

	public void removerFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException;

	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException;

	public HashSet<Fornecedor> listarFornecedores();
	
}
