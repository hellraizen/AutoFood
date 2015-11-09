package com.autofood.exceçõesEstoque;

public class ProdutoJaCadastradoEstoqueException extends Exception{
	
	public ProdutoJaCadastradoEstoqueException(){
		
		super("Produto já cadastrado no estoque");
		
	}

}
