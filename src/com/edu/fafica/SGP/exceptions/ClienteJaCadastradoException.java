package com.edu.fafica.SGP.exceptions;

public class ClienteJaCadastradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteJaCadastradoException() {
		super(" Já está Cadastrado!");
	}
}
