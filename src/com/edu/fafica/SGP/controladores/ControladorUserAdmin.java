package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;
import com.edu.fafica.SGP.interfacesList.IRepositorioUserAdmin;
import com.edu.fafica.SGP.repositoriosList.RepositorioUserAdminList;
import com.edu.fafica.SGP.util.ValidarCPF;

public class ControladorUserAdmin {
	
	private IRepositorioUserAdmin repositorioUserAdmin;
	private HashSet<UserAdmin> listaUserAdmin;
	private int index;
	
	public ControladorUserAdmin() {
		//Define aqui qual repositório usar
		this.repositorioUserAdmin = new RepositorioUserAdminList();
		
		//Inicializa a lista
		this.listaUserAdmin = new HashSet<UserAdmin>();
		this.index = 1;
	}
	

	public void cadastrarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminJaCadastradoException, UserAdminCpfInvalidoException{
		
		
		try {
			
			if(!this.listaUserAdmin.contains(userAdmin)){
				if(ValidarCPF.validaCPF(userAdmin.getCpf())){
					userAdmin.setId(index);
					this.listaUserAdmin.add(userAdmin);
					this.repositorioUserAdmin.cadastrarUserAdmin(userAdmin);
					index++;
				}else{
					throw new UserAdminCpfInvalidoException();
				}
			}else{
				throw new UserAdminJaCadastradoException();
			}
			
		} catch (Exception e) {
			System.out.println(userAdmin.getNomeUserAdmin()+e.getMessage());
			System.out.println();
		}
		
	}

	public void atualizarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException {
		
		if(this.listaUserAdmin.contains(userAdmin)){
			int i = userAdmin.getId();
			
			try {
				
				for (UserAdmin userAdmins : listaUserAdmin) {
					if(i == userAdmins.getId()){
						this.listaUserAdmin.remove(userAdmins);
						userAdmin.setId(i);
						this.listaUserAdmin.add(userAdmin);
						this.repositorioUserAdmin.atualizarUserAdmin(userAdmin);
					}
				}
				
			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}
			
		}else{
			System.err.println("\n\t\t O UserAdmin Ainda Não Foi Cadastrado!");
		}
		
	}

	public void removerUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {
		
		try {
			
			if(ValidarCPF.validaCPF(cpf)){
				
				for (UserAdmin userAdmin : listaUserAdmin) {
					
					if(userAdmin.getCpf().equals(cpf)){
						this.listaUserAdmin.remove(userAdmin);
						this.repositorioUserAdmin.removerUserAdmin(cpf);
					}
				}
				
			}else{
				System.out.println("UserAdmin Não Encontrado!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}
		
	}

	public UserAdmin procurarUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {

		try {
			
			if(ValidarCPF.validaCPF(cpf)){
				for (UserAdmin userAdmin : listaUserAdmin) {
					if(userAdmin.getCpf().equals(cpf)){
						this.repositorioUserAdmin.procurarUserAdmin(cpf);
						return userAdmin;
					}
				}
			}else{
				System.out.println("CPF Inválido!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}


	public HashSet<UserAdmin> listarUserAdmins() {
		return this.repositorioUserAdmin.listarUserAdmins();
	}

}
