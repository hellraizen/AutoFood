package com.autofood.fornecedor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçoesFornecedor.CNPJFornecedorInvalido;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;
import com.autofood.util.ValidarCNPJ;

public class ControladorFornecedor {

	IRepositorioFornecedor repositorioFornecedor;

	public ControladorFornecedor() throws ClassNotFoundException, IOException {

		//repositorioFornecedor = new RepositorioFornecedorList();
		//repositorioFornecedor = new RepositorioFornecedorSet();
		//repositorioFornecedor = new RepositorioFornecedorMap();
		repositorioFornecedor = new RepositorioFornecedorJDBC();
		//repositorioFornecedor = new RepositorioFornecedorIO();

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException, SQLException, CNPJFornecedorInvalido, IOException {

		if(!ValidarCNPJ.validaCNPJ(fornecedor.getCnpjFornecedor())){
			throw new CNPJFornecedorInvalido();
		}else{
			
		repositorioFornecedor.cadastra(fornecedor);	
			
		}
	}

	public void atualizar(Fornecedor fornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {

		if(!ValidarCNPJ.validaCNPJ(fornecedor.getCnpjFornecedor())){
			throw new CNPJFornecedorInvalido();
			
		}else{
			
			repositorioFornecedor.atualizar(fornecedor);
			
		}
	}

	public void remover(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {

		
		repositorioFornecedor.remover(cnpjFornecedor);

	 
	}
	public Fornecedor procurar(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {
	

		return repositorioFornecedor.procurar(cnpjFornecedor);
		
		}
	

	public Boolean existi(String cnpjFornecedor) throws SQLException, IOException {

		return repositorioFornecedor.existi(cnpjFornecedor);

	}

	public ArrayList<Fornecedor> listar() throws SQLException, IOException {

		return repositorioFornecedor.listar();
	}
}