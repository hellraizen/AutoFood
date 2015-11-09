package com.autofood.estoque;

import java.util.ArrayList;
import java.util.TreeSet;

public class RepositorioEstoqueSet implements IRepositorioEstoque {
	
	private TreeSet<Estoque> arraySetEstoque;
	private int index;
	
	public RepositorioEstoqueSet(){
		
		arraySetEstoque = new TreeSet<Estoque>();
		index = 1;
		
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
