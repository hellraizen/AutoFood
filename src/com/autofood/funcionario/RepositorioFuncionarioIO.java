package com.autofood.funcionario;

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

public class RepositorioFuncionarioIO implements IRepositorioFuncionario {

	Path path = Paths.get("/AutoFood/files/repositorioCliente.txt");
	
	Charset utf8 = StandardCharsets.UTF_8;
	Integer index;

	public RepositorioFuncionarioIO() throws IOException 
	{
		index = 1;
		Files.createDirectories(path.getParent());
	}
	
	
	
	@Override
	public void cadastrar(Funcionario funcionario) throws IOException 
	{
		
		if(existir(funcionario.getCpfFuncionario()) == false){
		
		funcionario.setIdFuncionario(index);
		BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND );
		
		escrever.write(funcionario.getIdFuncionario()+";"+funcionario.getNomeFuncionario()+";"+funcionario.getCpfFuncionario()+";"
		+funcionario.getEnderecoFuncionario()+";"+funcionario.getDataNascimentoFuncionario()+";"+funcionario.getSexoFuncionario()+";"
				+funcionario.getTelefoneFuncionario()+";"+funcionario.getEmailFuncionario()+";"+funcionario.getTipoFuncionario()+";"+funcionario.getLogin()+";"+funcionario.getSenha());

		index ++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}else{JOptionPane.showMessageDialog(null, "Funcionario já Existe!");}
	}

	
	
	@Override
	public void atualizar(Funcionario funcionario) throws IOException 
	{
		ArrayList<Funcionario> arrayFuncionario = listar();
		
		for (Funcionario funcionario2 : arrayFuncionario) {
			if(funcionario2.getIdFuncionario().equals(funcionario.getIdFuncionario()))
			{
				arrayFuncionario.remove(funcionario2);
				arrayFuncionario.add(funcionario);
				break;
			}
		}
		
		try(BufferedWriter escrever = Files.newBufferedWriter(path, utf8))
		{ escrever.write(" "); }
		
		for (Funcionario funcionario3 : arrayFuncionario) {
		// se funcionario3 == funcionario(se esse não pegar! ->)
			try(BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND))
				{
				escrever.write(funcionario3.getIdFuncionario()+";"+funcionario3.getNomeFuncionario()+";"+funcionario3.getCpfFuncionario()+";"
						+funcionario3.getEnderecoFuncionario()+";"+funcionario3.getDataNascimentoFuncionario()+";"+funcionario3.getSexoFuncionario()+";"
								+funcionario3.getTelefoneFuncionario()+";"+funcionario3.getEmailFuncionario()+";"+funcionario3.getTipoFuncionario()+";"+funcionario3.getLogin()+";"+funcionario3.getSenha());
				}
		}
		JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso");
	}

	
	
	@Override
	public void remover(String cpf) throws IOException 
	{
		ArrayList<Funcionario> arrayFuncionario =  listar();
		
			for (Funcionario funcionario : arrayFuncionario) {
				if(funcionario.getCpfFuncionario().equals(cpf))
				{
					arrayFuncionario.remove(funcionario);
					break;
				}else{JOptionPane.showMessageDialog(null, "CPF INVÁLIDO OU INEXISTENTE!");}
			}
		try(BufferedWriter escrever = Files.newBufferedWriter(path, utf8))
		{ escrever.write(" "); }
		JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
	}

	
	
	@Override
	public Funcionario procurar(String cpf) throws IOException 
	{
		ArrayList<Funcionario> arrayFuncionario = listar();
		
		for (Funcionario funcionario2 : arrayFuncionario) 
		{
			if(funcionario2.getCpfFuncionario().equals(cpf))
			{
				JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
				return funcionario2;
			}else{JOptionPane.showMessageDialog(null, "CPF INVÁLIDO OU INEXISTENTE!");}
		}
		
		return null;
	}

	
	
	@Override // SE NÃO RODAR, RETIRAR OBJETOS DO ARQUIVO E FAZER VERIFICAÇÃO
	public boolean existir(String cpf) throws IOException {
		
		ArrayList<Funcionario> arrayFuncionario = listar();
		
		for (Funcionario funcionario : arrayFuncionario) 
		{
			if(funcionario.getCpfFuncionario().equals(cpf))
			{
				JOptionPane.showMessageDialog(null, "Funcionário existe!");
				return true;
			}else{		JOptionPane.showMessageDialog(null, "CPF INVÁLIDO OU INEXISTENTE!");}
		}
		
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() throws IOException 
	{
		
		ArrayList<Funcionario> arrayFuncionario = new ArrayList<Funcionario>();
		
		String linha = null;
		Integer index = 1;
		
		try(BufferedReader ler = Files.newBufferedReader(path,utf8))
		{
			while(   ( linha = ler.readLine() )  !=    null )
			{
				Object[] dados = linha.split(";");
				
				//Funcionario funcionario = new Funcionario(dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], dados[9], dados[10], dados[11]);
				index++;
				//arrayFuncionario.add(funcionario);
			}
		}
		
		return arrayFuncionario;
	}

}












