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
	public void cadastra(Produto produto) throws ProdutoJáCadastradoException, NomeVazioException {

		if (existi(produto.getCodigoProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		produto.setIdProduto(index);
		arrayMapProduto.put(index, produto);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	// funcional
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		
		for (int j = 1; j < index; j++) {
			Produto produtos = arrayMapProduto.get(j);
			if (produtos.getCodigoProduto().equals(produto.getCodigoProduto())) {

				arrayMapProduto.remove(produtos);
				arrayMapProduto.put(j, produto);
				JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso");
			}
		}
		//throw new ProdutoNaoEncontradoException();
	}

	// funcional com bug
	public void remover(String codigoProduto) throws ProdutoNaoEncontradoException {

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (produto.getCodigoProduto().equals(codigoProduto)) {
			
				arrayMapProduto.remove(j,produto);
				JOptionPane.showMessageDialog(null, "Produto Removido com Sucesso");

			}
			
		}
		//throw new ProdutoNaoEncontradoException();
	}

	// funcional
	public Produto procurar(String codigoProduto) throws ProdutoNaoEncontradoException {

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return produto;
			}

			
		}
		throw new ProdutoNaoEncontradoException();
		//return null;
	}

	// funcional
	public Boolean existi(String codigoProduto) {
		
		for (int i = 1; i < index; i++) {
			
			Produto produto = arrayMapProduto.get(i);
			
			if (produto.getCodigoProduto().equals(codigoProduto)) {
				
				return true;
		   }
			
		}
		return false;
	}

	// funcional
	public ArrayList<Produto> listar() {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		for (int i = 1; i < index; i++) {

			Produto produto = arrayMapProduto.get(i);

			arrayListProduto.add(produto);

		}

		return arrayListProduto;
	}

}