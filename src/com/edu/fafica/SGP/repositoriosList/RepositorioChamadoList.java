package com.edu.fafica.SGP.repositoriosList;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioChamado;

public class RepositorioChamadoList implements IRepositorioChamado{

	private HashSet<Chamado> listaChamadoRepositorio;
	
	public RepositorioChamadoList() {
		this.listaChamadoRepositorio = new HashSet<Chamado>();
	}

	@Override
	public void cadastrarChamado(Chamado chamado, Cliente cliente) throws SQLException, ChamadoJaCadastradoException {
		
		try {
			this.listaChamadoRepositorio.add(chamado);
			System.out.println(chamado.toString());
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(chamado.getTipoChamado()+e.getMessage());
			System.out.println();
		}
		
	}

	@Override
	public void atualizarChamado(Chamado chamado, Cliente cliente) throws SQLException, ChamadoNaoEncontradoException {
		try {
			this.listaChamadoRepositorio.add(chamado);
			System.out.println(chamado.toString());
			System.out.println("Atualizado com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(chamado.getTipoChamado()+e.getMessage());
			System.out.println();
		}
	}

	@Override
	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		
		try {

			for (Chamado chamado : listaChamadoRepositorio) {
				
				for(int i = 0; i < this.listaChamadoRepositorio.size(); ++i){
					
					if(id == chamado.getId()){
						this.listaChamadoRepositorio.remove(chamado);
						System.out.println("Chamado ID "+chamado.getId()+" Removido com Sucesso!");
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
	public Chamado procurarChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {

		try {
			
			for (Chamado chamado : listaChamadoRepositorio) {
				if(chamado.getId() == id){
					System.out.println("Chamado Encontrado:");
					System.out.println(chamado.toString());
					System.out.println();
					return chamado;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}

	
	@Override
	public HashSet<Chamado> listarChamados() {

		for (Chamado chamado : listaChamadoRepositorio) {
			System.out.println("[ ID "+chamado.getId()+" - Descrição: "+chamado.getDescProblema()+" ]");
		}
		System.out.println();
		return listaChamadoRepositorio;
	}
	
	
	
}
