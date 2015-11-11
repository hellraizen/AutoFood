package com.autofood.produto;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	// funcional
	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException {

		produto.setIdProduto(index);
		if (existi(produto.getIdProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		arrayListProduto.add(produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		for (Produto produto1 : arrayListProduto) {
			if (produto1.getIdProduto() == produto.getIdProduto()) {

				arrayListProduto.add(produto);

			}

		}
		throw new ProdutoNaoEncontradoException();

	}

	// //funcional mas com erro 
	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {

		for (Produto produto : arrayListProduto) {

			if (produto.getIdProduto() == idProduto) {

				arrayListProduto.remove(produto);
				JOptionPane.showMessageDialog(null,
						"Cliente Removido com Sucesso");

			}
		}
		throw new ProdutoNaoEncontradoException();
	}

	// funcional
	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		for (Produto produto : arrayListProduto) {
			if (produto.getIdProduto() == idProduto) {

				return produto;

			}

		}

		throw new ProdutoNaoEncontradoException();

	}

	// funcional
	public Boolean existi(Integer idProduto) {

		for (Produto produto : arrayListProduto) {

			if (produto.getIdProduto() == idProduto) {

				return true;

			}
		}

		return false;
	}

	// funcional
	public ArrayList<Produto> listar() {
		for (Produto produto : arrayListProduto) {

			System.out.println(produto.toString());
		}

		return arrayListProduto;
	}
}