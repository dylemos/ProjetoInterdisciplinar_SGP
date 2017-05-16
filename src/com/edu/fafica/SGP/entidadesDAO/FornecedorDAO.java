package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;

public class FornecedorDAO  {
	
	public FornecedorDAO() throws Exception {
		SGP_MySQL.getInstance();
	}

	public void cadastrarFornecedorNoBancoDeDados(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException, Exception {
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into fornecedor(ID_FORNECEDOR, NOMEFANTASIA, RAZAOSOCIAL, CNPJ, IE, RUA, NUMERO, BAIRRO, CIDADE, UF, CEP, EMAIL, TELEFONE, CELULAR, OPERADORA)";
			query += "values('"+fornecedor.getId()+"','"+fornecedor.getNomeFantasia()+"', '"+fornecedor.getRazaoSocial()+"', '"+fornecedor.getCnpj()+"', '"+fornecedor.getIe()+"', '"+fornecedor.getRua()+"', '"+fornecedor.getNumero()+"', '"+fornecedor.getBairro()+"', '"+fornecedor.getCidade()+"', '"+fornecedor.getUf()+"', '"+fornecedor.getCep()+"', '"+fornecedor.getEmail()+"', '"+fornecedor.getTelefone()+"', '"+fornecedor.getCelular()+"', '"+fornecedor.getOperadora()+"')";
			statement.execute(query);
		
			System.out.println("\n Fornecedor "+fornecedor.getNomeFantasia()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
			System.out.println("\n Fornecedor "+fornecedor.getNomeFantasia()+" já está Cadastrado no Banco de Dados! \n");
		}
	
	}

	public void atualizarFornecedorNoBancoDeDados(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			// Criando a String SQL  NOMEFANTASIA, RAZAOSOCIAL, CNPJ, RUA, NUMERO, BAIRRO, CIDADE, UF, CEP, EMAIL, TELEFONE, CELULAR, OPERADORA
			String sql = "update fornecedor set  NOMEFANTASIA =?,RAZAOSOCIAL=? ,CNPJ=?,IE=?,RUA=?,NUMERO=?,BAIRRO=?,CIDADE=?,UF=?,CEP=?,EMAIL=?,TELEFONE=?,CELULAR=?,OPERADORA=? where CNPJ = ?";
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			
			preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, fornecedor.getNomeFantasia());
			preStatement.setString(2, fornecedor.getRazaoSocial());
			preStatement.setString(3, fornecedor.getCnpj());
			preStatement.setString(4, fornecedor.getIe());
			preStatement.setString(5, fornecedor.getRua());
			preStatement.setString(6, fornecedor.getNumero());
			preStatement.setString(7, fornecedor.getBairro());
			preStatement.setString(8, fornecedor.getCidade());
			preStatement.setString(9,fornecedor.getUf());
			preStatement.setString(10, fornecedor.getCep());
			preStatement.setString(11,fornecedor.getEmail());
			preStatement.setString(12,fornecedor.getTelefone());
			preStatement.setString(13,fornecedor.getCelular());
			preStatement.setString(14, fornecedor.getOperadora());
			preStatement.setString(15,fornecedor.getCnpj());

			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("Fornecedor "+fornecedor.getNomeFantasia()+" Atualizado Com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage()+"\n");
		}

	}

	public void removerFornecedorNoBancoDeDados(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, ClassNotFoundException {
		
		Connection conn = SGP_MySQL.getInstance().conectarBD();
		
		try {
			
			if(listarFornecedoresNoBancoDeDados().contains(cnpj)){
				
				// Criando a String SQL
				String sql = "delete from fornecedor where CNPJ = ?";

				// Criar o PreparedStatement, objeto para executar a query
				PreparedStatement preStatement = conn.prepareStatement(sql);

				preStatement.setString(1, cnpj);

				// Executando o select
				preStatement.executeUpdate();
				
				System.out.println("Fornecedor Removido do Banco de Dados com Sucesso!");
				
			}else{
				System.out.println("Fornecedor Não existe para ser Removido do Banco de Dados!");
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

	}

	public Fornecedor procurarFornecedorNoBancoDeDados(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException, ClassNotFoundException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Fornecedor fornecedor = new Fornecedor();
		
		try {
			
			if(listarFornecedoresNoBancoDeDados().contains(cnpj)){
				
				String sql = "select * from fornecedor where cnpj=?";

				PreparedStatement preStatement = conn.prepareStatement(sql);
				preStatement.setString(1, cnpj);
				
				ResultSet resultSet = preStatement.executeQuery();
				
				while (resultSet.next()) {
					
					int codigo = resultSet.getInt(1);
					String nomeFantasia = resultSet.getString(2);
					String razaoSocial  = resultSet.getString(3);
					String cnpjFornecedor = resultSet.getString(4);
					String ie = resultSet.getString(5);
					String rua = resultSet.getString(6);
					String numero = resultSet.getString(7);
					String bairro = resultSet.getString(8);
					String cidade = resultSet.getString(9);
					String uf = resultSet.getString(10);
					String cep = resultSet.getString(11);
					String email = resultSet.getString(12);	
					String telefone = resultSet.getString(13);
					String celular = resultSet.getString(14);
					String operadora = resultSet.getString(15);
					
					fornecedor = new Fornecedor(razaoSocial, cnpjFornecedor, ie, rua, numero, bairro, cidade, uf, cep, email, telefone, celular, operadora, nomeFantasia);
					fornecedor.setId(codigo);
					
					System.out.println("\nFornecedor localizado no Banco de Dados:");
					System.out.println(fornecedor.toString());
				
				}
				
			}else{
				System.out.println("Fornecedor Não Cadastrado no Banco de Dados!");
			}
			
			} catch (Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}
		
		return fornecedor;
	}

	public HashSet<Fornecedor> listarFornecedoresNoBancoDeDados() throws ClassNotFoundException {

		Connection conn = SGP_MySQL.getInstance().conectarBD();
		Fornecedor fornecedor = new Fornecedor();
		HashSet<Fornecedor> listFornecedor = new HashSet<Fornecedor>();
		
		try {
			
			// Criando a String SQL
			String sql = "select * from fornecedor";

			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement = conn.prepareStatement(sql);

			ResultSet resultSet = preStatement.executeQuery();

			// Verifica se retornou dados na consulta
			while (resultSet.next()) {
				
				int codigo = resultSet.getInt(1);
				String nomeFantasia = resultSet.getString(2);
				String razaoSocial  = resultSet.getString(3);
				String cnpjFornecedor = resultSet.getString(4);
				String ie = resultSet.getString(5);
				String rua = resultSet.getString(6);
				String numero = resultSet.getString(7);
				String bairro = resultSet.getString(8);
				String cidade = resultSet.getString(9);
				String uf = resultSet.getString(10);
				String cep = resultSet.getString(11);
				String email = resultSet.getString(12);	
				String telefone = resultSet.getString(13);
				String celular = resultSet.getString(14);
				String operadora = resultSet.getString(15);
				
				fornecedor = new Fornecedor(razaoSocial, cnpjFornecedor, ie, rua, numero, bairro, cidade, uf, cep, email, telefone, celular, operadora, nomeFantasia);
				fornecedor.setId(codigo);
				
				listFornecedor.add(fornecedor);
				System.out.println("\nFornecedor no Banco de Dados:");
				System.out.println(fornecedor.toString());
			}
			return listFornecedor;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}

		System.out.println("\nNão Existe Fornecedor no Banco de Dados!");
		return null;
	}

}
