package com.autofood.estoque;

import java.util.ArrayList;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque ) throws NomeVazioException, ProdutoJaCadastradoEstoqueException;

	public void atualizar(Estoque estoque ) throws ProdutoEstoqueNaoEncontradoException;

	public void remover(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException;

	public Estoque procurar(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException;

	public Boolean existi(Integer idEstoqueProduto);

	public ArrayList<Estoque > listar();

}
