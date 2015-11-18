package com.autofood.estoque;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueMap implements IRepositorioEstoque {

	HashMap<Integer, Estoque> arrayMapEstoque;
	private int index;

	public RepositorioEstoqueMap() {

		arrayMapEstoque = new HashMap<Integer, Estoque>();
		index = 1;

	}

	public void cadastra(Estoque estoque) throws ProdutoJaCadastradoEstoqueException, NomeVazioException {

		if (existi(estoque.getCodigoProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();

		estoque.setIdEstoqueProduto(index);
		arrayMapEstoque.put(index, estoque);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException {
		int i = estoque.getIdEstoqueProduto();

		for (int j = 1; j < index; j++) {
			Estoque estoque1 = arrayMapEstoque.get(j);
			if (i == estoque1.getIdEstoqueProduto()) {
				//int id = estoque1.getIdEstoqueProduto();
				arrayMapEstoque.remove(estoque1);
				arrayMapEstoque.put(j,estoque);

				JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso");
			}
			//throw new ProdutoEstoqueNaoEncontradoException();
		}
	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {
		String i = codigoProduto;

		for (int j = 1; j < index; j++) {
			Estoque estoque = arrayMapEstoque.get(j);
			if (i.equals(estoque.getCodigoProduto())) {

				arrayMapEstoque.remove(j,estoque);
				JOptionPane.showMessageDialog(null, "Produto removido do estoque com sucesso");
			}

			//throw new ProdutoEstoqueNaoEncontradoException();
		}
	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {

		String id = codigoProduto;

		for (int j = 1; j < index; j++) {
			
			Estoque estoque = arrayMapEstoque.get(j);
			
			if (id.equals(estoque.getCodigoProduto())) {

				return estoque;
			}
			//throw new ProdutoEstoqueNaoEncontradoException();
		}

		return null;

	}

	public Boolean existi(String codigoProduto) {
		for (int j = 1; j < index; j++) {
			Estoque estoque = arrayMapEstoque.get(j);
			if (codigoProduto.equals(estoque.getCodigoProduto())) {

				return true;
			}

		}

		return false;
	}

	public ArrayList<Estoque> listar() {

		ArrayList<Estoque> arrayListEstoque = new ArrayList<Estoque>();

		for (int i = 1; i < index; i++) {

			Estoque estoque = arrayMapEstoque.get(i);

			arrayListEstoque.add(estoque);

		}

		return arrayListEstoque;
	}

}
