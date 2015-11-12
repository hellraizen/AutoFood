package com.autofood.estoque;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque ) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException;

	public void atualizar(Estoque estoque ) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public void remover(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public Estoque procurar(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public Boolean existi(Integer idEstoqueProduto);

	public ArrayList<Estoque > listar() throws SQLException;

}
