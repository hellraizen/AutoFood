package com.autofood.fornecedor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce�oesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exce�oesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exce�oesFornecedor.FornecedorNuloException;


public interface IRepositorioFornecedor {

	public void cadastra(Fornecedor fornecedor) throws FornecedorJaCadastradoException, FornecedorNuloException, SQLException, IOException;

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException; 

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException; 

	public Fornecedor procurar(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException; 

	public Boolean existi(String cnpjFornecedor) throws SQLException, IOException;

	public ArrayList<Fornecedor> listar() throws SQLException, IOException;
}
