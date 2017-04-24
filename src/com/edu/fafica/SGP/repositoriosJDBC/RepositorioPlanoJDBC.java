package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.entidadesDAO.PlanoDAO;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioPlano;

public class RepositorioPlanoJDBC implements IRepositorioPlano{
	
	private PlanoDAO pDAO;
	
	public RepositorioPlanoJDBC() throws Exception {
		this.pDAO = new PlanoDAO();
	}

	@Override
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException {
		this.pDAO.cadastrarPlanoNoBancoDeDados(plano);
	}

	@Override
	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException {
		this.pDAO.atualizarPlanoNoBancoDeDados(plano);
	}

	@Override
	public void removerPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		this.pDAO.removerPlanoNoBancoDeDados(plano);
	}

	@Override
	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		this.pDAO.procurarPlanoNoBancoDeDados(id);
		return null;
	}

	@Override
	public HashSet<Plano> listarPlanos() {
		this.pDAO.listarPlanosNoBancoDeDados();
		return null;
	}

}
