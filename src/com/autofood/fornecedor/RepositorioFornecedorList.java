package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorList implements IRepositorioFornecedor {

	private ArrayList<Fornecedor> arrayFornecedorList;
	private int index;

	public RepositorioFornecedorList() {

		arrayFornecedorList = new ArrayList<Fornecedor>();
		index = 1;

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException {
		if (existi(fornecedor.getCnpjFornecedor()))
			throw new FornecedorJaCadastradoException();
		if (fornecedor.getNomeFornecedor().equals(null))
			throw new FornecedorNuloException();

		fornecedor.setIdFornecedor(index);
		arrayFornecedorList.add(fornecedor);
		index++;

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		int i = fornecedor.getIdFornecedor();

		for (Fornecedor fornecedor2 : arrayFornecedorList) {
			if (i == fornecedor2.getIdFornecedor()) {
				arrayFornecedorList.remove(fornecedor2);
				arrayFornecedorList.add(fornecedor);
				JOptionPane.showMessageDialog(null,
						"Fornecedor Atualizado com Sucesso");
				
			}

		}
		
		//throw new FornecedorNaoEncontradoException();

	}

	public void remover(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		for (Fornecedor fornecedor : arrayFornecedorList) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				arrayFornecedorList.remove(fornecedor);

				JOptionPane.showMessageDialog(null,
						"Fornecedor Removido com Sucesso");

			}

		}

		throw new FornecedorNaoEncontradoException();

	}

	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		for (Fornecedor fornecedor : arrayFornecedorList) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return fornecedor;

			}
		}

		throw new FornecedorNaoEncontradoException();
	}

	public Boolean existi(String cnpjFornecedor) {

		for (Fornecedor fornecedor : arrayFornecedorList) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return true;

			}
		}

		return false;
	}

	public ArrayList<Fornecedor> listar() throws SQLException {

		return arrayFornecedorList;
	}

}
