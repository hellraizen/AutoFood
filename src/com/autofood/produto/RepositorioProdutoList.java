package com.autofood.produto;
import java.util.ArrayList;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoList implements IRepositorioProduto {

	private ArrayList<Produto> arrayListProduto;
	private int index;

	public RepositorioProdutoList() {

		arrayListProduto = new ArrayList<Produto>();
		index = 1;

	}

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,NomeVazioException {
		if (existi(produto.getIdProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		produto.setIdProduto(index);
		arrayListProduto.add(produto);
		index++;

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		int i = getId(produto.getIdProduto());
		if (i == -1)
			throw new ProdutoNaoEncontradoException();

		arrayListProduto.add(i, produto);
	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {
		int i = getId(idProduto);
		if (i == -1)
			throw new ProdutoNaoEncontradoException();

		arrayListProduto.remove(i);
	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		int i = getId(idProduto);
		if (i == -1)
			throw new ProdutoNaoEncontradoException();
		return arrayListProduto.get(i);
	}

	public Boolean existi(Integer idProduto) {

		Boolean verificador = false;

		for (Produto produto : arrayListProduto) {
			if (idProduto.equals(produto.getIdProduto())) {

				verificador = true;
				return verificador;

			}
		}

		return verificador;
	}

	public ArrayList<Produto> listar() {
		for (Produto produto : arrayListProduto) {

			System.out.println(produto.toString());
		}

		return arrayListProduto;
	}

	private int getId(Integer idProduto) {
		int resposta = -1;
		boolean achou = false;
		for (int i = 0; !achou && (i < index); i = i + 1) {
			if (arrayListProduto.get(i).equals(idProduto)) {
				resposta = i;
				achou = true;
			}
		}
		return resposta;
	}
}