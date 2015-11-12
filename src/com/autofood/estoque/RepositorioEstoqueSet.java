package com.autofood.estoque;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import com.autofood.exce��esEstoque.NomeVazioException;
import com.autofood.exce��esEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueSet implements IRepositorioEstoque {

	private HashSet<Estoque> arraySetEstoque;
	private int index;

	public RepositorioEstoqueSet() {

		arraySetEstoque = new HashSet<Estoque>();
		index = 1;

	}

	public void cadastra(Estoque estoque)
			throws ProdutoJaCadastradoEstoqueException, NomeVazioException {
		estoque.setIdEstoqueProduto(index);
		if (existi(estoque.getIdEstoqueProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();

		arraySetEstoque.add(estoque);
		index++;
		
		JOptionPane.showMessageDialog(null, "Cadastro Realizado Com Sucesso");
	}

	public void atualizar(Estoque estoque) {

		int i = estoque.getIdEstoqueProduto();

		for (Estoque estoque2 : arraySetEstoque) {
			if (i == estoque2.getIdEstoqueProduto());

			arraySetEstoque.remove(estoque2);
			arraySetEstoque.add(estoque);
			
			JOptionPane.showMessageDialog(null,
					"Estoque Atualizado Com Sucesso");
		}

	}

	public void remover(Integer idEstoqueProduto) {
		int i = idEstoqueProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i == estoque.getIdEstoqueProduto());

			arraySetEstoque.remove(estoque);
			
			JOptionPane.showMessageDialog(null, "Cadastro Removido com Sucesso");
		}

	}

	public Estoque procurar(Integer idEstoqueProduto) {
		int i = idEstoqueProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i == estoque.getIdEstoqueProduto());

			return estoque;
		}

		return null;
	}

	public Boolean existi(Integer idEstoqueProduto) {
		int i = idEstoqueProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i == estoque.getIdEstoqueProduto());
			
			return true;
		}
		return false;
	}

	public ArrayList<Estoque> listar() {
		ArrayList<Estoque> arrayListEstoque = new ArrayList<Estoque>();
		
		for (Estoque estoque : arraySetEstoque) {
			
			arrayListEstoque.add(estoque);
		}

		return arrayListEstoque;
	}

}
