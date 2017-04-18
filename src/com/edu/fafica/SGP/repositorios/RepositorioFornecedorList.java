package com.edu.fafica.SGP.repositorios;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;
import com.edu.fafica.SGP.interfaces.IRepositorioFornecedor;
import com.edu.fafica.SGP.pessoas.Fornecedor;

public class RepositorioFornecedorList implements IRepositorioFornecedor{
	
	private HashSet<Fornecedor> listaFornecedorRepositorio;
	
	public RepositorioFornecedorList() {
		this.listaFornecedorRepositorio = new HashSet<Fornecedor>();
	}

	@Override
	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException{

		try {
			
			listaFornecedorRepositorio.add(fornecedor);
			System.out.println(fornecedor.toString());
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(fornecedor.getNomeFantasia()+e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {
		try {
			this.listaFornecedorRepositorio.add(fornecedor);
			System.out.println(fornecedor.toString());
			System.out.println("Atualizado com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(fornecedor.getNomeFantasia()+e.getMessage());
			System.out.println();
		}
	}

	@Override
	public void removerFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {

		try {
			
			for (Fornecedor fornecedores : listaFornecedorRepositorio) {

				for(int i = 0; i < this.listaFornecedorRepositorio.size(); ++i){
					
					if(fornecedores.getCnpj().equals(cnpj)){
						this.listaFornecedorRepositorio.remove(fornecedores);
						System.out.println("Fornecedor ID "+fornecedores.getId()+" Removido com Sucesso!");
						System.out.println();
					}
					
				}
					
			}
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		
		try {
			
			for (Fornecedor fornecedor : listaFornecedorRepositorio) {
				if(fornecedor.getCnpj().equals(cnpj)){
					System.out.println("Fornecedor Encontrado:");
					System.out.println(fornecedor.toString());
					System.out.println();
					return fornecedor;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		return null;
	}

	@Override
	public HashSet<Fornecedor> listarFornecedores() {

		for (Fornecedor fornecedor : listaFornecedorRepositorio) {
			System.out.println("[ ID "+fornecedor.getId()+" - "+fornecedor.getNomeFantasia()+" ]");
		}
		System.out.println();
		return listaFornecedorRepositorio;
	}
	
	

}
