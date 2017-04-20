package com.edu.fafica.SGP.exceptions;

public class ClienteCpfInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteCpfInvalidoException(){
		super(" com CPF invalido!\n");
	}
	
}
