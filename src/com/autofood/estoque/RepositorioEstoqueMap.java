package com.autofood.estoque;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioEstoqueMap implements IRepositorioEstoque {
	
	HashMap<Integer,Estoque> arrayMapEstoque;
	private int index;
	
	public RepositorioEstoqueMap(){
		
		arrayMapEstoque = new HashMap<Integer,Estoque>();
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
