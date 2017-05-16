package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;

public class UserAdminDAO {
	
	HashSet<UserAdmin> listUserAdmin;
	
	public UserAdminDAO() throws Exception {
		SGP_MySQL.getInstance();
	}

	public void cadastrarUserAdminNoBancoDeDados(UserAdmin userAdmin) throws SQLException, UserAdminJaCadastradoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into userAdmin(ID_ADM, STATUS, NOME, CPF, LOGIN, SENHA)";
			query += "values('"+userAdmin.getId()+"','"+userAdmin.getStatus()+"', '"+userAdmin.getNomeUserAdmin()+"',  '"+userAdmin.getCpf()+"', '"+userAdmin.getLogin()+"', '"+userAdmin.getSenha()+"')";
			statement.execute(query);
			System.out.println("\n UserAdmin "+userAdmin.getNomeUserAdmin()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n UserAdmin "+userAdmin.getNomeUserAdmin()+" já está Cadastrado no Banco de Dados! \n");
		}
		
	}

	public void atualizarUserAdminNoBancoDeDados(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException, ClassNotFoundException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update userAdmin set  STATUS=?, NOME=?, LOGIN=? , SENHA=? where NOME= ?";
				
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			preStatement = conn.prepareStatement(sql);
			
			preStatement.setString(1, userAdmin.getStatus());
			preStatement.setString(2, userAdmin.getNomeUserAdmin());
			preStatement.setString(3, userAdmin.getLogin());
			preStatement.setString(4, userAdmin.getSenha());
			
			preStatement.setString(5, userAdmin.getNomeUserAdmin());
			
			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n UserAdmin "+userAdmin.getNomeUserAdmin()+" Atualizado no Banco de Dados:");
			System.out.println(userAdmin.toString());
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		

	}

	public void removerUserAdminNoBancoDeDados(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException, ClassNotFoundException {
	
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {

			if(listarUserAdminsNoBancoDeDados().contains(cpf)){
			
				// Criando a String SQL
				String sql = "delete from userAdmin where CPF = ?";

				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);

				preStatement.setString(1, cpf);

				// Executando o select
				preStatement.executeUpdate();
				
				System.out.println("UserAdmin Removido do Banco de Dados com Sucesso!");
			
			}else{
				System.out.println("UserAdmin Não existe para ser Removido do Banco de Dados!");
			}
	
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

	}

	public UserAdmin procurarUserAdminNoBancoDeDados(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		UserAdmin userAdmin = new UserAdmin();
		
		try {
			
			if(listarUserAdminsNoBancoDeDados().contains(cpf)){
				
				String sql = "select * from USERADMIN where CPF=?";

				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, cpf);
				
				ResultSet resultSet = preStatement.executeQuery();
				
				while (resultSet.next()) {
					
					int codigo = resultSet.getInt(1);
					String status = resultSet.getString(2);
					String nome = resultSet.getString(3);
					String cpfUA  = resultSet.getString(4);
					String login = resultSet.getString(5);
					String senha = resultSet.getString(6);
					
					userAdmin = new UserAdmin(status, nome, cpfUA, login, senha);
					userAdmin.setId(codigo);
					
					System.out.println("\nUserAdmin localizado no Banco de Dados:");
					System.out.println(userAdmin.toString());
				
				}
				
			}else{
				System.out.println("UserAdmin Não Cadastrado no Banco de Dados!");
			}
			
			} catch (Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}
		
		return userAdmin;
	}

	public HashSet<UserAdmin> listarUserAdminsNoBancoDeDados() throws ClassNotFoundException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		UserAdmin userAdmin = new UserAdmin();
		this.listUserAdmin = new HashSet<UserAdmin>();

		try {
			
			// Criando a String SQL
			String sql = "select * from USERADMIN";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String status = resultSet.getString(2);
				String nome = resultSet.getString(3);
				String cpfUA  = resultSet.getString(4);
				String login = resultSet.getString(5);
				String senha = resultSet.getString(6);
				
				userAdmin = new UserAdmin(status, nome, cpfUA, login, senha);
				userAdmin.setId(codigo);
				
				listUserAdmin.add(userAdmin);
				System.out.println("\nUserAdmin no Banco de Dados:");
				System.out.println(userAdmin.toString());
			}
			return listUserAdmin;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println("\nNão Existe UserAdmin no Banco de Dados!");
		return null;
	}

}
