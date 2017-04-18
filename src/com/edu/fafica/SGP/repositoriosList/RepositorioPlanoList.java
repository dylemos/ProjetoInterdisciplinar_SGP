package com.edu.fafica.SGP.repositoriosList;

import java.sql.SQLException;
import java.util.HashSet;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioPlano;
import com.edu.fafica.SGP.plano.Plano;

public class RepositorioPlanoList implements IRepositorioPlano{

	private HashSet<Plano> listaPlanoRepositorio;
	
	
	public RepositorioPlanoList() {
		this.listaPlanoRepositorio = new HashSet<Plano>();
	}
	
	@Override
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException {

		try {
			listaPlanoRepositorio.add(plano);
			System.out.println(plano.toString()); 
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(plano.getNomePlano()+e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException {
		try {
			this.listaPlanoRepositorio.add(plano);
			System.out.println(plano.toString());
			System.out.println("Atualizado com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(plano.getNomePlano()+e.getMessage());
			System.out.println();
		}
	}

	@Override
	public void removerPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		
		try {
			for (Plano planos : listaPlanoRepositorio) {
				
				if(id == planos.getId()){
					this.listaPlanoRepositorio.remove(planos);
					System.out.println("Plano ID "+planos.getId()+" Removido com Sucesso!");
					System.out.println();
				}
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {

		try {
			
			for (Plano plano : listaPlanoRepositorio) {
				if(plano.getId() == id){
					System.out.println("Plano Encontrado:");
					System.out.println(plano.toString());
					System.out.println();
					return plano;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}

	@Override
	public HashSet<Plano> listarPlanos() {

		for (Plano plano : listaPlanoRepositorio) {
			System.out.println("ID "+plano.getId()+" - "+plano.getNomePlano());
		}
		System.out.println();
		return listaPlanoRepositorio;
	}
	
	

}
