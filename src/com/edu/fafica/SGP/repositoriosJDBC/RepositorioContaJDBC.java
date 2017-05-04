package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.entidadesDAO.ContaDAO;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.edu.fafica.SGP.interfacesList.IRepositorioConta;

public class RepositorioContaJDBC implements IRepositorioConta{

	private ContaDAO cDAO;
	
	public RepositorioContaJDBC() throws Exception {
		this.cDAO = new ContaDAO();
	}
	
	@Override
	public void cadastrarConta(Conta conta) throws Exception {
		this.cDAO.cadastrarContaNoBancoDeDados(conta);
	}

	@Override
	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException {
		this.cDAO.atualizarContaNoBancoDeDados(conta);
	}

	@Override
	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		this.cDAO.removerContaNoBancoDeDados(id);
	}

	@Override
	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		this.cDAO.procurarContaNoBancoDeDados(id);
		return null;
	}

	@Override
	public HashSet<Conta> listarContas() {
		this.cDAO.listarContasNoBancoDeDados();
		return null;
	}
	
}
