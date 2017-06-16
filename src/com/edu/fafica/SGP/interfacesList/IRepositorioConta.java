package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;

public interface IRepositorioConta {


	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException, Exception;

	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException;

	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException;

	public Conta procurarConta(String cpf) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException, ClassNotFoundException;

	public HashSet<Conta> listarContas() throws ClassNotFoundException;
}
