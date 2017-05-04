package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;

public interface IRepositorioPlano {

	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException, ClassNotFoundException;

	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, ClassNotFoundException;

	public void removerPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, ClassNotFoundException, PlanoIdInvalidoException;

	public Plano procurarPlano(String nomePlano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException;

	public HashSet<Plano> listarPlanos() throws ClassNotFoundException;
}
