package com.autofood.estoque;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque ) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException;

	public void atualizar(Estoque estoque ) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException;

	public Boolean existi(String codigoProduto);

	public ArrayList<Estoque > listar() throws SQLException;

}
