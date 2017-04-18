package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioPlano;
import com.edu.fafica.SGP.repositoriosList.RepositorioPlanoList;

public class ControladorPlano {

	private IRepositorioPlano repositorioPlano;
	private HashSet<Plano> listaPlanos;
	private int index;
	
	public ControladorPlano() {
		//Define o reposit�rio a utilizar
		this.repositorioPlano = new RepositorioPlanoList();
		
		//Implementa a Lista
		this.listaPlanos = new HashSet<Plano>();
		this.index = 1;
	}
	
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException {
		
		try {
			
			if(!listaPlanos.contains(plano)){
				
				plano.setId(index);
				listaPlanos.add(plano);
				this.repositorioPlano.cadastrarPlano(plano);
				index++;
				
			}else{
				throw new PlanoJaCadastradoException();
			}
			
		} catch (Exception e) {
			System.out.println(plano.getNomePlano()+e.getMessage());
			System.out.println();
		}
		
	}

	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException {
		
		if(this.listaPlanos.contains(plano)){
			
			int i = plano.getId();
			
			try {
				for (Plano planos : listaPlanos) {
					if(i == plano.getId()){
						this.listaPlanos.remove(planos);
						plano.setId(i);
						this.listaPlanos.add(plano);
						this.repositorioPlano.atualizarPlano(plano);
					}
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}
			
		}else{
			System.err.println("\n\t\t O Plano Ainda N�o Foi Cadastrado!");
		}
		
	}

	public void removerPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		
		try {
			
			for (Plano plano : listaPlanos) {
				if(plano.getId() == id){
					this.listaPlanos.remove(plano);
					this.repositorioPlano.removerPlano(id);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		
		try {
			
			for (Plano plano : listaPlanos) {
				if(plano.getId() == id){
					this.repositorioPlano.procurarPlano(id);
					return plano;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		return null;
	}

	public HashSet<Plano> listarPlanos() {
		return this.repositorioPlano.listarPlanos();
	}
	
	

}
