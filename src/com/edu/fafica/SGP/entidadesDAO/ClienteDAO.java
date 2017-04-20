package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Statement;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;

public class ClienteDAO {

	public ClienteDAO() throws ClassNotFoundException {
		SGP_MySQL.getInstance();
	}
	
	
	public void cadastrarClienteNoBancoDeDados(Cliente cliente) throws ClassNotFoundException, ClienteJaCadastradoException, ClienteCpfInvalidoException, Exception{
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into cliente(ID_CLIENTE, nome, rg, cpf, dt_nascimento, dt_cadastro, email, telefone, celular, dt_vencimento, rua, numero, bairro, cidade, uf, cep, login, senha, tipoplano, operadora)";
			query += "values('"+cliente.getId()+"','"+cliente.getNomeCliente()+"', '"+cliente.getRg()+"', '"+cliente.getCpf()+"', '"+cliente.getDataNascimento()+"', '"+cliente.getDataCadasatro()+"', '"+cliente.getEmail()+"', '"+cliente.getTelefone()+"', '"+cliente.getCelular()+"', '"+cliente.getVencimentoPlano()+"', '"+cliente.getRua()+"', '"+cliente.getNumero()+"', '"+cliente.getBairro()+"', '"+cliente.getCidade()+"', '"+cliente.getUf()+"', '"+cliente.getCep()+"', '"+cliente.getLogin()+"', '"+cliente.getSenha()+"', '"+cliente.getTipoPlano()+"', '"+cliente.getOperadora()+"')";
//						query += "values(null,'"+cliente.getNomeCliente()+"', '"+cliente.getLogin()+"', '"+cliente.getSenha()+"', '"+cliente.getRg()+"', '"+cliente.getCpf()+"', '"+cliente.getTelefone()+"', '"+cliente.getCelular()+"', '"+cliente.getOperadora()+"', '"+cliente.getEmail()+"', '"+cliente.getRua()+"', '"+cliente.getNumero()+"', '"+cliente.getBairro()+"', '"+cliente.getCidade()+"', '"+cliente.getUf()+"', '"+cliente.getCep()+"', '"+cliente.getDataNascimento()+"', '"+cliente.getDataCadasatro()+"', '"+cliente.getTipoPlano()+"', '"+cliente.getVencimentoPlano()+"')";
			statement.execute(query);
			System.out.println("\n Cliente "+cliente.getNomeCliente()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
	}
	
}
