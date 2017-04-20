package com.edu.fafica.SGP.repositoriosList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioCliente;

public class RepositorioClienteList implements IRepositorioCliente {

	HashSet<Cliente> listaClienteRepositorio;

	public RepositorioClienteList() {
		this.listaClienteRepositorio = new HashSet<Cliente>();
	}

	@Override
	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException {

		try {

			this.listaClienteRepositorio.add(cliente);
			if(cliente.getNomeCliente() == null){
				System.out.println(cliente.toString());
			}
			if(cliente.getCep() == null){
				System.out.println(cliente.toStringBasica());
			}else{
				System.out.println(cliente.toStringCompleta());
			}
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(cliente.getNomeCliente()+e.getMessage());
		}

	}

	@Override
	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		try {
			this.listaClienteRepositorio.add(cliente);
			System.out.println(cliente.toStringBasica());
			System.out.println("Atualizado com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(cliente.getNomeCliente()+e.getMessage());
			System.out.println();
		}
	}

	
	
	
	
	@Override
	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		
		
		try {
				for (Cliente cliente : listaClienteRepositorio) {
					
					for(int i = 0; i < this.listaClienteRepositorio.size() ; ++i){
						
						if(cpf.equals(cliente.getCpf())){
							this.listaClienteRepositorio.remove(cliente);
							System.out.println("Cliente ID "+cliente.getId()+" Removido com Sucesso!");
							System.out.println();
						}
				}
					
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
	}

	
	
	
	
	@Override
	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
	
		try {
			
			for (Cliente cliente : listaClienteRepositorio) {
				if(cliente.getCpf().equals(cpf)){
					System.out.println("Cliente Encontrado:");
					System.out.println(cliente.toStringBasica());
					System.out.println();
					return cliente;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		return null;
	}
	
	
	public HashSet<Cliente> listarClientes(){
		
		for (Cliente cliente : listaClienteRepositorio) {
			System.out.println("[ ID "+cliente.getId()+" - Nome: "+cliente.getNomeCliente()+" ]");
		}
		System.out.println();
		return this.listaClienteRepositorio;
	}

}
