package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class ControladorFornecedor {

	IRepositorioFornecedor repositorioFornecedor;

	public ControladorFornecedor() {

		repositorioFornecedor = new RepositorioFornecedorList();
		// repositorioFornecedor = new RepositorioFornecedorSet();
		// repositorioFornecedor = new RepositorioFornecedorMap();
		// repositorioFornecedor = new RepositorioFornecedorJDBC();
		// repositorioFornecedor = new RepositorioFornecedorIO();

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException {

		repositorioFornecedor.cadastra(fornecedor);

	}

	public void atualizar(Fornecedor fornecedor)
			throws FornecedorNaoEncontradoException {

		repositorioFornecedor.atualizar(fornecedor);

	}

	public void remover(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		repositorioFornecedor.remover(cnpjFornecedor);

	}

	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException {

		return repositorioFornecedor.procurar(cnpjFornecedor);

	}

	public Boolean existi(String cnpjFornecedor) {

		return repositorioFornecedor.existi(cnpjFornecedor);

	}

	public ArrayList<Fornecedor> listar() throws SQLException {

		return repositorioFornecedor.listar();
	}
}