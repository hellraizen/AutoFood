package com.autofood.produto;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import com.autofood.exce��esProduto.NomeVazioException;
import com.autofood.exce��esProduto.ProdutoJ�CadastradoException;
import com.autofood.exce��esProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoSet implements IRepositorioProduto {

	private HashSet<Produto> arraySetProduto;
	private int index;

	public RepositorioProdutoSet() {

		arraySetProduto = new HashSet<Produto>();
		index = 1;

	}

	// funcional
	public void cadastra(Produto produto) throws ProdutoJ�CadastradoException,
			NomeVazioException {
		produto.setIdProduto(index);
		if (existi(produto.getIdProduto()))
			throw new ProdutoJ�CadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		arraySetProduto.add(produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	//funcional
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		int i = produto.getIdProduto();
		for (Produto produto2 : arraySetProduto) {
			if (i == produto2.getIdProduto());

			arraySetProduto.remove(produto2);
			arraySetProduto.add(produto);
		}

	}

	// funcional mas com erro
	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {
		for (Produto produto : arraySetProduto) {
			if (produto.getIdProduto() == idProduto) {

				arraySetProduto.remove(produto);
				JOptionPane.showMessageDialog(null,
						"Cliente Removido com Sucesso");
			}

		}
		throw new ProdutoNaoEncontradoException();
	}

	// funcional
	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		for (Produto produto : arraySetProduto) {
			if (produto.getIdProduto() == idProduto) {

				return produto;

			}
		}

		throw new ProdutoNaoEncontradoException();
	}

	//funcional
	public Boolean existi(Integer idPrdotudo) {

		for (Produto produto : arraySetProduto) {

			if (produto.getIdProduto() == idPrdotudo) {

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