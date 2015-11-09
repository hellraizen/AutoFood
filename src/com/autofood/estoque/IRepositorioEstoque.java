package com.autofood.estoque;

import java.util.ArrayList;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque );

	public void atualizar(Estoque estoque );

	public void remover(Integer idEstoqueProduto);

	public Estoque procurar(Integer idEstoqueProduto);

	public Boolean existi(Integer idEstoqueProduto);

	public ArrayList<Estoque > listar();

}
