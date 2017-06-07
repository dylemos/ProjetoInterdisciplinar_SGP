package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;

public class ContaDAO {
	
	public ContaDAO() throws Exception {
		SGP_MySQL.getInstance();
	}

	public Conta cadastrarContaNoBancoDeDados(Conta conta) throws SQLException, ContaJaCadastradaException, Exception {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into conta(ID_CONTA, TIPOCONTA, STATUSCONTA, CPF_CLIENTE, VALOR, DESCONTO, TOTAL, DT_ABERTURA, DT_VENCIMENTO, QTD_PARCELAS)";
			query += "values('"+conta.getId()+"','"+conta.getTipoConta()+"','"+conta.getStatusConta()+"', '"+conta.getCpfCliente()+"', '"+conta.getValor()+"', '"+conta.getDesconto()+"', '"+conta.getTotal()+"', '"+conta.getDataAbertura()+"', '"+conta.getDataVencimento()+"', '"+conta.getQtdParcelas()+"')";
			statement.execute(query);
			System.out.println("\n Conta "+conta.getId()+" Cadastrado no Banco de Dados! \n");
			
			return conta;
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Conta "+conta.getId()+" já está Cadastrado no Banco de Dados! \n");
		}
		return conta;
	}

	public void atualizarContaNoBancoDeDados(Conta conta) throws SQLException, ContaNaoEncontradaException {
		// TODO Auto-generated method stub

	}

	public void removerContaNoBancoDeDados(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		// TODO Auto-generated method stub

	}

	public Conta procurarContaNoBancoDeDados(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Conta> listarContasNoBancoDeDados()  throws ClassNotFoundException{
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Conta conta = new Conta();
		HashSet<Conta> listConta = new HashSet<Conta>();
try {
			
			// Criando a String SQL
			String sql = "select * from conta";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				
				int id = resultSet.getInt(1);
				String cpfCliente = resultSet.getString(2);
				String tipoConta  = resultSet.getString(3);
				String statusConta = resultSet.getString(4);
				Double valor = resultSet.getDouble(5);
				Double desconto = resultSet.getDouble(6);
				Double total = resultSet.getDouble(7);
				java.sql.Date dataAbertura = resultSet.getDate(8);
				java.sql.Date dataVencimento = resultSet.getDate(9);
				java.sql.Date dataPago = resultSet.getDate(10);
				int qtdParcelas = resultSet.getInt(11);
				
				
				conta = new Conta(cpfCliente, tipoConta, statusConta, valor, desconto, total, dataAbertura, dataVencimento, dataPago, qtdParcelas);
				conta.setId(id);
				
				listConta.add(conta);
				System.out.println("\nPlano no Banco de Dados:");
				System.out.println(conta.toString());
			}
			return listConta;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println("\nNão Existe Plano no Banco de Dados!");
		return null;
	}

}
