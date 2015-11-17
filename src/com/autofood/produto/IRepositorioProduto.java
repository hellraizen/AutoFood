package com.autofood.produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public interface IRepositorioProduto {

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException, NomeVazioException, SQLException, IOException;

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, SQLException, IOException;

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException, IOException;

	public Produto procurar(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException, IOException;

	public Boolean existi(Integer idPrdotudo) throws SQLException, IOException;

	public ArrayList<Produto> listar() throws SQLException, IOException;

}
