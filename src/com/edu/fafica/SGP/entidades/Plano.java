package com.edu.fafica.SGP.entidades;


public class Plano {

	private int id;
	private String nomePlano;
	private String upload;
	private String download;
	private Double valor;
	
	public Plano() {
		// TODO Auto-generated constructor stub
	}
	
	public Plano(String nomePlano, String download, String upload, Double valor) {
		setNomePlano(nomePlano);
		setDownload(download);
		setUpload(upload);
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


	public String getUpload() {
		return upload;
	}


	public void setUpload(String upload) {
		this.upload = upload;
	}


	public String getDownload() {
		return download;
	}


	public void setDownload(String download) {
		this.download = download;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
