package com.autofood.estoque;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueList implements IRepositorioEstoque {

	private ArrayList<Estoque> arrayListEstoque;
	private int index;

	public RepositorioEstoqueList() {

		arrayListEstoque = new ArrayList<Estoque>();
		index = 1;

	}

	public void cadastra(Estoque estoque) throws NomeVazioException,ProdutoJaCadastradoEstoqueException {
		
		estoque.setIdEstoqueProduto(index);

		if (existi(estoque.getIdEstoqueProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();

		arrayListEstoque.add(estoque);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro Realizado Com Sucesso");

	}

	public void atualizar(Estoque estoque)
			throws ProdutoEstoqueNaoEncontradoException {
		int i = estoque.getIdEstoqueProduto();

		for (Estoque estoques : arrayListEstoque) {
			if (i == estoques.getIdEstoqueProduto());
			arrayListEstoque.remove(estoques);
			arrayListEstoque.add(estoque);

			JOptionPane.showMessageDialog(null,
					"Estoque Atualizado Com Sucesso");
		}

	}

	public void remover(Integer idEstoqueProduto)
			throws ProdutoEstoqueNaoEncontradoException {
		int i = idEstoqueProduto;

		for (Estoque estoque : arrayListEstoque) {
			if (i == estoque.getIdEstoqueProduto());
			arrayListEstoque.remove(estoque);
			
			JOptionPane.showMessageDialog(null, "Cadastro Removido com Sucesso");

		}

	}

	public Estoque procurar(Integer idEstoqueProduto)
			throws ProdutoEstoqueNaoEncontradoException {
		int i = idEstoqueProduto;

		for (Estoque estoque : arrayListEstoque) {
			if (i == estoque.getIdEstoqueProduto());

			return estoque;
		}

		return null;
	}

	public Boolean existi(Integer idEstoqueProduto) {
	
		for (Estoque estoque : arrayListEstoque) {

			if (estoque.getIdEstoqueProduto() == idEstoqueProduto) {

				return true;

			}
		}

		return false;
	}
	

	public ArrayList<Estoque> listar() {

		return arrayListEstoque;
	}

}