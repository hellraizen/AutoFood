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
	
	Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood1/files/repositorioCliente.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	

	public RepositorioClienteIO() throws IOException {
		
		Files.createDirectories(path.getParent());
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException {
		if (existe(cliente.getCpf()))
			throw new ClienteJaCadastradoException();
		
		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND);) {
			escrever.write(cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getDataNascimento() + ";"
					+ cliente.getSexo() + ";" + cliente.getCodigo() + ";" + cliente.getEmail() + ";"
					+ cliente.getTelefone() + "\n");

			
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}

	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException, IOException {

		ArrayList<Cliente> arrayLocal = listar();
		
		for (Cliente cliente1 : arrayLocal) {
			
			if(cliente1.getCpf().equals(cliente.getCpf())){
				
				arrayLocal.remove(cliente1);
				arrayLocal.add(cliente);
				JOptionPane.showMessageDialog(null, " Atualizado com sucesso");
				break;
				}
			
			}
		try (BufferedWriter escrever1 = Files.newBufferedWriter(path, utf8);) {
			escrever1.write(" ");
		}
		for (Cliente cliente3 : arrayLocal) {
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND);) {
				escrever.write(cliente3.getNome() + ";" + cliente3.getCpf() + ";" + cliente3.getDataNascimento() + ";"
						+ cliente3.getSexo() + ";" + cliente3.getCodigo() + ";" + cliente3.getEmail() + ";"
							+ cliente3.getTelefone() + "\n");
				}
			}
		}
	

	@Override
	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {
        ArrayList<Cliente> arrayLocal = listar();
		
		for (Cliente cliente2 : arrayLocal) {
			if(cliente2.getCpf().equals(cpf)){
				arrayLocal.remove(cliente2);
				JOptionPane.showMessageDialog(null, " Removido com sucesso");
				break;
		
				}
			}
		try (BufferedWriter escrever1 = Files.newBufferedWriter(path, utf8);) {
			escrever1.write(" ");
		}
		for (Cliente cliente3 : arrayLocal) {
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND);) {
				escrever.write(cliente3.getNome() + ";" + cliente3.getCpf() + ";" + cliente3.getDataNascimento() + ";"
						+ cliente3.getSexo() + ";" + cliente3.getCodigo() + ";" + cliente3.getEmail() + ";"
							+ cliente3.getTelefone() + "\n");
				}
			}
		}
	

	@Override
	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {
		  ArrayList<Cliente> arrayLocal = listar();
			
			for (Cliente cliente2 : arrayLocal) {
				if(cliente2.getCpf().equals(cpf)){
					return cliente2;
					
			
					}
				}

			throw new ClienteNaoEncontradoException();
	}

	@Override
	public boolean existe(String cpf) throws SQLException, IOException {
		  ArrayList<Cliente> arrayLocal = listar();
			
			for (Cliente cliente2 : arrayLocal) {
				if(cliente2.getCpf().equals(cpf)){
					
					return true;
					
			
					}
				}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException, IOException {

		ArrayList<Cliente> arrayLocal = new ArrayList<Cliente>();

		try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {
			String linha = null;
			Integer index = 1;
			while ((linha = ler.readLine()) != null) {
				
				String[] dados = linha.split(";");

				Cliente cliente = new Cliente(dados[0], dados[1], dados[2], dados[3], index,
						dados[5], dados[6]);
				index++;
			arrayLocal.add(cliente);
			}
			

			return arrayLocal;
		}
	}
}