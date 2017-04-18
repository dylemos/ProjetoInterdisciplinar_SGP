package com.edu.fafica.SGP.exceptions;

public class ContaJaCadastradaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ContaJaCadastradaException() {
		super(" Já Cadastrada!");
	}

}
