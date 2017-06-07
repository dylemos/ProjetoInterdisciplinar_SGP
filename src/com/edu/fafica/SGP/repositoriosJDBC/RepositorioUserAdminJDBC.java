package com.edu.fafica.SGP.repositoriosJDBC;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.entidadesDAO.UserAdminDAO;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioUserAdmin;

public class RepositorioUserAdminJDBC implements IRepositorioUserAdmin{

	private UserAdminDAO uDAO;
	
	public RepositorioUserAdminJDBC() throws Exception {
		this.uDAO = new UserAdminDAO();
	}
	
	@Override
	public void cadastrarUserAdmin(UserAdmin userAdmin) throws UserAdminJaCadastradoException, Exception {
		this.uDAO.cadastrarUserAdminNoBancoDeDados(userAdmin);
	}

	@Override
	public void atualizarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException, ClassNotFoundException {
		this.uDAO.atualizarUserAdminNoBancoDeDados(userAdmin);
	}

	@Override
	public void removerUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException, ClassNotFoundException {
		this.uDAO.removerUserAdminNoBancoDeDados(cpf);
	}

	@Override
	public UserAdmin procurarUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException, ClassNotFoundException {
		this.uDAO.procurarUserAdminNoBancoDeDados(cpf);
		return null;
	}

	@Override
	public HashSet<UserAdmin> listarUserAdmins() throws ClassNotFoundException {
		HashSet<UserAdmin> lista = uDAO.listarUserAdminsNoBancoDeDados();
		return lista;
	}

}
