package com.autofood.produto;

import java.util.ArrayList;

public class RepositorioProdutoList implements IRepositorioProduto {

	private ArrayList<Produto> arrayListProduto;
	private int index;

	public RepositorioProdutoList() {

		arrayListProduto = new ArrayList<Produto>();
		index = 1;

	}

	public void cadastra(Produto produto) {
		produto.setIdProduto(index);
		arrayListProduto.add(produto);
		index++;

	}

	public void atualizar(Produto produto) {

	}

	public Boolean remover(Integer idProduto) {

		return null;
	}

	public Produto procurar(Integer idProduto) {

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {

		return null;
	}

	public ArrayList<Produto> listar() {
		for (Produto produto : arrayListProduto) {

			System.out.println(produto.toString());
		}

		return arrayListProduto;
	}

}
