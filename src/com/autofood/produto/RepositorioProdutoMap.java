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
		String i = produto.getCodigoProduto();

		for (int j = 1; j < index; j++) {
			Produto produtos = arrayMapProduto.get(j);
			if (i.equals(produtos.getCodigoProduto()));
			int id = produtos.getIdProduto();
			arrayMapProduto.remove(produtos);
			arrayMapProduto.put(id,produto);
			JOptionPane.showMessageDialog(null,
					"Produto Atualizado com Sucesso");

		}
	}

	// funcional
	public void remover(String codigoProduto) throws ProdutoNaoEncontradoException {

		String i = codigoProduto;

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (i.equals(produto.getCodigoProduto()));
			int id = produto.getIdProduto();
			arrayMapProduto.remove(id);
			JOptionPane.showMessageDialog(null, "Produto Removido com Sucesso");

		}

	}

	// funcional
	public Produto procurar(String codigoProduto)
			throws ProdutoNaoEncontradoException {

		String i = codigoProduto;

		for (int j = 1; j < index; j++) {

			Produto produto = arrayMapProduto.get(j);

			if (i.equals(produto.getCodigoProduto()));

			return produto;
		}

		return null;
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