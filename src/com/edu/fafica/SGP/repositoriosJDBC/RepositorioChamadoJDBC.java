package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidadesDAO.ChamadoDAO;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioChamado;

public class RepositorioChamadoJDBC implements IRepositorioChamado {
	
	private ChamadoDAO chamadoDAO;
	
	public RepositorioChamadoJDBC() throws Exception {
		this.chamadoDAO = new ChamadoDAO();
	}

	@Override
	public void cadastrarChamado(Chamado chamado) throws ClassNotFoundException, ChamadoIdInvalidoException, ChamadoJaCadastradoException, Exception {
		this.chamadoDAO.cadastrarChamadoNoBancoDeDados(chamado);
	}

	@Override
	public void atualizarChamado(Chamado chamado) throws SQLException, ChamadoNaoEncontradoException, Exception {
		this.chamadoDAO.atualizarChamadoNoBancoDeDados(chamado);
	}

	@Override
	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		this.chamadoDAO.removerChamadoNoBancoDeDados(id);
	}

	@Override
	public Chamado procurarChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		this.chamadoDAO.procurarChamadoNoBancoDeDados(id);
		return null;
	}

	@Override
	public HashSet<Chamado> listarChamados() {
		this.chamadoDAO.listarChamadosNoBancoDeDados();
		return null;
	}
	
}
