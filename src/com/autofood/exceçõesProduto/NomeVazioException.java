package com.autofood.exceçõesProduto;

public class NomeVazioException extends Exception{
	
	public NomeVazioException(){
		
		super("Digite o nome do produto antes de cadastra");
		
	}

}
