package com.autofood.produto;

import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoIO implements IRepositorioProduto {

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException, SQLException {

	}

	public void atualizar(Produto produto)
			throws ProdutoNaoEncontradoException, SQLException {

	}

	public void remover(Integer idProduto)
			throws ProdutoNaoEncontradoException, SQLException {

	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException, SQLException {

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {

		return null;
	}

	public ArrayList<Produto> listar() throws SQLException {

		return null;
	}
}
