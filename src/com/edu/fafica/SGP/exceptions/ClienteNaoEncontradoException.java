package com.edu.fafica.SGP.exceptions;

public class ClienteNaoEncontradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public ClienteNaoEncontradoException(){
		super(" não encontrado!\n");
	}

}
