package com.autofood.estoque;

import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioFornecedorIO implements IRepositorioEstoque {

	public void cadastra(Estoque estoque) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException {

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException, SQLException {

	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {

	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {

		return null;
	}

	public Boolean existi(String codigoProduto) {

		return null;
	}

	public ArrayList<Estoque> listar() throws SQLException {

		return null;
	}
}
