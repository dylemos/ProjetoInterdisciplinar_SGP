package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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


	public Cliente procurarClienteNoBancoDeDados(String cpf)
			throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}


	public HashSet<Cliente> listarClientesNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
