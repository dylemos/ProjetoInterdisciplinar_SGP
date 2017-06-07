package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.edu.fafica.SGP.interfacesList.IRepositorioConta;
import com.edu.fafica.SGP.repositoriosJDBC.RepositorioContaJDBC;

public class ControladorConta {
	
	private IRepositorioConta repositorioConta;
	private HashSet<Conta> listaConta;
//	private int index;
	
	public ControladorConta() throws Exception {
		//Define qual repositório usar
//		this.repositorioConta = new RepositorioContaList();
		this.repositorioConta = new RepositorioContaJDBC();
		
		//Inicializa a lista
		this.listaConta = new HashSet<Conta>();
//		this.index = 1;
	}

	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException {
		
		try {
			
			if(!listaConta.contains(conta)){
				
//				conta.setId(index); 						válido pra List
				this.listaConta.add(conta);
				this.repositorioConta.cadastrarConta(conta);
//				index++;
				
			}else{
				
				throw new ContaJaCadastradaException();
				
			}
			
		} catch (Exception e) {
			System.out.println(" ID "+conta.getId()+" "+conta.getTipoConta()+e.getMessage());
			System.out.println();
		}
		
	}

	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException {

/*List
		if(this.listaConta.contains(conta)){
			
			int i = conta.getIdCliente();
			
			try {
				
				for (Conta contas : listaConta) {
					if(i == contas.getIdCliente()){
						
						this.listaConta.remove(contas);
						conta.setId(++i);
						this.listaConta.add(conta);
						this.repositorioConta.atualizarConta(conta);
						
					}
				}
				
			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}
			
		}else{
			System.err.println("\n\t\t A Conta Ainda Não Foi Cadastrada!");
		}
		
		*/
		
		//JDBC
		this.repositorioConta.atualizarConta(conta);
	}

	
	
	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		
		try {
			
			for (Conta conta : listaConta) {
				
				if(id == conta.getId()){
					this.listaConta.remove(conta);
					this.repositorioConta.removerConta(id);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println();
		}
		
	}

	
	
	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {

		try {
			
			for (Conta conta : listaConta) {
				if(conta.getId() == id){
					this.repositorioConta.procurarConta(id);
					return conta;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}
	
	
	public HashSet<Conta> listarContas() throws ClassNotFoundException{
		HashSet<Conta> lista;
		lista = repositorioConta.listarContas();
		return lista;
	}
	

}
