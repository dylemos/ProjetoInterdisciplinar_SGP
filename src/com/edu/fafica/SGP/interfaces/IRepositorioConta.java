package com.edu.fafica.SGP.interfaces;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.conta.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;

public interface IRepositorioConta {


	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException;

	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException;

	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException;

	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException;

	public HashSet<Conta> listarContas();
}
