package com.edu.fafica.SGP.entidades;

import java.util.Calendar;

public class Chamado {
	
	private int id;
	private int idCliente;				//referência a Cliente
	private String tipoChamado;
	private Calendar dataSolicitacao;
	private String statusChamado;
	private String descProblema;
	
	public Chamado(String tipoChamado, String statusChamado, String descProblema) {
		setTipoChamado(tipoChamado);
		setStatusChamado(statusChamado);
		setDescProblema(descProblema);
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getTipoChamado() {
		return tipoChamado;
	}

	public void setTipoChamado(String tipoChamado) {
		this.tipoChamado = tipoChamado;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
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
