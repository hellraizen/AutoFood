package com.autofood.produto;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoSet implements IRepositorioProduto {

	private HashSet<Produto> arraySetProduto;
	private int index;

	public RepositorioProdutoSet() {

		arraySetProduto = new HashSet<Produto>();
		index = 1;

	}

	// funcional
	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException {

		if (existi(produto.getCodigoProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		produto.setIdProduto(index);
		arraySetProduto.add(produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	// funcional
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {

		for (Produto produto2 : arraySetProduto) {
			if (produto2.getCodigoProduto().equals(produto.getCodigoProduto())) {

				arraySetProduto.remove(produto2);
				arraySetProduto.add(produto);

				JOptionPane.showMessageDialog(null,
						"Produto Atualizado com Sucesso");
			}
		}

	}

	// funcional
	public void remover(String codigoProduto)
			throws ProdutoNaoEncontradoException {
		for (Produto produto : arraySetProduto) {
			if (produto.getCodigoProduto().equals(codigoProduto)) {

				arraySetProduto.remove(produto);
				JOptionPane.showMessageDialog(null,
						"Cliente Removido com Sucesso");

			}
			
		}
		//throw new ProdutoNaoEncontradoException();
	}

	// funcional
	public Produto procurar(String codigoProduto)
			throws ProdutoNaoEncontradoException {

		for (Produto produto : arraySetProduto) {
			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return produto;

			}
		}

		throw new ProdutoNaoEncontradoException();
	}

	// funcional
	public Boolean existi(String codigoProduto) {

		for (Produto produto : arraySetProduto) {

			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return true;

			}

		}

		return false;
	}

	// funcional
	public ArrayList<Produto> listar() {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		for (Produto produto : arraySetProduto) {

			arrayListProduto.add(produto);

		}
		return arrayListProduto;
	}

}