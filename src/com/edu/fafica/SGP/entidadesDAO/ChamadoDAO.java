package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;

public class ChamadoDAO {
	

	public ChamadoDAO() throws Exception {
		SGP_MySQL.getInstance();
	}
	
	
	public void cadastrarChamadoNoBancoDeDados(Chamado chamado) throws ClassNotFoundException, ChamadoJaCadastradoException, ChamadoIdInvalidoException, Exception{
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			String query = "";
			
			query += "insert into chamado(CPF_CLIENTE, TIPOCHAMADO, DESCPROBLEMA, STATUS, DT_ABERTURA, DT_FECHAMENTO)";
			query += "values(?,?,?,?,?,?)";

//			query += "";
//			query += "select * from cliente ";
//			query += "join chamado on chamado.id_cliente = cliente.id_cliente ;";

			PreparedStatement preStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			
//		    ResultSet resultSet = preStatement.executeQuery("SELECT LAST_INSERT_ID()");
//	        if (resultSet.next()) {
//	            int novoId = resultSet.getInt("LAST_INSERT_ID()");
//	        }
//			
//			final int novoId = resultSet.getInt(1);
			
//			preStatement.executeUpdate();
			
			preStatement.setString(1, chamado.getCpfCliente());
			preStatement.setString(2, chamado.getTipoChamado());
			preStatement.setString(3, chamado.getDescProblema());
			preStatement.setString(4, chamado.getStatusChamado());
			preStatement.setDate(5, (Date) chamado.getDataAbertura());
			preStatement.setDate(6, (Date) chamado.getDataFechamento());
			
			preStatement.execute();
			
			System.out.println("\n Chamado "+chamado.getTipoChamado()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Chamado "+chamado.getTipoChamado()+" já está Cadastrado no Banco de Dados! \n");
		}
	}


	public void atualizarChamadoNoBancoDeDados(Chamado chamado) throws SQLException, ChamadoNaoEncontradoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update chamado set  CPF_CLIENTE=?, TIPOCHAMADO=? , DESCPROBLEMA=?, STATUS=? DT_ABERTURA=? DT_FECHAMENTO=? where DESCPROBLEMA=?";
				
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			preStatement = conn.prepareStatement(sql);
			
			preStatement.setString(1, chamado.getCpfCliente());
			preStatement.setString(2, chamado.getTipoChamado());
			preStatement.setString(3, chamado.getDescProblema());
			preStatement.setString(4, chamado.getStatusChamado());
			preStatement.setDate(5, (Date) chamado.getDataAbertura());
			preStatement.setDate(6, (Date) chamado.getDataFechamento());
			
			preStatement.setString(7, chamado.getDescProblema());
			
			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n Chamado "+chamado.getTipoChamado()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}


	public void removerChamadoNoBancoDeDados(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		// TODO Auto-generated method stub
		
	}


	public Chamado procurarChamadoNoBancoDeDados(int id)
			throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}


	public HashSet<Chamado> listarChamadosNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
