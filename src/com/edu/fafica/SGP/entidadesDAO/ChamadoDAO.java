package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


	public Chamado atualizarChamadoNoBancoDeDados(Chamado chamado) throws SQLException, ChamadoNaoEncontradoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();

			String query = "";

			query += "update chamado set ";
			query += "CPF_CLIENTE='"+chamado.getCpfCliente()+"',TIPOCHAMADO='"+chamado.getTipoChamado()+"',DESCPROBLEMA2='"+chamado.getDescProblema2()+"',STATUS='"+chamado.getStatusChamado()+"',DT_FECHAMENTO='"+chamado.getDataFechamento()+"'";
			query += " where  ID_CHAMADO = " + "" + chamado.getId() + ";";
			statement.execute(query);
			System.out.println("\n Cliente "+chamado.getId()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		return chamado;
/*			// Criando a String SQL
			String sql = "update chamado set  CPF_CLIENTE=?, TIPOCHAMADO=? , DESCPROBLEMA=?, STATUS=? DT_ABERTURA=? DT_FECHAMENTO=? where ID_CHAMADO=?";
				
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
		}*/
		
	}


	public void removerChamadoNoBancoDeDados(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		// TODO Auto-generated method stub
		
	}


	public Chamado procurarChamadoNoBancoDeDados(String cpfCliente) throws ClassNotFoundException, ChamadoNaoEncontradoException, Exception{
		
	Connection conn = SGP_MySQL.getInstance().conectarBD();
	Chamado chamado = new Chamado();
	
	String sql = "";
	sql += "select ID_CHAMADO, CPF_CLIENTE, cliente.NOME, TIPOCHAMADO, DESCPROBLEMA, DESCPROBLEMA2, chamado.STATUS, DT_ABERTURA, DT_FECHAMENTO from chamado ";
	sql += "join cliente on cliente.CPF = chamado.CPF_CLIENTE ";
	sql += "where chamado.cpf_cliente = " + "'" + cpfCliente + "';";

	try {

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);

		if(rs.next()) {

			int codigo = rs.getInt(1);
			String cpfClienteChamado = rs.getString(2);
			String nomeCliente = rs.getString(3);
			String tipoChamado = rs.getString(4);
			String descProblema = rs.getString(5);
			String descProblema2 = rs.getString(6);
			String statusChamado = rs.getString(7);
			java.sql.Date dataAbertura = rs.getDate(8);
			java.sql.Date dataFechamento = rs.getDate(9);

			chamado = new Chamado(cpfClienteChamado, nomeCliente, tipoChamado, descProblema, descProblema2, statusChamado, dataAbertura, dataFechamento);
			chamado.setId(codigo);
			
			System.out.println("\nCliente localizado no Banco de Dados:");
			System.out.println(chamado.toString());
			//System.out.println(listaLigada);
			
		}
			
	} catch (Exception e) {
		System.out.println("Erro: "+e.getMessage());
	}
	return chamado;
	}


	public HashSet<Chamado> listarChamadosNoBancoDeDados() throws ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Chamado chamado = new Chamado();
		HashSet<Chamado> listChamado = new HashSet<Chamado>();
		
		try {
			String sql = "select * from chamado";
			PreparedStatement preStatement = conn.prepareStatement(sql);
			
			ResultSet resultSet = preStatement.executeQuery();
			
			while (resultSet.next()){
				
				int id = resultSet.getInt(1);
				String cpfCliente = resultSet.getString(2);
				String tipoChamado = resultSet.getString(3);
				String descProblema = resultSet.getString(4);
				String statusChamado = resultSet.getString(5);
				java.sql.Date dataAbertura = resultSet.getDate(6);
				java.sql.Date dataFechamento = resultSet.getDate(6);
				
				chamado = new Chamado(cpfCliente, tipoChamado, descProblema, statusChamado, dataAbertura, dataFechamento);
				chamado.setId(id);
				
				listChamado.add(chamado);
				System.out.println("\nPlano no Banco de Dados:");
				System.out.println(chamado.toString());
			}
			return listChamado;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println("\nNão Existe Plano no Banco de Dados!");
		return null;
	}
	
	
}
