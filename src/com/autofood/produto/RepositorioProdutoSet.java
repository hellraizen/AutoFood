package com.autofood.produto;

import java.util.ArrayList;
import java.util.TreeSet;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoSet implements IRepositorioProduto {

	private TreeSet<Produto> arraySetProduto;
	private int index;

	public RepositorioProdutoSet() {

		arraySetProduto = new TreeSet<Produto>();
		index = 1;

	}

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException {
		if (existi(produto.getIdProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		produto.setIdProduto(index);
		arraySetProduto.add(produto);
		index++;

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		int i = produto.getIdProduto();
		for (Produto produto2 : arraySetProduto) {
			if (i == produto2.getIdProduto()) {
				arraySetProduto.remove(produto2);
			} else {

				throw new ProdutoNaoEncontradoException();

			}
		}
		arraySetProduto.add(produto);

	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {
		for (Produto produto : arraySetProduto) {
			if (idProduto.equals(produto.getIdProduto())) {
				arraySetProduto.remove(produto);
			} 
				
			
		}throw new ProdutoNaoEncontradoException();
	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		for (Produto produto : arraySetProduto) {
			if (idProduto.equals(produto.getIdProduto())) {

				return produto;

			} else {

				throw new ProdutoNaoEncontradoException();

			}
		}

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {
		
		boolean verificador = false;
		
		for (Produto produto : arraySetProduto) {
			
			if (idPrdotudo.equals(produto.getIdProduto())) {
				
				verificador = true;
				return verificador;

			}

		}

		return verificador;
	}

	public ArrayList<Produto> listar() {
		
		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();
		
		for (Produto produto : arrayListProduto) {
			
			arrayListProduto.add(produto);
			
		}

		return arrayListProduto;
	}

}