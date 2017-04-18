package com.edu.fafica.SGP.pessoas;

public class Fornecedor {
	
	private int id;
	private String razaoSocial;
	private String cnpj;
	private String email;
	private String telefone;
	private String celular;
	private String operadora;
	private String enderecoFornecedor;
	private String nomeFantasia;
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(String razaoSocial, String cnpj, String email, String telefone, String celular, String operadora, String enderecoFornecedor, String nomeFantasia) {
		setRazaoSocial(razaoSocial);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setCelular(celular);
		setOperadora(operadora);
		setEnderecoFornecedor(enderecoFornecedor);
		setNomeFantasia(nomeFantasia);
	}
	
	
	public String toString() {
		
		String fornecedorDetalhe = "{ Fornecedor | ID: "+getId()+" | Razao Social: "+getRazaoSocial()+" | CNPJ: "+getCnpj()+
				" |\n Email: "+getEmail()+" | Telefone: "+getTelefone()+"  |\n Celular: "+getCelular()+"  | Operadora: "+
				getOperadora()+"  | Endereço do Fornecedor: "+getEnderecoFornecedor()+"  |\n Nome Fantasia: "+
				getNomeFantasia()+" | }";
		
		return fornecedorDetalhe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(String enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	
	
	
}
