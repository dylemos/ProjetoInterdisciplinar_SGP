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
	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException, ClassNotFoundException {
		this.fDAO.atualizarFornecedorNoBancoDeDados(fornecedor);
	}

	@Override
	public void removerFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, ClassNotFoundException {
		this.fDAO.removerFornecedorNoBancoDeDados(cnpj);
	}

	@Override
	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, ClassNotFoundException {
		this.fDAO.procurarFornecedorNoBancoDeDados(cnpj);
		return null;
	}

	@Override
	public HashSet<Fornecedor> listarFornecedores() throws ClassNotFoundException {
		HashSet<Fornecedor> lista = fDAO.listarFornecedoresNoBancoDeDados();
		return lista;
	}

}
