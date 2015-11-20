package com.autofood.exceçõesCliente;

public class ClienteCpfInvalidoException extends Exception {
	public ClienteCpfInvalidoException(){
		super("Cliente com CPF invalido");
	}
	
}
