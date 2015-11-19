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


		for (Estoque estoque2 : arraySetEstoque) {
			if (estoque.getCodigoProduto().equals(estoque2.getCodigoProduto())){

			arraySetEstoque.remove(estoque2);
			arraySetEstoque.add(estoque);
			
			JOptionPane.showMessageDialog(null,
					"Estoque Atualizado Com Sucesso");
			
			}
			
		}
		
		//throw new ProdutoEstoqueNaoEncontradoException();

	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {
		

		for (Estoque estoque : arraySetEstoque) {
			if (estoque.getCodigoProduto().equals(codigoProduto)){

			arraySetEstoque.remove(estoque);
			
			JOptionPane.showMessageDialog(null, "Cadastro Removido com Sucesso");
		
		}
			
	  }
		//throw new ProdutoEstoqueNaoEncontradoException();
	}

	public Estoque procurar(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {
		

		for (Estoque estoque : arraySetEstoque) {
			if (estoque.getCodigoProduto().equals(codigoProduto)){

			return estoque;

		}
		
			
	}

		throw new ProdutoEstoqueNaoEncontradoException();
	}

	public Boolean existi(String codigoProduto) {
	

		for (Estoque estoque : arraySetEstoque) {
			if (estoque.getCodigoProduto().equals(codigoProduto)){
			
			return true;
		}
			
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
