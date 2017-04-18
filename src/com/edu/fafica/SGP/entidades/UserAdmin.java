package com.edu.fafica.SGP.entidades;

public class UserAdmin {
	
	private int id;
	private String nomeUserAdmin;
	private String cpf;
	private String login;
	private String senha;
	
	public UserAdmin() {
		// TODO Auto-generated constructor stub
	}
	
	public UserAdmin(String nomeUserAdmin, String cpf, String login, String senha) {
		setNomeUserAdmin(nomeUserAdmin);
		setCpf(cpf);
		setLogin(login);
		setSenha(senha);
	}
	

	public String toString() {
		
		String userAdminDetalhe = "{ UserAdmin | ID: "+getId()+" | Nome do Administrador: "+getNomeUserAdmin()+
				"|\n CPF: "+getCpf()+
				" | Login: "+getLogin()+" | Senha: "+getSenha()+" | }";
		
		return userAdminDetalhe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUserAdmin() {
		return nomeUserAdmin;
	}

	public void setNomeUserAdmin(String nomeUserAdmin) {
		this.nomeUserAdmin = nomeUserAdmin;
	}

	
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
