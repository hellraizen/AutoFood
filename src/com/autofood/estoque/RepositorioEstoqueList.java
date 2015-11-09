package com.autofood.estoque;

import java.util.ArrayList;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueList implements IRepositorioEstoque {

	private ArrayList<Estoque> arrayListEstoque;
	private int index;

	public RepositorioEstoqueList() {

		arrayListEstoque = new ArrayList<Estoque>();
		index = 1;

	}

	public void cadastra(Estoque estoque) throws NomeVazioException, ProdutoJaCadastradoEstoqueException {
		if (existi(estoque.getIdEstoqueProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();

		estoque.setIdEstoqueProduto(index);
		arrayListEstoque.add(estoque);
		index++;

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException {

		int i = getId(estoque.getIdEstoqueProduto());
		if (i == -1)
			throw new ProdutoEstoqueNaoEncontradoException();

		arrayListEstoque.add(i, estoque);

	}

	public void remover(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {
		
		int i = getId(idEstoqueProduto);
		if (i == -1)
			throw new ProdutoEstoqueNaoEncontradoException();
		
		arrayListEstoque.remove(i);

	}

	public Estoque procurar(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {
		
		int i = getId(idEstoqueProduto);
		if (i == -1)
			throw new ProdutoEstoqueNaoEncontradoException();

		return null;
	}

	public Boolean existi(Integer idEstoqueProduto) {

		return null;
	}

	public ArrayList<Estoque> listar() {

		return null;
	}

	private int getId(Integer idEstoqueProduto) {
		int resposta = -1;
		boolean achou = false;
		for (int i = 0; !achou && (i < index); i = i + 1) {
			if (arrayListEstoque.get(i).equals(idEstoqueProduto)) {
				resposta = i;
				achou = true;
			}
		}
		return resposta;
	}
}