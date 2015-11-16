package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;


public interface IRepositorioFornecedor {

	public void cadastra(Fornecedor fornecedor) throws FornecedorJaCadastradoException, FornecedorNuloException, SQLException;

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, SQLException; 

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException; 

	public Fornecedor procurar(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException; 

	public Boolean existi(String cnpjFornecedor);

	public ArrayList<Fornecedor> listar() throws SQLException;
}
