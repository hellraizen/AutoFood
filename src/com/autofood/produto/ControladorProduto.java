package com.autofood.produto;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce��esProduto.NomeVazioException;
import com.autofood.exce��esProduto.ProdutoJ�CadastradoException;
import com.autofood.exce��esProduto.ProdutoNaoEncontradoException;

public class ControladorProduto {

	private IRepositorioProduto repositorioProduto;

	public ControladorProduto() throws ClassNotFoundException {

		//repositorioProduto = new RepositorioProdutoList();
		//repositorioProduto = new RepositorioProdutoSet();
		//repositorioProduto = new RepositorioProdutoMap();
		repositorioProduto = new RepositorioProdutoBd();

	}

	public void cadastra(Produto produto) throws ProdutoJ�CadastradoException, NomeVazioException, SQLException {
		
		repositorioProduto.cadastra(produto);

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, SQLException {
		
		repositorioProduto.atualizar(produto);
		
	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException {
		
		repositorioProduto.remover(idProduto);
		
	}

	public Produto procurar(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException {
		
		return repositorioProduto.procurar(idProduto);
		
	}

	public Boolean existi(Integer idPrdotudo) {
		
		return repositorioProduto.existi(idPrdotudo);
		
	}

	public ArrayList<Produto> listar() throws SQLException {
		
		return repositorioProduto.listar();
		
	}

}
