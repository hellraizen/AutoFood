package com.autofood.produto;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoMap implements IRepositorioProduto {

	private HashMap<Integer, Produto> arrayMapProduto;
	private int index;

	public RepositorioProdutoMap() {

		arrayMapProduto = new HashMap<Integer, Produto>();
		index = 1;

	}

	// funcional
	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException {
		produto.setIdProduto(index);
		if (existi(produto.getIdProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		arrayMapProduto.put(index, produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	// funcional
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		int i = produto.getIdProduto();

		for (int j = 1; j < index; j++) {
			Produto produtos = arrayMapProduto.get(j);
			if (i == produtos.getIdProduto())
				;

			arrayMapProduto.remove(i, produtos);
			arrayMapProduto.put(i, produto);
			JOptionPane.showMessageDialog(null,
					"Produto Atualizado com Sucesso");

		}
	}

	// funcional
	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {

		int i = idProduto;

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (i == produto.getIdProduto())
				;

			arrayMapProduto.remove(i);
			JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");

		}

	}

	// funcional
	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		int i = idProduto;

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (i == produto.getIdProduto())
				;

			return produto;
		}

		return null;
	}

	// funcional
	public Boolean existi(Integer idProduto) {
		for (int i = 1; i < index; i++) {
			Produto produto = arrayMapProduto.get(i);
			if (produto.getIdProduto() == idProduto) {
				return true;
			}
		}
		return false;
	}
	//funcional
	public ArrayList<Produto> listar() {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		for (int i = 1; i < index; i++) {

			Produto produto = arrayMapProduto.get(i);

			arrayListProduto.add(produto);

		}

		return arrayListProduto;
	}

}