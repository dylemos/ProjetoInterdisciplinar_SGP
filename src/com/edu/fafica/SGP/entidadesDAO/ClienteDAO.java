package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;

public class ClienteDAO {


	public ClienteDAO() throws ClassNotFoundException {
		SGP_MySQL.getInstance();
	}


	public Cliente cadastrarClienteNoBancoDeDados(Cliente cliente) throws ClassNotFoundException, ClienteJaCadastradoException, ClienteCpfInvalidoException, Exception{

		Connection conn = SGP_MySQL.getInstance().conectarBD();

		try {

			Statement statement = conn.createStatement();

			String query = "";

			query += "insert into cliente(ID_CLIENTE, status, nome, rg, cpf, dt_nascimento, dt_cadastro, email, telefone, celular, dt_vencimento, rua, numero, bairro, cidade, uf, cep, login, senha, tipoplano, operadora)";
			query += "values('"+cliente.getId()+"','"+cliente.getStatus()+"','"+cliente.getNomeCliente()+"', '"+cliente.getRg()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNascimento()+"', '"+cliente.getDataCadasatro()+"', '"+cliente.getEmail()+"', '"+cliente.getTelefone()+"', '"+cliente.getCelular()+"', '"+cliente.getVencimentoPlano()+"', '"+cliente.getRua()+"', '"+cliente.getNumero()+"', '"+cliente.getBairro()+"', '"+cliente.getCidade()+"', '"+cliente.getUf()+"', '"+cliente.getCep()+"', '"+cliente.getLogin()+"', '"+cliente.getSenha()+"', '"+cliente.getTipoPlano()+"', '"+cliente.getOperadora()+"')";
			statement.execute(query);
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Cadastrado no Banco de Dados! \n");

			return cliente;

		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" j� est� Cadastrado no Banco de Dados! \n");
		}
		return cliente;
	}


	public Cliente atualizarClienteNoBancoDeDados(Cliente cliente) throws Exception, ClienteJaCadastradoException, ClienteCpfInvalidoException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {

			Statement statement = conn.createStatement();

			String query = "";

			query += "update cliente set ";
			query += "status='"+cliente.getStatus()+"',nome='"+cliente.getNomeCliente()+"',rg='"+cliente.getRg()+"',cpf='"+cliente.getCpf()+"',dt_nascimento='"+cliente.getDataNascimento()+"',dt_cadastro='"+cliente.getDataCadasatro()+"',email='"+cliente.getEmail()+"',telefone='"+cliente.getTelefone()+"',celular='"+cliente.getCelular()+"',dt_vencimento='"+cliente.getVencimentoPlano()+"',rua='"+cliente.getRua()+"',numero='"+cliente.getNumero()+"',bairro='"+cliente.getBairro()+"',cidade='"+cliente.getCidade()+"',uf='"+cliente.getUf()+"',cep='"+cliente.getCep()+"',login='"+cliente.getLogin()+"',senha='"+cliente.getSenha()+"',tipoplano='"+cliente.getTipoPlano()+"',operadora='"+cliente.getOperadora()+"'";
			query += " where  ID_CLIENTE = " + "" + cliente.getId() + ";";
			statement.execute(query);
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		return cliente;

	}


	public void removerClienteNoBancoDeDados(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException, Exception {

		Connection conn = SGP_MySQL.getInstance().conectarBD();

		try {

			// Criando a String SQL
			String sql = "delete from cliente where CPF = ?";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, cpf);

			// Executando o select
			preStatement.executeUpdate();

			System.out.println("Cliente Removido do Banco de Dados com Sucesso!");

		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

	}

	public Cliente procurarClienteNoBancoDeDados(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException, Exception {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Cliente cliente = new Cliente();
		
		String sql = "";
		sql += "select * from cliente ";
		sql += "where cpf = " + "'" + cpf + "';";

		try {

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {

				int codigo = rs.getInt(1);
				String status = rs.getString(2);
				String nome = rs.getString(3);
				String rg  = rs.getString(4);
				String cpfCliente = rs.getString(5);
				java.sql.Date dataNasc = rs.getDate(6);
				java.sql.Date dataCadastro = rs.getDate(7);
				String email = rs.getString(8);	
				String telefone = rs.getString(9);
				String celular = rs.getString(10);
				int vencimento = rs.getInt(11);
				String rua = rs.getString(12);
				String numero = rs.getString(13);
				String bairro = rs.getString(14);
				String cidade = rs.getString(15);
				String uf = rs.getString(16);
				String cep = rs.getString(17);
				String login = rs.getString(18);
				String senha = rs.getString(19);
				String plano = rs.getString(20);
				String operadora = rs.getString(21);

				cliente = new Cliente(status, nome, login, senha, rg, cpfCliente, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, dataNasc, dataCadastro, plano, vencimento);
				cliente.setId(codigo);
				
				System.out.println("\nCliente localizado no Banco de Dados:");
				System.out.println(cliente.toStringCompleta());
				//System.out.println(listaLigada);
				
			}
				
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return cliente;
	}


	public HashSet<Cliente> listarClientesNoBancoDeDados() throws Exception {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Cliente cliente = new Cliente();
		HashSet<Cliente> listCliente = new HashSet<Cliente>();

		try {

			// Criando a String SQL
			String sql = "select * from cliente order by ID_CLIENTE asc";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {

				int codigo = resultSet.getInt(1);
				String status = resultSet.getString(2);
				String nome = resultSet.getString(3);
				String rg  = resultSet.getString(4);
				String cpfCliente = resultSet.getString(5);
				java.sql.Date dataNasc = resultSet.getDate(6);
				java.sql.Date dataCadastro = resultSet.getDate(7);
				String email = resultSet.getString(8);	
				String telefone = resultSet.getString(9);
				String celular = resultSet.getString(10);
				int vencimento = resultSet.getInt(11);
				String rua = resultSet.getString(12);
				String numero = resultSet.getString(13);
				String bairro = resultSet.getString(14);
				String cidade = resultSet.getString(15);
				String uf = resultSet.getString(16);
				String cep = resultSet.getString(17);
				String login = resultSet.getString(18);
				String senha = resultSet.getString(19);
				String plano = resultSet.getString(20);
				String operadora = resultSet.getString(21);

				cliente = new Cliente(status, nome, login, senha, rg, cpfCliente, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, dataNasc, dataCadastro, plano, vencimento);
				cliente.setId(codigo);

				listCliente.add(cliente);
				System.out.println("\nCliente no Banco de Dados:");
				System.out.println(cliente.toStringCompleta());
			}
			return listCliente;

		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

		System.out.println("\nN�o Existe Cliente no Banco de Dados!");
		return null;
	}

	public String nome = "";
	public boolean result;

	public boolean procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException, Exception {
		String sql = "";
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Cliente cliente = new Cliente();
		sql += "select * from cliente ";
		sql += "where cpf = " + "'" + cpf + "';";

		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if(rs.next()) {

				int codigo = rs.getInt(1);
				String status = rs.getString(2);
				String nome = rs.getString(3);
				String rg  = rs.getString(4);
				String cpfCliente = rs.getString(5);
				java.sql.Date dataNasc = rs.getDate(6);
				java.sql.Date dataCadastro = rs.getDate(7);
				String email = rs.getString(8);	
				String telefone = rs.getString(9);
				String celular = rs.getString(10);
				int vencimento = rs.getInt(11);
				String rua = rs.getString(12);
				String numero = rs.getString(13);
				String bairro = rs.getString(14);
				String cidade = rs.getString(15);
				String uf = rs.getString(16);
				String cep = rs.getString(17);
				String login = rs.getString(18);
				String senha = rs.getString(19);
				String plano = rs.getString(20);
				String operadora = rs.getString(21);

				cliente = new Cliente(status, nome, login, senha, rg, cpfCliente, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, dataNasc, dataCadastro, plano, vencimento);
				cliente.setId(codigo);

				System.out.println("\nCliente localizado no Banco de Dados:");
				System.out.println(cliente.toStringCompleta());

				result = true;
				nome = rs.getString("nome");
				System.out.println(nome);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}	


}
