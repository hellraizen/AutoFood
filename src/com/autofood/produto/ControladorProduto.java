package com.autofood.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exce��esProduto.NomeVazioException;
import com.autofood.exce��esProduto.ProdutoJ�CadastradoException;
import com.autofood.exce��esProduto.ProdutoNaoEncontradoException;

public class ControladorProduto {

	private IRepositorioProduto repositorioProduto;

	public ControladorProduto() throws ClassNotFoundException, IOException {

		repositorioProduto = new RepositorioProdutoList();
		//repositorioProduto = new RepositorioProdutoSet();
		//repositorioProduto = new RepositorioProdutoMap();
		//repositorioProduto = new RepositorioProdutoBd();
		//repositorioProduto = new RepositorioProdutoIO();

	}

	public void cadastra(Produto produto) throws ProdutoJ�CadastradoException, NomeVazioException, SQLException, IOException {
		
		repositorioProduto.cadastra(produto);

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, SQLException, IOException {
		
		repositorioProduto.atualizar(produto);
		
	}

	public void remover(String codigoProduto) throws ProdutoNaoEncontradoException, SQLException, IOException {
		
		repositorioProduto.remover(codigoProduto);
		
	}

	public Produto procurar(String codigoProduto) throws ProdutoNaoEncontradoException, SQLException, IOException {
		
		return repositorioProduto.procurar(codigoProduto);
		
	}

	public Boolean existi(String codigoProduto) throws SQLException, IOException {
		
		return repositorioProduto.existi(codigoProduto);
		
	}

	public ArrayList<Produto> listar() throws SQLException, IOException {
		
		return repositorioProduto.listar();
		
	}

}
