package com.autofood.estoque;

import java.util.ArrayList;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class ControladorEstoque {
	
	private IRepositorioEstoque repositorioEstoque;
	
	public ControladorEstoque(){
		
		repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueMap();
		//repositorioEstoque = new RepositorioEstoqueJdbc();
		
	}
	
	public void cadastra(Estoque estoque) throws NomeVazioException, ProdutoJaCadastradoEstoqueException {
		
		repositorioEstoque.cadastra(estoque);

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException {
		
		repositorioEstoque.atualizar(estoque);
		
	}

	public void remover(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {
		
		repositorioEstoque.remover(idEstoqueProduto);
		
	}

	public Estoque procurar(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {

		return repositorioEstoque.procurar(idEstoqueProduto);
		
	}

	public Boolean existi(Integer idEstoqueProduto) {

		return repositorioEstoque.existi(idEstoqueProduto);
		
	}

	public ArrayList<Estoque> listar() {

		return repositorioEstoque.listar();
		
	}

}
