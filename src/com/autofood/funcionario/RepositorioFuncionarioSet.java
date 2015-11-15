package com.autofood.funcionario;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;


public class RepositorioFuncionarioSet implements IRepositorioFuncionario 
{

	HashSet<Funcionario> arrayFuncionarioSet;
	int index;
	
	public RepositorioFuncionarioSet() 
	{
		arrayFuncionarioSet = new HashSet<Funcionario>();
		index = 1;
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) 
	{
		if(existir(funcionario.getCpfFuncionario()))
		{
			funcionario.setIdFuncionario(index);
			arrayFuncionarioSet.add(funcionario);
			index++;
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}
	}

	
	
	@Override
	public void atualizar(Funcionario funcionario) 
	{
		int idF = funcionario.getIdFuncionario();
		
		for (Funcionario funcionarios : arrayFuncionarioSet) 
		{
			if(idF == funcionarios.getIdFuncionario())
			{
				arrayFuncionarioSet.remove(funcionarios);
			}
		}
		arrayFuncionarioSet.add(funcionario);
		JOptionPane.showMessageDialog(null, "Funcion�rio Atualizado com Sucesso");
	}

	
	
	@Override
	public void remover(String cpf) 
	{
		for (Funcionario funcionario : arrayFuncionarioSet) 
		{
			if(funcionario.getCpfFuncionario().equals(cpf))
			{
				arrayFuncionarioSet.remove(funcionario);
				JOptionPane.showMessageDialog(null, "Funcion�rio Removido com Sucesso");
			}
		}
		JOptionPane.showMessageDialog(null, "Funcion�rio N�o Encontrado!");
	}

	
	
	@Override
	public Funcionario procurar(String cpf) 
	{
		for (Funcionario funcionarios : arrayFuncionarioSet) 
		{
			if(cpf.equals(funcionarios.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcion�rio Encontrado!!");
				return funcionarios;
			}
		}
		JOptionPane.showMessageDialog(null, "Funcion�rio N�o Encontrado!!");
		return null;
	}

	
	
	@Override
	public boolean existir(String cpf) 
	{
		for (Funcionario funcionario : arrayFuncionarioSet) 
		{
			if(cpf.equals(funcionario.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcion�rio Existe!!");
				return true;
			}
		}
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() 
	{
		ArrayList<Funcionario> aFuncionario = new ArrayList<Funcionario>();
		
		for (Funcionario funcionario : arrayFuncionarioSet) 
		{
			aFuncionario.add(funcionario);
		}
		
		return aFuncionario;
	}
	
}
