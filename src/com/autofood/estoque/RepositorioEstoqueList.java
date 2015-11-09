package com.autofood.estoque;

import java.util.ArrayList;

public class RepositorioEstoqueList implements IRepositorioEstoque {
	
	private ArrayList<Estoque> arrayListEstoque;
	private int index;
	
	public RepositorioEstoqueList(){
		
		arrayListEstoque = new ArrayList<Estoque>();
		index =1;
		
	}

	public void cadastra(Estoque estoque) {

	}

	public void atualizar(Estoque estoque) {

	}

	public void remover(Integer idEstoqueProduto) {

	}

	public Estoque procurar(Integer idEstoqueProduto) {

		return null;
	}

	public Boolean existi(Integer idEstoqueProduto) {

		return null;
	}

	public ArrayList<Estoque> listar() {

		return null;
	}
}