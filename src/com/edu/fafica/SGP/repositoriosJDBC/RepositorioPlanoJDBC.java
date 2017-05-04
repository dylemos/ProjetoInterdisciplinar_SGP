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
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException, ClassNotFoundException {
		this.pDAO.cadastrarPlanoNoBancoDeDados(plano);
	}

	@Override
	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, ClassNotFoundException {
		this.pDAO.atualizarPlanoNoBancoDeDados(plano);
	}

	@Override
	public void removerPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {
		this.pDAO.removerPlanoNoBancoDeDados(plano);
	}

	@Override
	public Plano procurarPlano(String nomePlano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {
		this.pDAO.procurarPlanoNoBancoDeDados(nomePlano);
		return null;
	}

	@Override
	public HashSet<Plano> listarPlanos() throws ClassNotFoundException {
		this.pDAO.listarPlanosNoBancoDeDados();
		return null;
	}

}
