package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;

public class LogarAdminDao {

	public LogarAdminDao() throws ClassNotFoundException {
		SGP_MySQL.getInstance();
	}

	public String nome = "";
	public boolean result;

	public boolean VerificarLogin(String login, String senha) throws SQLException, UserAdminNaoEncontradoException, Exception {
		String sql = "";
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		UserAdmin userAdmin = new UserAdmin();
		sql += "select nome from useradmin ";
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + "'";
		sql += " and STATUS = 'ATIVO';";

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				result = true;
				nome = rs.getString("nome");
				//System.out.println(nome);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
