package com.edu.fafica.SGP.exceptions;

public class FornecedorJaCadastradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public FornecedorJaCadastradoException() {
		super(" Já Cadastrado");
	}

}
