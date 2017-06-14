package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioChamado;
import com.edu.fafica.SGP.repositoriosJDBC.RepositorioChamadoJDBC;

public class ControladorChamado {
	
	private IRepositorioChamado repositorioChamado;
	private HashSet<Chamado> listaChamado;
//	private int index;
	
	public ControladorChamado() throws Exception {
		// Define qual repositorio usar
//		this.repositorioChamado = new RepositorioChamadoList();
		this.repositorioChamado = new RepositorioChamadoJDBC();
		
		//Implementa a lista
		this.listaChamado = new HashSet<Chamado>();
//		this.index = 1;
	}
	

	public void cadastrarChamado(Chamado chamado) throws SQLException, ChamadoJaCadastradoException {

		
		try {
			
			if(!listaChamado.contains(chamado)){
				
//				chamado.setId(index);
//				chamado.setIdCliente(cliente.getId());
				this.listaChamado.add(chamado);
				this.repositorioChamado.cadastrarChamado(chamado);
//				this.index++;											válido pra List
				
			}else{
				throw new ChamadoJaCadastradoException();
			}
			
		} catch (Exception e) {
			System.out.println("ID "+chamado.getId()+" "+chamado.getTipoChamado()+e.getMessage());
			System.out.println();
		}
		
	}

	public void atualizarChamado(Chamado chamado) throws Exception {

/*List
		if(this.listaChamado.contains(chamado)){
			
			try {
				
				for (Chamado chamados : listaChamado) {
					if(chamados.getIdCliente() == cliente.getId()){
						
//	só pra list			int i = chamados.getId();
						int ic = cliente.getId();
						
						this.listaChamado.remove(chamados);
						
//	só pra list					chamado.setId(i);         
						chamado.setIdCliente(ic);
						
						this.listaChamado.add(chamado);
						this.repositorioChamado.atualizarChamado(chamado, cliente);
					}
				}
			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}
			
		}else{
			System.err.println("\n\t\t O Chamado Ainda Não Foi Cadastrado!");
		}
	*/
		
		//JDBC
		this.repositorioChamado.atualizarChamado(chamado);
		
	}

	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		
/*List
		try {
			
			for (Chamado chamado : listaChamado) {
				
				if(id == chamado.getId()){
					this.listaChamado.remove(chamado);
					this.repositorioChamado.removerChamado(id);
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
		*/
		
		//JDBC
		this.repositorioChamado.removerChamado(id);
	}

	

	public Chamado procurarChamado(String cpfCliente) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		
/*List
		try {
			
			for (Chamado chamado : listaChamado) {
				if(chamado.getId() == id){
					this.repositorioChamado.procurarChamado(id);
					return chamado;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
*/
		
		//JDBC
		this.repositorioChamado.procurarChamado(cpfCliente);
		
		return null;
	}
	
	
	public HashSet<Chamado> listarChamados() throws ClassNotFoundException {
		HashSet<Chamado> listar;
		listar = repositorioChamado.listarChamados();
		return listar;
	}



}
