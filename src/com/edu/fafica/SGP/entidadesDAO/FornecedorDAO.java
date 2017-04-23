package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
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

	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {


	}

	public void removerFornecedor(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub

	}

	public Fornecedor procurarFornecedor(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		// TODO Auto-generated method stub
		return null;
	}

	public HashSet<Fornecedor> listarFornecedores() {
		// TODO Auto-generated method stub
		return null;
	}

}
