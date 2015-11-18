package com.autofood.estoque;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public class ControladorEstoque {
	
	private IRepositorioEstoque repositorioEstoque;
	
	public ControladorEstoque() throws ClassNotFoundException{
		
		repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueSet();
		//repositorioEstoque = new RepositorioEstoqueMap();
		//repositorioEstoque = new RepositorioEstoqueJdbc();
		//repositorioEstoque = new RepositorioFornecedorIO();
		
	}
	
	public void cadastra(Estoque estoque) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException {
		
		repositorioEstoque.cadastra(estoque);

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException, SQLException {
		
		repositorioEstoque.atualizar(estoque);
		
	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {
		
		repositorioEstoque.remover(codigoProduto);
		
	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {

		return repositorioEstoque.procurar(codigoProduto);
		
	}

	public Boolean existi(String codigoProduto) {

		return repositorioEstoque.existi(codigoProduto);
		
	}

	public ArrayList<Estoque> listar() throws SQLException {

		return repositorioEstoque.listar();
		
	}

}
