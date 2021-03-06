package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.mysql.jdbc.CallableStatement;

public class ContaDAO {
	
	public ContaDAO() throws Exception {
		SGP_MySQL.getInstance();
	}

	public Conta cadastrarContaNoBancoDeDados(Conta conta) throws SQLException, ContaJaCadastradaException, Exception {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
/*		int qtdParcela = 0;
		qtdParcela = conta.getQtdParcelas();*/
		
		try {
			
			java.sql.CallableStatement cs = conn.prepareCall("{call sp_conta_insert(?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, conta.getTipoConta());
			cs.setString(2, conta.getStatusConta());
			cs.setString(3, conta.getCpfCliente());
			cs.setDouble(4, conta.getValor());
			cs.setDouble(5, conta.getDesconto());
			cs.setDouble(6, conta.getTotal());
			cs.setDate(7, (Date) conta.getDataAbertura());
			cs.setDate(8, (Date) conta.getDataVencimento());
			cs.setString(9, conta.getQtdParcelas());
			
			cs.execute();
			
			System.out.println("\n Conta "+conta.getId()+" Cadastrado no Banco de Dados! \n");
			/*Statement statement = conn.createStatement();
			
			for (int i = 1; i <= qtdParcela; i++) {
			String query = "";
			
			query += "insert into conta(ID_CONTA, TIPOCONTA, STATUSCONTA, CPF_CLIENTE, VALOR, DESCONTO, TOTAL, DT_ABERTURA, DT_VENCIMENTO, QTD_PARCELAS)";
			query += "values('"+conta.getId()+"','"+conta.getTipoConta()+"','"+conta.getStatusConta()+"', '"+conta.getCpfCliente()+"', '"+conta.getValor()+"', '"+conta.getDesconto()+"', '"+conta.getTotal()+"', '"+conta.getDataAbertura()+"', '"+conta.getDataVencimento()+"', '"+ i +"/"+conta.getQtdParcelas()+"')";
			statement.execute(query);
			System.out.println("\n Conta "+conta.getId()+" Cadastrado no Banco de Dados! \n");
			}*/
			
			return conta;
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Conta "+conta.getId()+" j� est� Cadastrado no Banco de Dados! \n");
		}
		return conta;
	}

	public void atualizarContaNoBancoDeDados(Conta conta) throws SQLException, ContaNaoEncontradaException {
		// TODO Auto-generated method stub

	}

	public void removerContaNoBancoDeDados(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		// TODO Auto-generated method stub

	}

	public Conta procurarContaNoBancoDeDados(String cpf) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Conta conta = new Conta();
		
		String sql = "";
		sql += "select ID_CONTA, CPF_CLIENTE, CLIENTE.NOME, TIPOCONTA, STATUSCONTA, VALOR, DESCONTO, TOTAL, DT_ABERTURA, CONTA.DT_VENCIMENTO, DT_PAGO, QTD_PARCELAS from conta ";
		sql += "join cliente on cliente.CPF = conta.CPF_CLIENTE ";
		sql += "where conta.cpf_cliente = " + "'" + cpf + "';";

		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {

				int codigo = rs.getInt(1);
				String cpfClienteConta = rs.getString(2);
				String nomeCliente = rs.getString(3);
				String tipoConta = rs.getString(4);
				String statusConta = rs.getString(5);
				Double valor = rs.getDouble(6);
				Double desconto = rs.getDouble(7);
				Double total = rs.getDouble(8);
				java.sql.Date dataAbertura = rs.getDate(9);
				java.sql.Date dataVencimento = rs.getDate(10);
				java.sql.Date dataPago = rs.getDate(11);
				String qtdParcelas = rs.getString(12);

				conta = new Conta(cpfClienteConta, nomeCliente, tipoConta, statusConta, valor, desconto, total, dataAbertura, dataVencimento, dataPago, qtdParcelas);
				conta.setId(codigo);
				
				System.out.println("\nCliente localizado no Banco de Dados:");
				System.out.println(conta.toString());
				//System.out.println(listaLigada);
				
			}
				
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return conta;
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
				String qtdParcelas = resultSet.getString(11);
				
				
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
		
		System.out.println("\nN�o Existe Plano no Banco de Dados!");
		return null;
	}

}
