package com.autofood.fornecedor;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce�oesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exce�oesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exce�oesFornecedor.FornecedorNuloException;


public interface IRepositorioFornecedor {

	public void cadastra(Fornecedor fornecedor) throws FornecedorJaCadastradoException, FornecedorNuloException;

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException; 

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException; 

	public Fornecedor procurar(String cnpjFornecedor) throws FornecedorNaoEncontradoException; 

	public Boolean existi(String cnpjFornecedor);

	public ArrayList<Fornecedor> listar() throws SQLException;
}
