package com.autofood.produto;

import java.util.ArrayList;

public interface IRepositorioProduto {

	public void cadastra(Produto produto);

	public void atualizar(Produto produto);

	public void remover(Integer idProduto);

	public Produto procurar(Integer idProduto);

	public Boolean existi(Integer idPrdotudo);

	public ArrayList<Produto> listar();

}
