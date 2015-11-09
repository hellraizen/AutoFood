package com.autofood.exceçõesEstoque;

public class ProdutoEstoqueNaoEncontradoException extends Exception {

	public ProdutoEstoqueNaoEncontradoException() {
		
		super("Produto não Encontrado no Estoque");

	}
	
	
}
