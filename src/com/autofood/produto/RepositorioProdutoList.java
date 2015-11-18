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

		
		if (existi(produto.getCodigoProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();
		
		produto.setIdProduto(index);
		arrayListProduto.add(produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}
	//funcional 
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		String i = produto.getCodigoProduto();

		for (Produto produtos : arrayListProduto) {

			if (i.equals(produtos.getCodigoProduto())) {
			
				arrayListProduto.remove(produtos);
				arrayListProduto.add(produto);
				JOptionPane.showMessageDialog(null,
						"Produto Atualizado com Sucesso");
			}
		}
		if(arrayListProduto.contains(produto.getCodigoProduto()))throw new ProdutoNaoEncontradoException();

	}


	// //funcional
	public void remover(String codigoProduto) throws ProdutoNaoEncontradoException {

		for (Produto produto : arrayListProduto) {

			if (produto.getCodigoProduto().equals(codigoProduto)) {

				arrayListProduto.remove(produto);
				JOptionPane.showMessageDialog(null,
						"Cliente Removido com Sucesso");
				
			}
			throw new ProdutoNaoEncontradoException();
		}
	}

	// funcional
	public Produto procurar(String codigoProduto)
			throws ProdutoNaoEncontradoException {

		for (Produto produto : arrayListProduto) {
			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return produto;

			}
			
			throw new ProdutoNaoEncontradoException();
		}

		return null;

	}

	// funcional
	public Boolean existi(String codigoProduto) {

		for (Produto produto : arrayListProduto) {

			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return true;

			}
		}

		return false;
	}

	// funcional
	public ArrayList<Produto> listar() {
		
		return arrayListProduto;
	}
}