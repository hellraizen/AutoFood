package com.autofood.fornecedor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorIO implements IRepositorioFornecedor {
	
	Path path = Paths.get("/AutoFood/files/repositorioio.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	
	public RepositorioFornecedorIO() throws IOException {
	
		Files.createDirectories(path.getParent());
		
	}


	public void cadastra(Fornecedor fornecedor) throws FornecedorJaCadastradoException, FornecedorNuloException {

		if(existi(fornecedor.getCnpjFornecedor()))throw new FornecedorJaCadastradoException();
		if(fornecedor.getNomeFornecedor().equals(null)) throw new FornecedorNuloException();
		
		
		
		
		
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
