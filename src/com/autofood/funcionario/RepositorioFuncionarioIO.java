package com.autofood.funcionario;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class RepositorioFuncionarioIO implements IRepositorioFuncionario {

	
	
	Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioio.txt");
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
		funcionario.setIdFuncionario(index);
		BufferedWriter escrever = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND );

	}

	
	
	@Override
	public void atualizar(Funcionario funcionario) {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
	}

	
	
	@Override
	public Funcionario procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public boolean existir(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
