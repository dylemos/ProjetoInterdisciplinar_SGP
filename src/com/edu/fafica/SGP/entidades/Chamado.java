package com.edu.fafica.SGP.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chamado {
	
	private int id;
	private String cpfCliente;				//referência a Cliente
	private String tipoChamado;
	private String descProblema;
	private String statusChamado;
	private Date dataAbertura;
	private Date dataFechamento;
	
	public Chamado(String cpfCliente, String tipoChamado, String descProblema, String statusChamado, String dataAbertura, String dataFechamento) {
		setCpfCliente(cpfCliente);
		setTipoChamado(tipoChamado);
		setDescProblema(descProblema);
		setStatusChamado(statusChamado);
		setdataAbertura(dataAbertura);
		setDataFechamento(dataFechamento);
	}

	public Chamado() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {				
		
		String chamadoDetalhe = "{ Chamado | ID: "+getId()+" | Tipo de Chamado: "+getTipoChamado()+" | Status do Chamado: "+getStatusChamado()+" | }";
		
		return chamadoDetalhe;
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

	public String getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(String tipoChamado) {
		this.tipoChamado = tipoChamado;
	}

	
	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public void setDataFechamento(String dataFechamento) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
			
			java.util.Date dateStr = formatter.parse(dataFechamento);
			java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
			this.dataFechamento = dateDB;
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
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

	public String getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(String statusChamado) {
		this.statusChamado = statusChamado;
	}

	public String getDescProblema() {
		return descProblema;
	}

	public void setDescProblema(String descProblema) {
		this.descProblema = descProblema;
	}

	
	

}
