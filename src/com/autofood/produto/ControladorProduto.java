package com.autofood.produto;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class ControladorProduto {

	private IRepositorioProduto repositorioProduto;

	public ControladorProduto() throws ClassNotFoundException {

		//repositorioProduto = new RepositorioProdutoList();
		//repositorioProduto = new RepositorioProdutoSet();
		//repositorioProduto = new RepositorioProdutoMap();
		repositorioProduto = new RepositorioProdutoBd();

	}

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException, NomeVazioException, SQLException {
		
		repositorioProduto.cadastra(produto);

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		
		repositorioProduto.atualizar(produto);
		
	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {
		
		repositorioProduto.remover(idProduto);
		
	}

	public Produto procurar(Integer idProduto) throws ProdutoNaoEncontradoException {
		
		return repositorioProduto.procurar(idProduto);
		
	}

	public Boolean existi(Integer idPrdotudo) {
		
		return repositorioProduto.existi(idPrdotudo);
		
	}

	public ArrayList<Produto> listar() {
		
		return repositorioProduto.listar();
		
	}

}
