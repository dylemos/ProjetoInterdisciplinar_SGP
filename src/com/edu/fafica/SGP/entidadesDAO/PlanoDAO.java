package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
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

	public void removerPlanoNoBancoDeDados(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		// TODO Auto-generated method stub

	}

	public Plano procurarPlanoNoBancoDeDados(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Plano> listarPlanosNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}

}
