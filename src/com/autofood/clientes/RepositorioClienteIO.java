package com.autofood.clientes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class RepositorioClienteIO implements IRepositorioCliente {
	Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioio.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	Integer index;

	public RepositorioClienteIO() throws IOException {
		index = 1;
		Files.createDirectories(path.getParent());
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException {
		cliente.setCodigo(index);
		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8);) {
			escrever.write(cliente.getCodigo() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";"
					+ cliente.getDataNascimento() + ";" + cliente.getSexo() + ";" + cliente.getTelefone() + ";"
					+ cliente.getEmail()+"\n");
			
			index++;

		} 

	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}