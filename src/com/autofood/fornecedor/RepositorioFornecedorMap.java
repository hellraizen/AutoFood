package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorMap implements IRepositorioFornecedor {

	private HashMap<Integer, Fornecedor> arrayFornecedorMap;
	private int index;

	public RepositorioFornecedorMap() {

		arrayFornecedorMap = new HashMap<Integer, Fornecedor>();
		index = 1;

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException {
		if (existi(fornecedor.getCnpjFornecedor()))
			throw new FornecedorJaCadastradoException();
		if (fornecedor.getNomeFornecedor().equals(null))
			throw new FornecedorNuloException();

		fornecedor.setIdFornecedor(index);
		arrayFornecedorMap.put(index, fornecedor);
		index++;

		JOptionPane
				.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
	}

	public void atualizar(Fornecedor fornecedor)
			throws FornecedorNaoEncontradoException {
		int i = fornecedor.getIdFornecedor();

		for (int j = 1; j < index; j++) {
			Fornecedor fornecedor2 = arrayFornecedorMap.get(j);
			if (i == fornecedor2.getIdFornecedor()) {

				arrayFornecedorMap.remove(j, fornecedor2);
				arrayFornecedorMap.put(j, fornecedor);

				JOptionPane.showMessageDialog(null,
						"Fornecedor Atualizado com Sucesso");

			}
		}
	}

	public void remover(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {
		for (int i = 1; i < index; i++) {
			Fornecedor fornecedor = arrayFornecedorMap.get(i);
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				arrayFornecedorMap.remove(i, fornecedor);

				JOptionPane.showMessageDialog(null,
						"Fornecedor Removido com sucesso");

			}
		}
	}

	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {
		for (int i = 1; i < index; i++) {
			Fornecedor fornecedor = arrayFornecedorMap.get(i);
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return fornecedor;

			}
		}
		throw new FornecedorNaoEncontradoException();
	}

	public Boolean existi(String cnpjFornecedor) {
		for (int i = 1; i < index; i++) {
			Fornecedor fornecedor = arrayFornecedorMap.get(i);
			if (fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)) {

				return true;

			}
		}
		return false;
	}

	public ArrayList<Fornecedor> listar() throws SQLException {
		ArrayList<Fornecedor> arrayListFornecedor = new ArrayList<Fornecedor>();

		for (int i = 1; i < index; i++) {

			Fornecedor fornecedor = arrayListFornecedor.get(i);

			arrayListFornecedor.add(fornecedor);

		}

		return arrayListFornecedor;
	}
}
