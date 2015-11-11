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

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {

		int i = getId(produto.getIdProduto());
		if (i == -1)
			throw new ProdutoNaoEncontradoException();

		arrayMapProduto.put(i, produto);
	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {

		int i = getId(idProduto);
		if (i == -1)
			throw new ProdutoNaoEncontradoException();

		arrayMapProduto.remove(i);
		JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");
	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		int i = getId(idProduto);
		if (i == -1)
			throw new ProdutoNaoEncontradoException();

		return arrayMapProduto.get(i);
	}

	public Boolean existi(Integer idProduto) {
		for (int i = 1; i < arrayMapProduto.size(); i++) {
			Produto produto = arrayMapProduto.get(i);
			if (produto.getIdProduto() == idProduto) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Produto> listar() {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		for (Produto produto : arrayListProduto) {

			arrayListProduto.add(produto);

		}

		return arrayListProduto;
	}

	private int getId(Integer idProduto) {
		int resposta = -1;
		boolean achou = false;
		for (int i = 0; !achou && (i < index); i = i + 1) {
			if (arrayMapProduto.get(i).equals(idProduto)) {
				resposta = i;
				achou = true;
			}
		}
		return resposta;
	}
}