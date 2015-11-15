package com.autofood.funcionario;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class RepositorioFuncionarioMap implements IRepositorioFuncionario{

	HashMap<Integer, Funcionario> arrayFuncionarioMap;
	int index;
	
	public RepositorioFuncionarioMap() 
	{
		arrayFuncionarioMap = new HashMap<Integer, Funcionario>();
		index = 1;
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) 
	{	
		if(existir(funcionario.getCpfFuncionario()))
		{
			funcionario.setIdFuncionario(index);
			arrayFuncionarioMap.put(index, funcionario);
			index++;
			JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso!!");
		}
		
	}

	@Override
	public void atualizar(Funcionario funcionario) 
	{
		if(existir(funcionario.getCpfFuncionario()) == true)
		{
			Integer f = funcionario.getIdFuncionario();
				arrayFuncionarioMap.put(f, funcionario);
					JOptionPane.showMessageDialog(null, "Funcionário Atualizado com Sucesso!!");
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Encontrado!!");
	}

	
	
	@Override
	public void remover(String cpf) 
	{
		for(int i = 1; i < index; i++)
		{
			Funcionario funcionarios = arrayFuncionarioMap.get(i);
			if(cpf.equals(funcionarios.getCpfFuncionario()))
			{
				arrayFuncionarioMap.remove(funcionarios);
				JOptionPane.showMessageDialog(null, "Funcionário Removido com Sucesso!!");
			}
			
		}
	}


	
	@Override
	public Funcionario procurar(String cpf) 
	{
		for(int i = 1; i < index; i++)
		{
			Funcionario funcionarios = arrayFuncionarioMap.get(i);
			if(cpf.equals(funcionarios.getCpfFuncionario()))
			{
				return funcionarios;
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Encontrado!!");
		return null;
	}


	
	@Override
	public boolean existir(String cpf) 
	{
		for(int i = 1; i < index; i++)
		{
			Funcionario funcionarios = arrayFuncionarioMap.get(i);
			
			if(cpf.equals(funcionarios.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcionário Existe!!");
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Existe!!");
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() 
	{
		ArrayList<Funcionario> aFunc = new ArrayList<Funcionario>();
		
		for(int i = 1; i < index; i++)
		{
			Funcionario funcionarios = arrayFuncionarioMap.get(i);
			aFunc.add(funcionarios);
		}
		
		return aFunc;
	}

	
	
}
