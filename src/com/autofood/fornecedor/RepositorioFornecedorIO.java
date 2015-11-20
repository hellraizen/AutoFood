package com.autofood.fornecedor;

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

import com.autofood.clientes.Cliente;
import com.autofood.exce�oesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exce�oesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exce�oesFornecedor.FornecedorNuloException;

public class RepositorioFornecedorIO implements IRepositorioFornecedor {
	
	//Path path = Paths.get("/AutoFood/files/repositorioioFornecedor.txt");
	Path path = Paths.get("C:/Users/Vinicius/git/AutoFood/files/repositorioioFornecedor.txt");
	Charset utf8 = StandardCharsets.UTF_8;
	
	public RepositorioFornecedorIO() throws IOException {
	
		Files.createDirectories(path.getParent());
		
	}


	public void cadastra(Fornecedor fornecedor) throws FornecedorJaCadastradoException, FornecedorNuloException, IOException, SQLException {

		if(existi(fornecedor.getCnpjFornecedor()))throw new FornecedorJaCadastradoException();
		
		
		try(BufferedWriter arquivar = Files.newBufferedWriter(path,utf8,StandardOpenOption.APPEND);){
			
			arquivar.write(fornecedor.getIdFornecedor() + ";" + fornecedor.getNomeFornecedor() + ";"
			+ fornecedor.getCnpjFornecedor() + ";" + fornecedor.getProdutoFornecido() + ";"
			+ fornecedor.getTelefoneFornecedor() + ";" + fornecedor.getEmailFornecedor() + "\n");
			
			JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
			
		}
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException {
		
		ArrayList<Fornecedor> arrayLocal = listar();
		
		for (Fornecedor fornecedor2 : arrayLocal) {
			if(fornecedor2.getCnpjFornecedor().equals(fornecedor.getCnpjFornecedor())){
				
				arrayLocal.remove(fornecedor2);
				arrayLocal.add(fornecedor);
				break;
			}
			
		}
		try(BufferedWriter apagar = Files.newBufferedWriter(path,utf8);){
			
			apagar.write(" ");
			
		}
		
		for (Fornecedor fornecedor3 : arrayLocal) {
			
			try(BufferedWriter arquivar = Files.newBufferedWriter(path,utf8,StandardOpenOption.APPEND);){
				
				arquivar.write(fornecedor3.getIdFornecedor() + ";" + fornecedor3.getNomeFornecedor() + ";"
						   + fornecedor3.getCnpjFornecedor() + ";" + fornecedor3.getProdutoFornecido() + ";"
						   + fornecedor3.getTelefoneFornecedor() + ";" + fornecedor3.getEmailFornecedor() + "\n");
				
			}	
		}
		JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
	}

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException {
		
		ArrayList<Fornecedor> arrayLocal = listar();

		for (Fornecedor fornecedor : arrayLocal) {
			if(fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)){
				
				arrayLocal.remove(fornecedor);
				break;
			}
		}
		
		try(BufferedWriter apagar = Files.newBufferedWriter(path, utf8);){
			
			apagar.write(" ");
			
		}
		
		for (Fornecedor fornecedor2 : arrayLocal) {
			
			try(BufferedWriter arquivar = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND);){
				
				arquivar.write(fornecedor2.getIdFornecedor() + ";" + fornecedor2.getNomeFornecedor() + ";"
						   + fornecedor2.getCnpjFornecedor() + ";" + fornecedor2.getProdutoFornecido() + ";"
						   + fornecedor2.getTelefoneFornecedor() + ";" + fornecedor2.getEmailFornecedor() + "\n");
				
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");
	}

	public Fornecedor procurar(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException, IOException {
		
		ArrayList<Fornecedor> arrayLocal = listar();
		
		for (Fornecedor fornecedor : arrayLocal) {
			if(fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)){
				
				return fornecedor;
				
			}
		}

		throw new FornecedorNaoEncontradoException();
	}

	public Boolean existi(String cnpjFornecedor) throws SQLException, IOException {
		
		ArrayList<Fornecedor> arrayLocal = listar();
		
		for (Fornecedor fornecedor : arrayLocal) {
			if(fornecedor.getCnpjFornecedor().equals(cnpjFornecedor)){
				
				return true;
				
			}
		}

		return false;
	}

	public ArrayList<Fornecedor> listar() throws SQLException, IOException {
		
		ArrayList<Fornecedor> arrayLocal = new ArrayList<Fornecedor>();
		
		try(BufferedReader leitura = Files.newBufferedReader(path,utf8);){
			
		String linha = null;
		Integer index = 1;
		
		while((linha = leitura.readLine()) != null){
			
			String[] dados = linha.split(";");
			
			Fornecedor fornecedor = new Fornecedor(index,dados[1],dados[2],dados[3],dados[4],dados[5]);
			index++;
			arrayLocal.add(fornecedor);
			
		}
			return arrayLocal;
		}
	}
}