package com.autofood.endereco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RepositorioEnderecoIO implements IRepositorioEndereco
{
	
	
	    //Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioio.txt");
		//Path path = Paths.get("C:/Users/Longtech/git/AutoFood/files/repositorioio.txt");
		Path path = Paths.get("/AutoFood/files/repositorioio.txt");

		Charset utf8 = StandardCharsets.UTF_8;
		Integer index = 1;
		
		public RepositorioEnderecoIO() throws IOException {
			
			Files.createDirectories(path.getParent());
		}

	
		
	@Override
	public void cadastrar(Endereco endereco) throws IOException
	{
		endereco.setIdEndereco(index);
		BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);
		escrever.write(endereco.getIdEndereco()+";"+endereco.getRua()+ ";"+ endereco.getBairro()+";"+ endereco.getNumero()+";"+ endereco.getCep()+";"+ endereco.getComplemento()+";"+ endereco.getCliente()+";"+ endereco.getFuncionario()+";"+ endereco.getFornecedor()+"\n");
		index ++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	
	}

	
	
	
	@Override
	public void atualizar(Endereco endereco) throws IOException
	{
		ArrayList<Endereco> arrayEndereco = listar();
		
		//comparando objetos
		for (Endereco endereco2 : arrayEndereco) {
			if(endereco2.getIdEndereco().equals(endereco.getIdEndereco()))
			{
				arrayEndereco.remove(endereco2);
				arrayEndereco.add(endereco);
				break;
			}
		}
		
		//limpando o arquivo
		try(BufferedWriter escrever1 = Files.newBufferedWriter(path, utf8))
		{
			escrever1.write(" ");
		}
		
		//escrevendo atualizações no arquivo
		for (Endereco endereco3 : arrayEndereco) 
		{
			try(BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND))
			{
				escrever.write(endereco3.getIdEndereco()+";"+endereco3.getRua()+ ";"+ endereco3.getBairro()+";"+ endereco3.getNumero()+";"+ endereco3.getCep()+";"+ endereco3.getComplemento()+";"+ endereco3.getCliente()+";"+ endereco3.getFuncionario()+";"+ endereco3.getFornecedor()+"\n");
			}
		}
		
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	}

	
	
	
	@Override
	public void remover(Integer idEndereco) throws IOException 
	{
		
	    ArrayList<Endereco> arrayEndereco = listar();
		
			for (Endereco endereco2 : arrayEndereco) {
				if(endereco2.getIdEndereco() == idEndereco){
					arrayEndereco.remove(endereco2);
					break;
			
					}else{JOptionPane.showMessageDialog(null, "ENDEREÇO INVÁLIDO OU INEXISTENTE!");}
				}
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8);) {
				escrever.write(" ");
			}
			JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
	}
		
		


	
	
	
	@Override
	public Endereco procurar(Integer idEndereco) throws Exception 
	{
		ArrayList<Endereco> arrayEndereco = listar();
		
		for (Endereco endereco2 : arrayEndereco) 
		{
			if(endereco2.getIdEndereco() == idEndereco)
			{
				JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
				return endereco2;
		
			}else{JOptionPane.showMessageDialog(null, "ENDEREÇO INVÁLIDO OU INEXISTENTE!");} 
		}
		
		return null;
		
     }
	
	
	
	
	
	@Override
	public boolean existir(Integer idEndereco) throws IOException {
		
	ArrayList<Endereco> arrayEndereco = listar();
		
		for (Endereco endereco2 : arrayEndereco) 
		{
			if(endereco2.getIdEndereco() == idEndereco)
			{
				JOptionPane.showMessageDialog(null, "Endereço existe!");
				return true;
		
			} 
		}
		JOptionPane.showMessageDialog(null, "Endereço não existe!");
			return false;
	}

	
	
	
	@Override
	public ArrayList<Endereco> listar() throws IOException 
	{
		
		ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();
		String linha = null;
		Integer index = 1;
		
		try {
			try (BufferedReader ler = Files.newBufferedReader(path, utf8)) {
				
				while ((linha = ler.readLine()) != null) {
					
					Object[] dados = linha.split(";");

					Endereco endereco = new Endereco(dados[1], dados[2], dados[3], dados[4], dados[5],dados[6], dados[7], dados[8], dados[9]);
					index++;
					arrayEndereco.add(endereco);
				}

			
			return null;
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arrayEndereco;
	
}

}















