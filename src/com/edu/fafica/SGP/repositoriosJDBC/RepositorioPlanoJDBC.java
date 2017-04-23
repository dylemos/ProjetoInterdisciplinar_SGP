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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Plano> listarPlanos() {
		// TODO Auto-generated method stub
		return null;
	}

}
