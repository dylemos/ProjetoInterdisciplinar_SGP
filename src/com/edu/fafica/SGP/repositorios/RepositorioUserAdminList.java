package com.edu.fafica.SGP.repositorios;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;
import com.edu.fafica.SGP.interfaces.IRepositorioUserAdmin;
import com.edu.fafica.SGP.pessoas.UserAdmin;

public class RepositorioUserAdminList implements IRepositorioUserAdmin {

	private HashSet<UserAdmin> listaUserAdminRepositorio;

	public RepositorioUserAdminList() {
		this.listaUserAdminRepositorio = new HashSet<UserAdmin>();
	}

	@Override
	public void cadastrarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminJaCadastradoException {

		try {

			this.listaUserAdminRepositorio.add(userAdmin);
			System.out.println(userAdmin.toString());
			System.out.println("***Cadastrado Com Sucesso***");
			System.out.println();
		} catch (Exception e) {
			System.out.println(userAdmin.getNomeUserAdmin()+e.getMessage());
			System.out.println();
		}

	}

	@Override
	public void atualizarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException {
		try {
			this.listaUserAdminRepositorio.add(userAdmin);
			System.out.println(userAdmin.toString());
			System.out.println("Atualizado com Sucesso!");
			System.out.println();
		} catch (Exception e) {
			System.out.println(userAdmin.getNomeUserAdmin()+e.getMessage());
			System.out.println();
		}
	}

	@Override
	public void removerUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {

		try {
			for (UserAdmin userAdmins : listaUserAdminRepositorio) {
				if (cpf == userAdmins.getCpf()) {
					this.listaUserAdminRepositorio.remove(userAdmins);
					System.out.println("UserAdmin ID "+userAdmins.getId()+" Removido com Sucesso!");
					System.out.println();
				} else {
					System.out.println("O Cliente Não Pode Ser Removido!");
					System.out.println();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

	}

	@Override
	public UserAdmin procurarUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {

		try {
			
			for (UserAdmin userAdmin : listaUserAdminRepositorio) {
				if(userAdmin.getCpf().equals(cpf)){
					System.out.println("UserAdmin Encontrado:");
					System.out.println(userAdmin.toString());
					System.out.println();
					return userAdmin;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}



	@Override
	public HashSet<UserAdmin> listarUserAdmins() {

		for (UserAdmin userAdmin : listaUserAdminRepositorio) {
			System.out.println("[ ID "+userAdmin.getId()+" - "+userAdmin.getNomeUserAdmin()+" ]");
		}
		System.out.println();
		return listaUserAdminRepositorio;
	}

}
