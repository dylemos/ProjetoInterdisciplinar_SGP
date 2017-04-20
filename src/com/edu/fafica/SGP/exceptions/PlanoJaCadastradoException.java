package com.edu.fafica.SGP.exceptions;

public class PlanoJaCadastradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public PlanoJaCadastradoException() {
		super(" Já Cadastrado!\n");
	}
	
}
