package com.edu.fafica.SGP.entidades;

public class Fornecedor {
	
	private int id;
	private String razaoSocial;
	private String cnpj;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String email;
	private String telefone;
	private String celular;
	private String operadora;
	private String enderecoFornecedor;
	private String nomeFantasia;
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
	
	public Fornecedor(String razaoSocial, String cnpj, String rua,String numero	,String bairro	,String cidade	,String uf	,String cep, String email, String telefone, String celular, String operadora, String enderecoFornecedor, String nomeFantasia) {
		setRazaoSocial(razaoSocial);
		setCnpj(cnpj);
		setRua(rua);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setCep(cep);
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
				getOperadora()+"  | Rua do Fornecedor: "+getRua()+"  |\n Nome Fantasia: "+
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
