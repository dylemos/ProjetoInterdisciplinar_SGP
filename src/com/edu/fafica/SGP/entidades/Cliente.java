package com.edu.fafica.SGP.entidades;

import java.util.Calendar;

public class Cliente {
	
	private int id;
	private String nomeCliente;
	private String login;
	private String senha;
	private String rg;
	private String cpf;
	private String telefone;
	private String celular;
	private String operadora;
	private String email;
	private Calendar dataNascimento;
	private String enderecoCliente;
	private Calendar dataCadasatro;
	private String tipoPlano;
	private int vencimentoPlano;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cliente(String nomeCliente,String login,String senha,String rg,String cpf,String telefone,String celular,String operadora,String email,Calendar dataNascimento,String enderecoCliente,Calendar dataCadasatro,String tipoPlano,int vencimentoPlano) {
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setRg(rg);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setDataNascimento(dataNascimento);
		setEnderecoCliente(enderecoCliente);
		setDataCadasatro(dataCadasatro);
		setTipoPlano(tipoPlano);
		setVencimentoPlano(vencimentoPlano);
	}
	
	
	public Cliente(String nomeCliente,String login,String senha,String cpf,String celular,String operadora,String email,String enderecoCliente,String tipoPlano) {
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setCpf(cpf);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setEnderecoCliente(enderecoCliente);
		setTipoPlano(tipoPlano);
	}
		
	



	public String toStringCompleta() {
		
		String clienteDetalhe = "{ Cliente | ID: "+getId()+" | Nome do Cliente: "+getNomeCliente()+" | Plano: "+getTipoPlano()+" | Login: "+getLogin()+
				" | Senha: "+getSenha()+" | RG: "+getRg()+" |\n CPF: "+getCpf()+" | Telefone: "+getTelefone()+
				" | Celular: "+getCelular()+" | Operadora: "+getOperadora()+" | Email: "+getEmail()+
				"|\n Endereco do Cliente: "+getEnderecoCliente()+" | }";
		
		return clienteDetalhe;
	}
	
	
	public String toStringBasica() {
		
		String clienteDetalhe = "{ Cliente | ID: "+getId()+" | Nome do Cliente: "+getNomeCliente()+" | Plano: "+getTipoPlano()+" | Login: "+getLogin()+
				"\n | Senha: "+getSenha()+" | CPF: "+getCpf()+" | Celular: "+getCelular()+" | Operadora: "+getOperadora()+
				"\n | Email: "+getEmail()+"| Endereco do Cliente: "+getEnderecoCliente()+" | }";
		
		return clienteDetalhe;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nome) {
		this.nomeCliente = nome;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public Calendar getDataCadasatro() {
		return dataCadasatro;
	}

	public void setDataCadasatro(Calendar dataCadasatro) {
		this.dataCadasatro = dataCadasatro;
	}

	public String getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public int getVencimentoPlano() {
		return vencimentoPlano;
	}

	public void setVencimentoPlano(int vencimentoPlano) {
		this.vencimentoPlano = vencimentoPlano;
	}


}
