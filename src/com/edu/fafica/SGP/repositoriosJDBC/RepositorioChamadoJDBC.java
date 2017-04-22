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
	public void cadastrarChamado(Chamado chamado, Cliente cliente) throws ClassNotFoundException, ChamadoIdInvalidoException, ChamadoJaCadastradoException, Exception {
		this.chamadoDAO.cadastrarChamadoNoBancoDeDados(chamado, cliente);
	}

	@Override
	public void atualizarChamado(Chamado chamado, Cliente cliente) throws SQLException, ChamadoNaoEncontradoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chamado procurarChamado(int id)
			throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Chamado> listarChamados() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
