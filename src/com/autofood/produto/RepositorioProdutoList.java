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

	public void remover(Integer idProduto) {
		int i = getId(idProduto);
		if(i == -1)System.out.println("colocar exception");
		
		arrayListProduto.remove(i);
	}

	public Produto procurar(Integer idProduto) {
		
		int i = getId(idProduto);
		if(i == -1)System.out.println("colocar exception");
		return arrayListProduto.get(i);
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
	
	private int getId(Integer idProduto) {
		int resposta = -1;
		boolean achou = false;
		for (int i = 0; !achou && (i < index); i = i + 1) {
			if (arrayListProduto.get(i).equals(idProduto)) {
				resposta = i;
				achou = true;
			}
		}
		return resposta;
	}

}
