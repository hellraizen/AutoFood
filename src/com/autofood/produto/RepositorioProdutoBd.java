package com.autofood.produto;

import java.util.ArrayList;
import com.autofood.exce��esProduto.NomeVazioException;
import com.autofood.exce��esProduto.ProdutoJ�CadastradoException;
import com.autofood.exce��esProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoBd implements IRepositorioProduto {

	public void cadastra(Produto produto) throws ProdutoJ�CadastradoException,
			NomeVazioException {

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {

	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {

	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {

		return null;
	}

	public ArrayList<Produto> listar() {

		return null;
	}

}
