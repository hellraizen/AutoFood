package com.autofood.exceçõesCliente;

public class ClienteJaCadastradoException extends Exception {
	public ClienteJaCadastradoException() {
		super(" Cliente Já Cadastrado");
	}
}
