package com.autofood.funcionario;

import java.util.ArrayList;

import com.autofood.clientes.Cliente;

public class ControladorFuncionario {

	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() 
	{
		repositorioFuncionario = new RepositorioFuncionarioBd();
		//repositorioFuncionario = new RepositorioFuncionarioList();
		//repositorioFuncionario = new RepositorioFuncionarioMap();
		//repositorioFuncionario = new RepositorioFuncionarioSet();
		//repositorioFuncionario = new RepositorioFuncionarioIO();
		
	}

	public void cadastrar(Funcionario funcionario) 
	{
		repositorioFuncionario.cadastrar(funcionario);
	}

	
	public void atualizar(Funcionario funcionario)
	{
		repositorioFuncionario.atualizar(funcionario);
	}

	
	public void remover(String cpf) 
	{
		repositorioFuncionario.remover(cpf);
	}

	
	public Funcionario procurar(String cpf) 
	{
		return repositorioFuncionario.procurar(cpf);
	}

	
	public boolean existir(String cpf) 
	{
		return repositorioFuncionario.existir(cpf);
	}

	
	public ArrayList<Funcionario> listar() 
	{
		return repositorioFuncionario.listar();
	}

}
