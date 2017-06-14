package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void cadastrarPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoJaCadastradoException, ClassNotFoundException {
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into plano(IDPLANO, NOME, UPLOAD, DOWNLOAD, VALOR)";
			query += "values('"+plano.getId()+"','"+plano.getNomePlano()+"', '"+plano.getUpload()+"', '"+plano.getDownload()+"', '"+plano.getValor()+"')";
			statement.execute(query);
			System.out.println("\n Plano "+plano.getNomePlano()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Plano "+plano.getNomePlano()+" já está Cadastrado no Banco de Dados! \n");
		}
		
	}

	public void atualizarPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoNaoEncontradoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update plano set  NOME=?, UPLOAD=? , DOWNLOAD=?, VALOR=? where IDPLANO=?";
				
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			preStatement = conn.prepareStatement(sql);
			
			preStatement.setString(1, plano.getNomePlano());
			preStatement.setInt(2, plano.getUpload());
			preStatement.setInt(3, plano.getDownload());
			preStatement.setDouble(4, plano.getValor());
			
			preStatement.setInt(5, plano.getId());
			
			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n Plano "+plano.getNomePlano()+" Atualizado no Banco de Dados:");
			System.out.println(plano.toString());
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}

	public void removerPlanoNoBancoDeDados(Plano plano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			if(listarPlanosNoBancoDeDados().contains(plano)){
				
				// Criando a String SQL
				String sql = "delete from plano where NOME = ?";

				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);

				preStatement.setString(1, plano.getNomePlano());

				// Executando o select
				preStatement.executeUpdate();
				
				System.out.println("Plano Removido do Banco de Dados com Sucesso!");
				
			}else{
				System.out.println("Plano Não existe para ser Removido do Banco de Dados!");
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}

	public Plano procurarPlanoNoBancoDeDados(String nomePlano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Plano plano = new Plano();
		
		String sql = "";
		sql += "select * from plano ";
		sql += "where nome = " + "'" + nomePlano + "';";
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()){
				
					int codigo = rs.getInt(1);
					String nome = rs.getString(2);
					int upload  = rs.getInt(3);
					int download = rs.getInt(4);
					Double valor = rs.getDouble(5);
					
					plano = new Plano(nome, upload, download, valor);
					plano.setId(codigo);
					
					System.out.println("\nPlano localizado no Banco de Dados:");
					System.out.println(plano.toString());
				
				}
				
			} catch (Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}

		return plano;
	}

	public HashSet<Plano> listarPlanosNoBancoDeDados() throws ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
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
				System.out.println("\nPlano no Banco de Dados:");
				System.out.println(plano.toString());
			}
			return listPlano;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println("\nNão Existe Plano no Banco de Dados!");
		return null;
	}

}
