package com.edu.fafica.SGP.repositoriosList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.edu.fafica.SGP.interfacesList.IRepositorioConta;

public class RepositorioContaList implements IRepositorioConta{
	
	private HashSet<Conta> listaContaRepositorio;
	
	public RepositorioContaList() {
		this.listaContaRepositorio = new HashSet<Conta>();
	}
	

	@Override
	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException {

		try {
			
			listaContaRepositorio.add(conta);
			System.out.println(conta.toString());
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(conta.getTipoConta()+e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException {
		try {
			this.listaContaRepositorio.add(conta);
			System.out.println(conta.toString());
			System.out.println("Atualizada com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(conta.getTipoConta()+e.getMessage());
			System.out.println();
		}
	}

	@Override
	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		
		try {
			
			for (Conta contas : listaContaRepositorio) {
			
				for(int i = 0; i < this.listaContaRepositorio.size(); ++i){
					
					if(id == contas.getId()){
						this.listaContaRepositorio.remove(contas);
						System.out.println("Conta ID "+contas.getId()+" Removida com Sucesso!");
						System.out.println();
					}
					
				}
				
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {

		try {
			
			for (Conta conta : listaContaRepositorio) {
				if(conta.getId() == id){
					System.out.println("Conta Encontrada:");
					System.out.println(conta.toString());
					System.out.println();
					return conta;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}


	@Override
	public HashSet<Conta> listarContas() {
		
		for (Conta conta : listaContaRepositorio) {
			System.out.println("[ ID "+conta.getId()+" - "+conta.getCpfCliente()+" R$"+conta.getValor()+" ]");
		}
		System.out.println();
		return listaContaRepositorio;
	}
	
	

}
