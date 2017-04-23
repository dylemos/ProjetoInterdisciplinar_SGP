package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.entidadesDAO.FornecedorDAO;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioFornecedor;

public class RepositorioFornecedorJDBC implements IRepositorioFornecedor{

	private FornecedorDAO fDAO; 
	
	public RepositorioFornecedorJDBC() throws Exception {
		this.fDAO = new FornecedorDAO();
	}
	
	@Override
	public void cadastrarFornecedor(Fornecedor fornecedor) throws Exception {
		this.fDAO.cadastrarFornecedorNoBancoDeDados(fornecedor);
	}

	@Override
	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerFornecedor(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Fornecedor procurarFornecedor(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Fornecedor> listarFornecedores() {
		// TODO Auto-generated method stub
		return null;
	}

}
