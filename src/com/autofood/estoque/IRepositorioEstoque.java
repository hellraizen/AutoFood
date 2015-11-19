package com.autofood.estoque;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public interface IRepositorioEstoque {
	
	public void cadastra(Estoque estoque ) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException, IOException;

	public void atualizar(Estoque estoque ) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException;

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException;

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException;

	public Boolean existi(String codigoProduto) throws SQLException, IOException;

	public ArrayList<Estoque > listar() throws SQLException, IOException;

}
