package com.autofood.estoque;

import java.util.ArrayList;

public class ControladorEstoque {
	
	private IRepositorioEstoque repositorioEstoque;
	
	public ControladorEstoque(){
		
		repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueMap();
		//repositorioEstoque = new RepositorioEstoqueJdbc();
		
	}
	
	public void cadastra(Estoque estoque) {
		
		repositorioEstoque.cadastra(estoque);

	}

	public void atualizar(Estoque estoque) {
		
		repositorioEstoque.atualizar(estoque);
		
	}

	public void remover(Integer idEstoqueProduto) {
		
		repositorioEstoque.remover(idEstoqueProduto);
		
	}

	public Estoque procurar(Integer idEstoqueProduto) {

		return repositorioEstoque.procurar(idEstoqueProduto);
		
	}

	public Boolean existi(Integer idEstoqueProduto) {

		return repositorioEstoque.existi(idEstoqueProduto);
		
	}

	public ArrayList<Estoque> listar() {

		return repositorioEstoque.listar();
		
	}

}
