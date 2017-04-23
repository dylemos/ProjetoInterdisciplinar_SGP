package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
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

	public void cadastrarContaNoBancoDeDados(Conta conta) throws SQLException, ContaJaCadastradaException {
		
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into conta(ID_CONTA, TIPOCONTA, STATUSCONTA, ID_CLIENTE, VALOR, DESCONTO, ACRESCIMO, QTD_PARCELAS)";
			query += "values('"+conta.getId()+"','"+conta.getTipoConta()+"', '"+conta.getStatusConta()+"', '"+conta.getIdCliente()+"', '"+conta.getValor()+"', '"+conta.getDesconto()+"', '"+conta.getAcrescimo()+"', '"+conta.getQtdParcelas()+"')";
			statement.execute(query);
			System.out.println("\n Conta "+conta.getTipoConta()+" Cadastrada no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
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
