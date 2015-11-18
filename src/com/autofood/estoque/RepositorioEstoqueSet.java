package com.autofood.estoque;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueSet implements IRepositorioEstoque {

	private HashSet<Estoque> arraySetEstoque;
	private int index;

	public RepositorioEstoqueSet() {

		arraySetEstoque = new HashSet<Estoque>();
		index = 1;

	}

	public void cadastra(Estoque estoque)
			throws ProdutoJaCadastradoEstoqueException, NomeVazioException {
		
		if (existi(estoque.getCodigoProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();
		
		estoque.setIdEstoqueProduto(index);
		arraySetEstoque.add(estoque);
		index++;
		
		JOptionPane.showMessageDialog(null, "Cadastro Realizado Com Sucesso");
	}

	public void atualizar(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException {

		int i = estoque.getIdEstoqueProduto();

		for (Estoque estoque2 : arraySetEstoque) {
			if (i == estoque2.getIdEstoqueProduto()){

			arraySetEstoque.remove(estoque2);
			arraySetEstoque.add(estoque);
			
			JOptionPane.showMessageDialog(null,
					"Estoque Atualizado Com Sucesso");
			
			}
			throw new ProdutoEstoqueNaoEncontradoException();
		}

	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {
		String i = codigoProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i.equals(estoque.getCodigoProduto())){

			arraySetEstoque.remove(estoque);
			
			JOptionPane.showMessageDialog(null, "Cadastro Removido com Sucesso");
		
		}
		throw new ProdutoEstoqueNaoEncontradoException();
	  }
	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {
		String i = codigoProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i.equals(estoque.getIdEstoqueProduto())){

			return estoque;

		}
		
			throw new ProdutoEstoqueNaoEncontradoException();
	}

		return null;
	}

	public Boolean existi(String codigoProduto) {
		String i = codigoProduto;

		for (Estoque estoque : arraySetEstoque) {
			if (i.equals(estoque.getIdEstoqueProduto()));
			
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
