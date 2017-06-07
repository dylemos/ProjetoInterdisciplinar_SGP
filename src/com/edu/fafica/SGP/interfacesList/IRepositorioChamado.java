package com.edu.fafica.SGP.interfacesList;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;

public interface IRepositorioChamado {

	public void cadastrarChamado(Chamado chamado) throws SQLException, ChamadoJaCadastradoException, ClassNotFoundException, ChamadoIdInvalidoException, Exception;

	public void atualizarChamado(Chamado chamado) throws SQLException, ChamadoNaoEncontradoException, ClassNotFoundException, Exception;

	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException;

	public Chamado procurarChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException;

	public HashSet<Chamado> listarChamados() throws ClassNotFoundException;
}
