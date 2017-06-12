package com.edu.fafica.SGP.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
	
	private int id;
	private String status;
	private String nomeCliente;
	private String login;
	private String senha;
	private String rg;
	private String cpf;
	private String telefone;
	private String celular;
	private String operadora;
	private String email;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private Date dataNascimento;
	private Date dataCadasatro;
	private String tipoPlano;
	private int vencimentoPlano;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Cliente(String status, String nomeCliente,String login,String senha,String rg,String cpf,String telefone,String celular,String operadora,String email, String rua,String numero	,String bairro	,String cidade	,String uf	,String cep, String dataNascimento, String dataCadasatro,String tipoPlano,int vencimentoPlano) {
		setStatus(status);
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setRg(rg);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
		setDataNascimento(dataNascimento);
		setDataCadasatro(dataCadasatro);
		setTipoPlano(tipoPlano);
		setVencimentoPlano(vencimentoPlano);
	}
	
	
	public Cliente(String status, String nomeCliente,String login,String senha,String rg,String cpf,String telefone,String celular,String operadora,String email, String rua,String numero	,String bairro	,String cidade	,String uf	,String cep, String dataNascimento, String dataCadasatro,int vencimentoPlano) {
		setStatus(status);
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setRg(rg);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
		setDataNascimento(dataNascimento);
		setDataCadasatro(dataCadasatro);
		setVencimentoPlano(vencimentoPlano);
	}
	
	public Cliente(int id, String status, String nomeCliente,String login,String senha,String rg,String cpf,String telefone,String celular,String operadora,String email, String rua,String numero	,String bairro	,String cidade	,String uf	,String cep, String dataNascimento, String dataCadasatro,int vencimentoPlano) {
		setId(id);
		setStatus(status);
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setRg(rg);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
		setDataNascimento(dataNascimento);
		setDataCadasatro(dataCadasatro);
		setVencimentoPlano(vencimentoPlano);
	}
	
	
	
	public Cliente(String status, String nomeCliente,String login,String senha,String rg,String cpf,String telefone,String celular,String operadora,String email, String rua,String numero	,String bairro	,String cidade	,String uf	,String cep, java.sql.Date dataNasc, java.sql.Date dataCadastro,String tipoPlano,int vencimentoPlano) {
		setStatus(status);
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setRg(rg);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
		setDataNascimento(dataNasc);
		setDataCadasatro(dataCadastro);
		setTipoPlano(tipoPlano);
		setVencimentoPlano(vencimentoPlano);
	}
	
	
	public Cliente(String status, String nomeCliente,String login,String senha,String cpf,String celular,String operadora,String email,String cep,String tipoPlano) {
		setStatus(status);
		setNomeCliente(nomeCliente);
		setLogin(login);
		setSenha(senha);
		setCpf(cpf);
		setCelular(celular);
		setOperadora(operadora);
		setEmail(email);
		setCep(cep);
		setTipoPlano(tipoPlano);
	}
		
	public Cliente(String cpf){
		setCpf(cpf);
	}



	public String toStringCompleta() {
		
		String clienteDetalhe = "\n{ Cliente | ID: "+getId()+" | Status: "+getStatus()+" | Nome do Cliente: "+getNomeCliente()+" | Plano: "+getTipoPlano()+" | Login: "+getLogin()+
				" | Senha: "+getSenha()+" | RG: "+getRg()+" |\n CPF: "+getCpf()+" | Telefone: "+getTelefone()+
				" | Celular: "+getCelular()+" | Operadora: "+getOperadora()+" | Email: "+getEmail()+
				"|\n Endereco do Cliente: [ Rua "+getRua()+" - N° "+getNumero()+" - Bairro "+getBairro()+
				" - Cidade "+getCidade()+" - UF "+getUf()+" - CEP "+getCep()+" ] }\n";
		
		return clienteDetalhe;
	}
	
	
	public String toStringBasica() {
		
		String clienteDetalhe = "\n{ Cliente | ID: "+getId()+" | Status: "+getStatus()+" | Nome do Cliente: "+getNomeCliente()+" | Plano: "+getTipoPlano()+" | Login: "+getLogin()+
				"\n | Senha: "+getSenha()+" | CPF: "+getCpf()+" | Celular: "+getCelular()+" | Operadora: "+getOperadora()+
				"\n | Email: "+getEmail()+"| Rua do Cliente: "+getRua()+" | }\n";
		
		return clienteDetalhe;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	
	
	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataNascimento);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataNascimento = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public void setDataCadasatro(Date dataCadasatro) {
		this.dataCadasatro = dataCadasatro;
	}


	public Date getDataCadasatro() {
		return dataCadasatro;
	}

	public void setDataCadasatro(String dataCadasatro) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataCadasatro);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataCadasatro = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
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
