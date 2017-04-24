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
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into cliente(ID_CLIENTE, nome, rg, cpf, dt_nascimento, dt_cadastro, email, telefone, celular, dt_vencimento, rua, numero, bairro, cidade, uf, cep, login, senha, tipoplano, operadora)";
			query += "values('"+cliente.getId()+"','"+cliente.getNomeCliente()+"', '"+cliente.getRg()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNascimento()+"', '"+cliente.getDataCadasatro()+"', '"+cliente.getEmail()+"', '"+cliente.getTelefone()+"', '"+cliente.getCelular()+"', '"+cliente.getVencimentoPlano()+"', '"+cliente.getRua()+"', '"+cliente.getNumero()+"', '"+cliente.getBairro()+"', '"+cliente.getCidade()+"', '"+cliente.getUf()+"', '"+cliente.getCep()+"', '"+cliente.getLogin()+"', '"+cliente.getSenha()+"', '"+cliente.getTipoPlano()+"', '"+cliente.getOperadora()+"')";
			statement.execute(query);
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Cadastrado no Banco de Dados! \n");
			
			return cliente;
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		return cliente;
	}


	public void atualizarClienteNoBancoDeDados(Cliente cliente) throws Exception, ClienteJaCadastradoException, ClienteCpfInvalidoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update cliente set  nome =?,rg=? ,cpf=?,dt_nascimento=?,dt_cadastro=?,email=?,telefone=?,celular=?,dt_vencimento=?,rua=?,numero=?,bairro=?,cidade=?,uf=?,cep=?,login=?,senha=?,tipoplano=?,operadora=? where cpf = ?";
		
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			
			preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, cliente.getNomeCliente());
			preStatement.setString(2, cliente.getRg());
			preStatement.setString(3, cliente.getCpf());
			preStatement.setDate(4, (Date) cliente.getDataNascimento());
			preStatement.setDate(5, (Date) cliente.getDataCadasatro());
			preStatement.setString(6, cliente.getEmail());
			preStatement.setString(7, cliente.getTelefone());
			preStatement.setString(8,cliente.getCelular());
			preStatement.setInt(9, cliente.getVencimentoPlano());
			preStatement.setString(10,cliente.getRua());
			preStatement.setString(11,cliente.getNumero());
			preStatement.setString(12,cliente.getBairro());
			preStatement.setString(13, cliente.getCidade());
			preStatement.setString(14,cliente.getUf());
			preStatement.setString(15,cliente.getCep());
			preStatement.setString(16,cliente.getLogin());
			preStatement.setString(17,cliente.getSenha());
			preStatement.setString(18,cliente.getTipoPlano());
			preStatement.setString(19,cliente.getOperadora());
			
			preStatement.setString(20, cliente.getCpf());

			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
	}


	public void removerClienteNoBancoDeDados(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
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


	public Cliente procurarClienteNoBancoDeDados(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		Cliente cliente = new Cliente();
		
		try {
			

			String sql = "select * from cliente where cpf=?";

			PreparedStatement preStatement = conn.prepareStatement(sql);
			preStatement.setString(1, cpf);
			
			ResultSet resultSet = preStatement.executeQuery();
			
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				String rg  = resultSet.getString(3);
				String cpfCliente = resultSet.getString(4);
				java.sql.Date dataNasc = resultSet.getDate(5);
				java.sql.Date dataCadastro = resultSet.getDate(6);
				String email = resultSet.getString(7);	
				String telefone = resultSet.getString(8);
				String celular = resultSet.getString(9);
				int vencimento = resultSet.getInt(10);
				String rua = resultSet.getString(11);
				String numero = resultSet.getString(12);
				String bairro = resultSet.getString(13);
				String cidade = resultSet.getString(14);
				String uf = resultSet.getString(15);
				String cep = resultSet.getString(16);
				String login = resultSet.getString(17);
				String senha = resultSet.getString(18);
				String plano = resultSet.getString(19);
				String operadora = resultSet.getString(20);
				
				cliente = new Cliente(nome, login, senha, rg, cpfCliente, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, dataNasc, dataCadastro, plano, vencimento);
				cliente.setId(codigo);
				
				System.out.println("Cliente localizado no Banco de Dados!");
				
			
			}
			
			} catch (Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}
		
		return cliente;
	}


	public HashSet<Cliente> listarClientesNoBancoDeDados() {
		
		Connection conn = SGP_MySQL.conectarBD();
		Cliente cliente = new Cliente();
		HashSet<Cliente> arrayListCliente = new HashSet<Cliente>();
		
		try {
			
			// Criando a String SQL
			String sql = "select * from cliente";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String nome = resultSet.getString(2);
				String rg  = resultSet.getString(3);
				String cpfCliente = resultSet.getString(4);
				java.sql.Date dataNasc = resultSet.getDate(5);
				java.sql.Date dataCadastro = resultSet.getDate(6);
				String email = resultSet.getString(7);	
				String telefone = resultSet.getString(8);
				String celular = resultSet.getString(9);
				int vencimento = resultSet.getInt(10);
				String rua = resultSet.getString(11);
				String numero = resultSet.getString(12);
				String bairro = resultSet.getString(13);
				String cidade = resultSet.getString(14);
				String uf = resultSet.getString(15);
				String cep = resultSet.getString(16);
				String login = resultSet.getString(17);
				String senha = resultSet.getString(18);
				String plano = resultSet.getString(19);
				String operadora = resultSet.getString(20);
				
				cliente = new Cliente(nome, login, senha, rg, cpfCliente, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, dataNasc, dataCadastro, plano, vencimento);
				cliente.setId(codigo);
				
				arrayListCliente.add(cliente);
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		System.out.println("Clientes listados no Banco de Dados!");
		return arrayListCliente;
	}
	
	
	
	
}
