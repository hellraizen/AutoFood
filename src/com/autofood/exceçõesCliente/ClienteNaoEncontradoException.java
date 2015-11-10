package com.autofood.exceçõesCliente;

public class ClienteNaoEncontradoException extends Exception{
	
	public ClienteNaoEncontradoException(){
		super("Cliente não encontrado");
	}

}
