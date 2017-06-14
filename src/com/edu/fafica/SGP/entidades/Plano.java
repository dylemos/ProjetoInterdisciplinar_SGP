package com.edu.fafica.SGP.entidades;


public class Plano {

	private int id;
	private String nomePlano;
	private int upload;
	private int download;
	private Double valor;
	
	public Plano() {
		// TODO Auto-generated constructor stub
	}
	
	public Plano(String nomePlano, int upload, int download, Double valor) {
		setNomePlano(nomePlano);
		setUpload(upload);
		setDownload(download);
		setValor(valor);
	}
	
	public Plano(int id, String nomePlano, int upload, int download, Double valor) {
		setId(id);
		setNomePlano(nomePlano);
		setUpload(upload);
		setDownload(download);
		setValor(valor);
	}
	
	public String toString() {
		
		String planoDetalhe = "{ Plano | ID: "+getId()+" | Tipo do Plano: "+getNomePlano()+" | DownLoad: "+getDownload()+
				" | UpLoad: "+getUpload()+" | Valor: R$"+getValor()+" | }";
		
		return planoDetalhe;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomePlano() {
		return nomePlano;
	}


	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}


	public int getUpload() {
		return upload;
	}


	public void setUpload(int upload) {
		this.upload = upload;
	}


	public int getDownload() {
		return download;
	}


	public void setDownload(int download) {
		this.download = download;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
