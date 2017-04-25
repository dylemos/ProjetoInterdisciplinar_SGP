package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;

public class PlanoDAO {

	public PlanoDAO() throws Exception {
		SGP_MySQL.getInstance();
	}
	
	public void cadastrarPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoJaCadastradoException {
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into plano(IDPLANO, NOME, UPLOAD, DOWNLOAD, VALOR)";
			query += "values('"+plano.getId()+"','"+plano.getNomePlano()+"', '"+plano.getUpload()+"', '"+plano.getDownload()+"', '"+plano.getValor()+"')";
			statement.execute(query);
			System.out.println("\n Plano "+plano.getNomePlano()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}

	public void atualizarPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoNaoEncontradoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update plano set  NOME=?, UPLOAD=? , DOWNLOAD=?, VALOR=? where NOME=?";
				
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			preStatement = conn.prepareStatement(sql);
			
			preStatement.setString(1, plano.getNomePlano());
			preStatement.setInt(2, plano.getUpload());
			preStatement.setInt(3, plano.getDownload());
			preStatement.setDouble(4, plano.getValor());
			
			preStatement.setString(5, plano.getNomePlano());
			
			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n Plano "+plano.getNomePlano()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}

	public void removerPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "delete from plano where NOME = ?";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, plano.getNomePlano());

			// Executando o select
			preStatement.executeUpdate();
			
			System.out.println("Plano Removido do Banco de Dados com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}

	public Plano procurarPlanoNoBancoDeDados(String nomePlano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {

		Connection conn = SGP_MySQL.conectarBD();
		Plano plano = new Plano();
		
		try {
			

			String sql = "select * from plano where NOME=?";

			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, nomePlano);
			
			ResultSet resultSet = preStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				int upload  = resultSet.getInt(3);
				int download = resultSet.getInt(4);
				Double valor = resultSet.getDouble(5);
				
				plano = new Plano(nome, upload, download, valor);
				plano.setId(codigo);
				
				System.out.println("Plano localizado no Banco de Dados!");
				System.out.println(plano.toString());
			
			}
			
			} catch (Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}

		return null;
	}

	public HashSet<Plano> listarPlanosNoBancoDeDados() {
		
		Connection conn = SGP_MySQL.conectarBD();
		Plano plano = new Plano();
		HashSet<Plano> listPlano = new HashSet<Plano>();
		
		try {
			
			// Criando a String SQL
			String sql = "select * from plano";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				int upload  = resultSet.getInt(3);
				int download = resultSet.getInt(4);
				Double valor = resultSet.getDouble(5);
				
				plano = new Plano(nome, upload, download, valor);
				plano.setId(codigo);
				
				listPlano.add(plano);
				System.out.print("Plano no Banco de Dados:");
				System.out.println(plano.toString());
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		return listPlano;
	}

}
