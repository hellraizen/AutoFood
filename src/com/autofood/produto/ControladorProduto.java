package com.autofood.produto;

import java.util.ArrayList;

import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;

public class ControladorProduto {

	private IRepositorioProduto repositorioProduto;

	public ControladorProduto() {

		repositorioProduto = new RepositorioProdutoList();
		//repositorioProduto = new RepositorioProdutoSet();
		//repositorioProduto = new RepositorioProdutoMap();
		//repositorioProduto = new RepositorioProdutoBd();

	}

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException {
		
		repositorioProduto.cadastra(produto);

	}

	public void atualizar(Produto produto) {
		
		repositorioProduto.atualizar(produto);
		
	}

	public void remover(Integer idProduto) {
		
		repositorioProduto.remover(idProduto);
		
	}

	public Produto procurar(Integer idProduto) {
		
		return repositorioProduto.procurar(idProduto);
		
	}

	public Boolean existi(Integer idPrdotudo) {
		
		return repositorioProduto.existi(idPrdotudo);
		
	}

	public ArrayList<Produto> listar() {
		
		return repositorioProduto.listar();
		
	}

}
