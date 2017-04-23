package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.entidadesDAO.ContaDAO;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.edu.fafica.SGP.interfacesList.IRepositorioConta;

public class RepositorioContaJDBC implements IRepositorioConta{

	private ContaDAO cDAO;
	
	public RepositorioContaJDBC() throws Exception {
		this.cDAO = new ContaDAO();
	}
	
	@Override
	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException {
		this.cDAO.cadastrarContaNoBancoDeDados(conta);
	}

	@Override
	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Conta> listarContas() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
