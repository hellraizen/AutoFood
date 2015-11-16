package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorJDBC implements IRepositorioFornecedor{

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException {

	}

	public void atualizar(Fornecedor fornecedor)
			throws FornecedorNaoEncontradoException {

	}

	public void remover(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

	}

	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		return null;
	}

	public Boolean existi(String cnpjFornecedor) {

		return null;
	}

	public ArrayList<Fornecedor> listar() throws SQLException {

		return null;
	}

}
