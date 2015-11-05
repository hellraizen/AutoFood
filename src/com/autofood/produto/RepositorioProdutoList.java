package com.autofood.produto;

import java.util.ArrayList;

import com.autofood.exceÁıesProduto.ProdutoJ·CadastradoException;

public class RepositorioProdutoList implements IRepositorioProduto {

	private ArrayList<Produto> arrayListProduto;
	private int index;

	public RepositorioProdutoList() {

		arrayListProduto = new ArrayList<Produto>();
		index = 1;

	}

	public void cadastra(Produto produto) throws ProdutoJ·CadastradoException {
		if (existi(produto.getIdProduto()))
			throw new ProdutoJ·CadastradoException();

		produto.setIdProduto(index);
		arrayListProduto.add(produto);
		index++;

	}

	public void atualizar(Produto produto) {

		int i = getId(produto.getIdProduto());
		if (i == -1)
			System.out.println("Colocar Exception");

		arrayListProduto.add(i, produto);
	}

	public void remover(Integer idProduto) {
		int i = getId(idProduto);
		if (i == -1)
			System.out.println("colocar exception");

		arrayListProduto.remove(i);
	}

	public Produto procurar(Integer idProduto) {

		int i = getId(idProduto);
		if (i == -1)
			System.out.println("colocar exception");
		return arrayListProduto.get(i);
	}

	public Boolean existi(Integer idProduto) {

		Boolean verificador = false;

		for (Produto produto : arrayListProduto) {
			if (idProduto.equals(produto.getIdProduto())) {

				verificador = true;
				return verificador;

			}
		}

		return verificador;
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