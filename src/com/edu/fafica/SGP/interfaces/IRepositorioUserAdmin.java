package com.edu.fafica.SGP.interfaces;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;
import com.edu.fafica.SGP.pessoas.UserAdmin;


public interface IRepositorioUserAdmin {
	
	public void cadastrarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminJaCadastradoException;

	public void atualizarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException;

	public void removerUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException;

	public UserAdmin procurarUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException;

	public HashSet<UserAdmin> listarUserAdmins();
}
