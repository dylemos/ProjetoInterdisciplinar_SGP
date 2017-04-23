package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;

public class UserAdminDAO {
	
	public UserAdminDAO() throws Exception {
		SGP_MySQL.getInstance();
	}

	public void cadastrarUserAdminNoBancoDeDados(UserAdmin userAdmin) throws SQLException, UserAdminJaCadastradoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into userAdmin(ID_ADM, NOME, LOGIN, SENHA)";
			query += "values('"+userAdmin.getId()+"','"+userAdmin.getNomeUserAdmin()+"', '"+userAdmin.getLogin()+"', '"+userAdmin.getSenha()+"')";
			statement.execute(query);
			System.out.println("\n UserAdmin "+userAdmin.getNomeUserAdmin()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}

	public void atualizarUserAdminNoBancoDeDados(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException {
		// TODO Auto-generated method stub

	}

	public void removerUserAdminNoBancoDeDados(String cpf)
			throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {
		// TODO Auto-generated method stub

	}

	public UserAdmin procurarUserAdminNoBancoDeDados(String cpf)
			throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<UserAdmin> listarUserAdminsNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}

}