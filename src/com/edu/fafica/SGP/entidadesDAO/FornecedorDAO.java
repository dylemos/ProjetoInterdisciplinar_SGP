package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into fornecedor(ID_FORNECEDOR, NOMEFANTASIA, RAZAOSOCIAL, CNPJ, RUA, NUMERO, BAIRRO, CIDADE, UF, CEP, EMAIL, TELEFONE, CELULAR, OPERADORA)";
			query += "values('"+fornecedor.getId()+"','"+fornecedor.getNomeFantasia()+"', '"+fornecedor.getRazaoSocial()+"', '"+fornecedor.getCnpj()+"', '"+fornecedor.getRua()+"', '"+fornecedor.getNumero()+"', '"+fornecedor.getBairro()+"', '"+fornecedor.getCidade()+"', '"+fornecedor.getUf()+"', '"+fornecedor.getCep()+"', '"+fornecedor.getEmail()+"', '"+fornecedor.getTelefone()+"', '"+fornecedor.getCelular()+"', '"+fornecedor.getOperadora()+"')";
			statement.execute(query);
		
			System.out.println("\n Fornecedor "+fornecedor.getNomeFantasia()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
	
	}

	public void atualizarFornecedorNoBancoDeDados(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			// Criando a String SQL  NOMEFANTASIA, RAZAOSOCIAL, CNPJ, RUA, NUMERO, BAIRRO, CIDADE, UF, CEP, EMAIL, TELEFONE, CELULAR, OPERADORA
			String sql = "update fornecedor set  NOMEFANTASIA =?,RAZAOSOCIAL=? ,CNPJ=?,RUA=?,NUMERO=?,BAIRRO=?,CIDADE=?,UF=?,CEP=?,EMAIL=?,TELEFONE=?,CELULAR=?,OPERADORA=? where CNPJ = ?";
			// Criar o PreparedStatement, objeto para executar a query
			PreparedStatement preStatement;
			
			
			preStatement = conn.prepareStatement(sql);

			preStatement.setString(1, fornecedor.getNomeFantasia());
			preStatement.setString(2, fornecedor.getRazaoSocial());
			preStatement.setString(3, fornecedor.getCnpj());
			preStatement.setString(4, fornecedor.getRua());
			preStatement.setString(5, fornecedor.getNumero());
			preStatement.setString(6, fornecedor.getBairro());
			preStatement.setString(7, fornecedor.getCidade());
			preStatement.setString(8,fornecedor.getUf());
			preStatement.setString(9, fornecedor.getCep());
			preStatement.setString(10,fornecedor.getEmail());
			preStatement.setString(11,fornecedor.getTelefone());
			preStatement.setString(12,fornecedor.getCelular());
			preStatement.setString(13, fornecedor.getOperadora());
			preStatement.setString(14,fornecedor.getCnpj());

			// Executando atualização
			preStatement.executeUpdate();
			
			System.out.println("Fornecedor "+fornecedor.getNomeFantasia()+" Atualizado Com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage()+"\n");
		}

	}

	public void removerFornecedorNoBancoDeDados(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub

	}

	public Fornecedor procurarFornecedorNoBancoDeDados(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Fornecedor> listarFornecedoresNoBancoDeDados() {
		// TODO Auto-generated method stub
		return null;
	}

}
