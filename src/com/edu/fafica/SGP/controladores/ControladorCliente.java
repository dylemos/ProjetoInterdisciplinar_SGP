package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioCliente;
import com.edu.fafica.SGP.repositoriosJDBC.RepositorioClienteJDBC;
import com.edu.fafica.SGP.util.ValidarCPF;

public class ControladorCliente {
	
	private IRepositorioCliente repositorioCliente;
	private HashSet<Cliente> listaControladorCliente;
//	private int index;
	
	
	public ControladorCliente() throws ClassNotFoundException {
//		Define aqui qual repositório usar
//		this.repositorioCliente = new RepositorioClienteList();
		this.repositorioCliente = new RepositorioClienteJDBC();
		
		//Inicializa Lista
		listaControladorCliente = new HashSet<Cliente>();
//		this.index = 1;
	}

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClienteCpfInvalidoException {
		
		try {
			if(!listaControladorCliente.contains(cliente)){
				if(ValidarCPF.validaCPF(cliente.getCpf())){
//					cliente.setId(index);
					this.listaControladorCliente.add(cliente);
					this.repositorioCliente.cadastrarCliente(cliente);
//					this.index++;                                                válido pra List
				}else{
					throw new ClienteCpfInvalidoException();
				}
			}
			else{
				throw new ClienteJaCadastradoException();
			}
			
		} catch (Exception e) {
			System.out.println(cliente.getNomeCliente()+e.getMessage());
		}

	}

	public void atualizarCliente(Cliente cliente) throws ClienteCpfInvalidoException, Exception {

/*List	
		if(this.listaControladorCliente.contains(cliente)){
			
			int i = cliente.getId();
			
			try {
				for (Cliente clientes : listaControladorCliente) {
					if(i == clientes.getId()){
						this.listaControladorCliente.remove(clientes);
						cliente.setId(i);
						this.listaControladorCliente.add(cliente);
						this.repositorioCliente.atualizarCliente(cliente);
					}
				}
				
			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}
		}else{
			System.err.println("\n\t\t O Cliente Ainda Não Foi Cadastrado!");
		}
*/
		
		//JDBC
		this.repositorioCliente.atualizarCliente(cliente);
		
		
	}
	
	
	

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {

/*List			
		try {
			
			if(ValidarCPF.validaCPF(cpf)){
				
					for (Cliente cliente : listaControladorCliente) {
						
						if(cliente.getCpf().equals(cpf)){
							this.listaControladorCliente.remove(cliente);
							this.repositorioCliente.removerCliente(cpf);
						}
					}
				
			}else{
				System.out.println("Cliente Não Encontrado!");
			}
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println();
		}
		
*/
		
		//JDBC
		this.repositorioCliente.removerCliente(cpf);
	}

	
	
	
	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {

/*List			
		try {
			
			if(ValidarCPF.validaCPF(cpf)){
				
				for (Cliente cliente : listaControladorCliente) {
					if(cliente.getCpf().equals(cpf)){
						this.repositorioCliente.procurarCliente(cpf);
						return cliente;
					}
				}
				
			}else{
				System.out.println("CPF INVÁLIDO!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
*/
		//JDBC
		this.repositorioCliente.procurarCliente(cpf);
		
		return null;
	}
	
	
	public HashSet<Cliente> listarClientes(){
		this.repositorioCliente.listarClientes();
		return null;
	}

}
