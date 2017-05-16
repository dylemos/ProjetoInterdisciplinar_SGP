package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

	public void cadastrarContaNoBancoDeDados(Conta conta) throws SQLException, ContaJaCadastradaException, Exception {
		
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			//Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into conta(ID_CONTA, TIPOCONTA, STATUSCONTA, CPF_CLIENTE, VALOR, DESCONTO, TOTAL, DT_ABERTURA, DT_VENCIMENTO, DT_PAGO, QTD_PARCELAS)";
			query += "values(?,?,?,?,?,?,?,?)";
			
			PreparedStatement preStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preStatement.setString(1, conta.getTipoConta());
			preStatement.setString(2, conta.getStatusConta());
			preStatement.setString(3, conta.getCpfCliente());
			preStatement.setDouble(4, conta.getValor());
			preStatement.setDouble(5, conta.getDesconto());
			preStatement.setDouble(6, conta.getTotal());
			preStatement.setDate(7, (Date) conta.getDataAbertura());
			preStatement.setDate(8, (Date) conta.getDataVencimento());
			preStatement.setDate(9, (Date) conta.getDataPago());
			
			preStatement.execute();
			
			System.out.println("\n Conta "+conta.getTipoConta()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Conta "+conta.getTipoConta()+" já está Cadastrada no Banco de Dados! \n");
		}
		
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

	public HashSet<Conta> listarContasNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}

}
