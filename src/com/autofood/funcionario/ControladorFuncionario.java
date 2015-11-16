package com.autofood.funcionario;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.clientes.Cliente;

public class ControladorFuncionario {

	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario() throws ClassNotFoundException 
	{
		repositorioFuncionario = new RepositorioFuncionarioBd();
		//repositorioFuncionario = new RepositorioFuncionarioList();
		//repositorioFuncionario = new RepositorioFuncionarioMap();
		//repositorioFuncionario = new RepositorioFuncionarioSet();
		//repositorioFuncionario = new RepositorioFuncionarioIO();
		
	}

	public void cadastrar(Funcionario funcionario) throws SQLException 
	{
		repositorioFuncionario.cadastrar(funcionario);
	}

	
	public void atualizar(Funcionario funcionario) throws SQLException
	{
		repositorioFuncionario.atualizar(funcionario);
	}

	
	public void remover(String cpf) throws SQLException 
	{
		repositorioFuncionario.remover(cpf);
	}

	
	public Funcionario procurar(String cpf) throws SQLException 
	{
		return repositorioFuncionario.procurar(cpf);
	}

	
	public boolean existir(String cpf) throws SQLException 
	{
		return repositorioFuncionario.existir(cpf);
	}

	
	public ArrayList<Funcionario> listar() throws SQLException 
	{
		return repositorioFuncionario.listar();
	}

}
