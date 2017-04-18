package com.edu.fafica.SGP.exceptions;


public class ChamadoJaCadastradoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ChamadoJaCadastradoException() {
		super(" Já Cadastrado!");
	}

}
