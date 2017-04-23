package com.edu.fafica.SGP.entidades;


public class Conta {
	
	private int id;
	private int idCliente;				//referência a Cliente
	private String tipoConta;			//referência a TipoConta
	private String statusConta;			//referência a StatusConta
	private Double valor;				 
	private Double desconto;
	private Double acrescimo;
	private int qtdParcelas;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(String tipoConta, String statusConta, Double valor, Double desconto, Double acrescimo, int qtdParcelas) {
		setTipoConta(tipoConta);
		setStatusConta(statusConta);
		setValor(valor);
		setDesconto(desconto);
		setAcrescimo(acrescimo);
		setQtdParcelas(qtdParcelas);
	}
	
	
	public String toString() {
		
		String contaDetalhe = "{ Conta | ID: "+getId()+" | Conta: "+getTipoConta()+" | Valor: R$"+getValor()+" | Status: "+getStatusConta()+" | }";
		
		return contaDetalhe;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(String statusConta) {
		this.statusConta = statusConta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	

}
