package com.autofood.produto;

import java.util.ArrayList;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoBd implements IRepositorioProduto {

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
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
