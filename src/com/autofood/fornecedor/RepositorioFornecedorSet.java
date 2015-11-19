package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorSet implements IRepositorioFornecedor {

	private HashSet<Fornecedor> arrayFornecedorSet;
	private int index;

	public RepositorioFornecedorSet() {

		arrayFornecedorSet = new HashSet<Fornecedor>();
		index = 1;

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException {
		if (existi(fornecedor.getCnpjFornecedor()))
			throw new FornecedorJaCadastradoException();
		if (fornecedor.getNomeFornecedor().equals(null))
			throw new FornecedorNuloException();

		fornecedor.setIdFornecedor(index);
		arrayFornecedorSet.add(fornecedor);
		index++;

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		
		for (Fornecedor fornecedor2 : arrayFornecedorSet) {
			if (fornecedor.getIdFornecedor() == fornecedor2.getIdFornecedor()) {

				arrayFornecedorSet.remove(fornecedor2);
				arrayFornecedorSet.add(fornecedor);

				JOptionPane.showMessageDialog(null,
						"Fornecedor atualizado com sucesso");

			}
		}
		//throw new FornecedorNaoEncontradoException();
	}

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException {

		for (Fornecedor fornecedor : arrayFornecedorSet) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				arrayFornecedorSet.remove(fornecedor);
				JOptionPane.showMessageDialog(null,
						"Fornecedor removido com sucesso");

			}
		}

		throw new FornecedorNaoEncontradoException();

	}

	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		for (Fornecedor fornecedor : arrayFornecedorSet) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return fornecedor;

			}
		}

		throw new FornecedorNaoEncontradoException();
	}

	public Boolean existi(String cnpjFornecedor) {

		for (Fornecedor fornecedor : arrayFornecedorSet) {
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return true;

			}
		}
		return false;
	}

	public ArrayList<Fornecedor> listar() throws SQLException {
		ArrayList<Fornecedor> arrayFornecedorList = new ArrayList<Fornecedor>();

		for (Fornecedor fornecedor : arrayFornecedorSet) {

			arrayFornecedorList.add(fornecedor);

		}

		return arrayFornecedorList;
	}

}
