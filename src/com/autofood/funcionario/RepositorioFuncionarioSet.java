package com.autofood.funcionario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
		JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso");
	}

	
	
	@Override
	public void remover(String cpf) 
	{
		for (Funcionario funcionario : arrayFuncionarioSet) 
		{
			if(funcionario.getCpfFuncionario().equals(cpf))
			{
				arrayFuncionarioSet.remove(funcionario);
				JOptionPane.showMessageDialog(null, "Funcionário Removido com Sucesso");
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Encontrado!");
	}

	
	
	@Override
	public Funcionario procurar(String cpf) 
	{
		for (Funcionario funcionarios : arrayFuncionarioSet) 
		{
			if(cpf.equals(funcionarios.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcionário Encontrado!!");
				return funcionarios;
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Encontrado!!");
		return null;
	}

	
	
	@Override
	public boolean existir(String cpf) 
	{
		for (Funcionario funcionario : arrayFuncionarioSet) 
		{
			if(cpf.equals(funcionario.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcionário Existe!!");
				return true;
			}
		}
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() 
	{
		
		ArrayList<Funcionario> aFuncionario = new ArrayList<Funcionario>();
		
		for (int i = 1; i < index; i++) 
		{
			Funcionario funcionario = ((List<Funcionario>) arrayFuncionarioSet).get(i);
			aFuncionario.add(funcionario);
		}
		
		return aFuncionario;
	}
	
}


