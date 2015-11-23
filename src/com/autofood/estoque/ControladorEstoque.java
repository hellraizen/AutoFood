package com.autofood.estoque;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public class ControladorEstoque {
	
	private IRepositorioEstoque repositorioEstoque;
	
	public ControladorEstoque() throws ClassNotFoundException, IOException{
		
		//repositorioEstoque = new RepositorioEstoqueList();
		//repositorioEstoque = new RepositorioEstoqueSet();
		//repositorioEstoque = new RepositorioEstoqueMap();
		repositorioEstoque = new RepositorioEstoqueJdbc();
		//repositorioEstoque = new RepositorioEstoqueIO();		
	}
	
	public void cadastra(Estoque estoque) throws NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException, IOException {
		
		repositorioEstoque.cadastra(estoque);

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {
		
		repositorioEstoque.atualizar(estoque);
		
	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {
		
		repositorioEstoque.remover(codigoProduto);
		
	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {

		return repositorioEstoque.procurar(codigoProduto);
		
	}

	public Boolean existi(String codigoProduto) throws SQLException, IOException {

		return repositorioEstoque.existi(codigoProduto);
		
	}

	public ArrayList<Estoque> listar() throws SQLException, IOException {

		return repositorioEstoque.listar();
		
	}

}
