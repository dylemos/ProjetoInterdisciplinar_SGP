package com.edu.fafica.SGP.interfaces;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;
import com.edu.fafica.SGP.plano.Plano;

public interface IRepositorioPlano {

	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException;

	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException;

	public void removerPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException;

	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException;

	public HashSet<Plano> listarPlanos();
}
