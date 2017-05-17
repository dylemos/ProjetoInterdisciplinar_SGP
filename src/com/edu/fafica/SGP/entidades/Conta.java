package com.edu.fafica.SGP.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conta {
	
	private int id;
	private String cpfCliente;				//referência a Cliente
	private String tipoConta;			//referência a TipoConta
	private String statusConta;			//referência a StatusConta
	private Double valor;				 
	private Double desconto;
	private Double total;
	private Date dataAbertura;
	private Date dataVencimento;
	private Date dataPago;
	private int qtdParcelas;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	
	public Conta(String cpfCliente, String tipoConta, String statusConta, Double valor, Double desconto, Double total, java.sql.Date dataAbertura, java.sql.Date dataVencimento, java.sql.Date dataPago, int qtdParcelas) {
		setCpfCliente(cpfCliente);
		setTipoConta(tipoConta);
		setStatusConta(statusConta);
		setValor(valor);
		setDesconto(desconto);
		setTotal(total);
		setDataAbertura(dataAbertura);
		setDataVencimento(dataVencimento);
		setDataPago(dataPago);
		setQtdParcelas(qtdParcelas);
	}

	public Conta(String cpfCliente, String tipoConta, String statusConta, Double valor, Double desconto, Double total, String dataAbertura, String dataVencimento, String dataPago, int qtdParcelas) {
		setCpfCliente(cpfCliente);
		setTipoConta(tipoConta);
		setStatusConta(statusConta);
		setValor(valor);
		setDesconto(desconto);
		setTotal(total);
		setdataAbertura(dataAbertura);
		setdataVencimento(dataVencimento);
		setdataPago(dataPago);
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

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setdataAbertura(String dataAbertura) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataAbertura);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataAbertura = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}

public void setdataVencimento(String dataVencimento) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataVencimento);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataVencimento = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public Date getDataPago() {
		return dataPago;
	}
	
public void setdataPago(String dataPago) {
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataPago);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataPago = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
	}

	public void setDataPago(Date dataPago) {
		this.dataPago = dataPago;
	}
	
	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	

}
