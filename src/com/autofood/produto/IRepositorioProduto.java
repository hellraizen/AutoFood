package com.autofood.produto;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public interface IRepositorioProduto {

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException, NomeVazioException, SQLException;

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException;

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException;

	public Produto procurar(Integer idProduto) throws ProdutoNaoEncontradoException;

	public Boolean existi(Integer idPrdotudo);

	public ArrayList<Produto> listar();

}
