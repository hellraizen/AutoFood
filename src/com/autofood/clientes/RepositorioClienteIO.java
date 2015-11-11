package com.autofood.clientes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class RepositorioClienteIO implements IRepositorioCliente {
	Path path = Paths.get("C:/Users/danilo/git/AutoFood/files/repositorioio.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	Integer index;

	public RepositorioClienteIO() throws IOException {
		index = 1;
		Files.createDirectories(path.getParent());
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException {
		cliente.setCodigo(index);
		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND);) {
			escrever.write(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getDataNascimento() + ";"
					+ cliente.getSexo() + ";" + cliente.getCodigo() + ";" + cliente.getEmail() + ";"
					+ cliente.getTelefone() + "\n");

			index++;
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
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
	public ArrayList<Cliente> listar() throws SQLException, IOException {

		ArrayList<Cliente> arrayLocal = new ArrayList<Cliente>();

		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {
			String linha = null;

			while ((linha = ler.readLine()) != null) {
				String[] dados = linha.split(";");

				Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]),
						dados[5], dados[6]);
			arrayLocal.add(cliente);
			}
			

			return arrayLocal;
		}
	}
}