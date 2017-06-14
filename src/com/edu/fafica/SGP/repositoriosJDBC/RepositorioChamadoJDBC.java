package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Chamado;
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
	public Chamado procurarChamado(String cpfCliente) {
		try {
			this.chamadoDAO.procurarChamadoNoBancoDeDados(cpfCliente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChamadoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HashSet<Chamado> listarChamados() throws ClassNotFoundException {
		HashSet<Chamado> listar;
		listar = chamadoDAO.listarChamadosNoBancoDeDados();
		return listar;
	}
	
}
