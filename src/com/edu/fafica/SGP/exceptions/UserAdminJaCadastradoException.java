package com.edu.fafica.SGP.exceptions;

public class UserAdminJaCadastradoException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserAdminJaCadastradoException() {
		super(" já cadastrado!\n");
	}

}
