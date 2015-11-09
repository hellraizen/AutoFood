package com.autofood.estoque;

import java.util.ArrayList;

import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque ) throws NomeVazioException, ProdutoJaCadastradoEstoqueException;

	public void atualizar(Estoque estoque ) throws ProdutoEstoqueNaoEncontradoException;

	public void remover(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException;

	public Estoque procurar(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException;

	public Boolean existi(Integer idEstoqueProduto);

	public ArrayList<Estoque > listar();

}
