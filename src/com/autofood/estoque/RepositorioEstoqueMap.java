package com.autofood.estoque;

import java.util.ArrayList;
import java.util.HashMap;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueMap implements IRepositorioEstoque {
	
	HashMap<Integer,Estoque> arrayMapEstoque;
	private int index;
	
	public RepositorioEstoqueMap(){
		
		arrayMapEstoque = new HashMap<Integer,Estoque>();
		index = 1;
		
	}

	public void cadastra(Estoque estoque) throws ProdutoJaCadastradoEstoqueException, NomeVazioException {
		estoque.setIdEstoqueProduto(index);
		if(existi(estoque.getIdEstoqueProduto()))throw new ProdutoJaCadastradoEstoqueException() ;
		if(estoque.getNomeProdutoEstoque().equals(null))throw new  NomeVazioException();
		
		arrayMapEstoque.put(index,estoque);
		index++;

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
