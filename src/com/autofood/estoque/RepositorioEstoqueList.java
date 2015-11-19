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

		if (existi(estoque.getCodigoProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();
		
		estoque.setIdEstoqueProduto(index);
		arrayListEstoque.add(estoque);
		index++;
		
		JOptionPane.showMessageDialog(null, "Cadastro Realizado Com Sucesso");
	}

	public void atualizar(Estoque estoque)
			throws ProdutoEstoqueNaoEncontradoException {

		for (Estoque estoque2 : arrayListEstoque) {
			if (estoque.getCodigoProduto().equals(estoque2.getCodigoProduto())){
				
			arrayListEstoque.remove(estoque2);
			arrayListEstoque.add(estoque);

			JOptionPane.showMessageDialog(null,
					"Estoque Atualizado Com Sucesso");
			
			}
			
		}
	
		//throw new ProdutoEstoqueNaoEncontradoException();
		
	}

	public void remover(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException {

		
		for (Estoque estoque : arrayListEstoque) {
			if (estoque.getCodigoProduto().equals(codigoProduto)){
				
			arrayListEstoque.remove(estoque);
			
			JOptionPane.showMessageDialog(null, "Cadastro Removido com Sucesso");
			
		}
		
	  }
		//throw new ProdutoEstoqueNaoEncontradoException();
	}

	public Estoque procurar(String codigoProduto)throws ProdutoEstoqueNaoEncontradoException {

		for (Estoque estoque : arrayListEstoque) {
			if (estoque.getCodigoProduto().equals(codigoProduto)){

			return estoque;
		}
			
	}
		throw new ProdutoEstoqueNaoEncontradoException();
		
	}

	public Boolean existi(String codigoProduto) {
	
		for (Estoque estoque : arrayListEstoque) {

			if (estoque.getCodigoProduto().equals(codigoProduto)) {

				return true;

			}
		}

		return false;
	}
	

	public ArrayList<Estoque> listar() {

		return arrayListEstoque;
	}

}