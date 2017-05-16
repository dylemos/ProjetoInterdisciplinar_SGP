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
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" já está Cadastrado no Banco de Dados! \n");
		}
		return cliente;
	}


	public void atualizarClienteNoBancoDeDados(Cliente cliente) throws Exception, ClienteJaCadastradoException, ClienteCpfInvalidoException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			// Criando a String SQL
			String sql = "update cliente set  status =?,nome =?,rg=? ,cpf=?,dt_nascimento=?,dt_cadastro=?,email=?,telefone=?,celular=?,dt_vencimento=?,rua=?,numero=?,bairro=?,cidade=?,uf=?,cep=?,login=?,senha=?,tipoplano=?,operadora=? where cpf = ?";
		
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			
			preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, cliente.getStatus());
			preStatement.setString(2, cliente.getNomeCliente());
			preStatement.setString(3, cliente.getRg());
			preStatement.setString(4, cliente.getCpf());
			preStatement.setDate(5, (Date) cliente.getDataNascimento());
			preStatement.setDate(6, (Date) cliente.getDataCadasatro());
			preStatement.setString(7, cliente.getEmail());
			preStatement.setString(8, cliente.getTelefone());
			preStatement.setString(9,cliente.getCelular());
			preStatement.setInt(10, cliente.getVencimentoPlano());
			preStatement.setString(11,cliente.getRua());
			preStatement.setString(12,cliente.getNumero());
			preStatement.setString(13,cliente.getBairro());
			preStatement.setString(14, cliente.getCidade());
			preStatement.setString(15,cliente.getUf());
			preStatement.setString(16,cliente.getCep());
			preStatement.setString(17,cliente.getLogin());
			preStatement.setString(18,cliente.getSenha());
			preStatement.setString(19,cliente.getTipoPlano());
			preStatement.setString(20,cliente.getOperadora());
			
			preStatement.setString(21, cliente.getCpf());

			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Atualizado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
		
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
		
		try {
			
			if(listarClientesNoBancoDeDados().contains(cpf)){
				
				String sql = "select * from cliente where cpf=?";

				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, cpf);
				
				ResultSet resultSet = preStatement.executeQuery();
				
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
					
					System.out.println("\nCliente localizado no Banco de Dados:");
					System.out.println(cliente.toStringCompleta());
				
				}
				
				
			}else{
				System.out.println("Cliente Não Cadastrado no Banco de Dados!");
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
			String sql = "select * from cliente";

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
		
		System.out.println("\nNão Existe Cliente no Banco de Dados!");
		return null;
	}
	
	
	
	
}
