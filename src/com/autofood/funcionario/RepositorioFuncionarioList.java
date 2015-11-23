package com.autofood.funcionario;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioFuncionarioList implements IRepositorioFuncionario
{
	
	ArrayList<Funcionario> arrayListFuncionario;
	int index;
	
	
	public RepositorioFuncionarioList() 
	{
		arrayListFuncionario = new ArrayList<Funcionario>();
		index  = 1;
	}

	
	
	@Override
	public void cadastrar(Funcionario funcionario) 
	{
		if(!existir(funcionario.getCpfFuncionario()))
		{
			funcionario.setIdFuncionario(index);
			arrayListFuncionario.add(funcionario);
			index++;
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}
	}


	
	@Override
	public void atualizar(Funcionario funcionario) 
	{
		int idF = funcionario.getIdFuncionario();
		
		for (Funcionario funcionarios : arrayListFuncionario) 
		{
			if(idF == funcionarios.getIdFuncionario())
			{
				arrayListFuncionario.remove(funcionarios);
				arrayListFuncionario.add(funcionario);
				JOptionPane.showMessageDialog(null, "Funcionario Atualizado com Sucesso");
			}
		}
	}

	
	
	@Override
	public void remover(String cpf) 
	{
		for (Funcionario funcionario : arrayListFuncionario) 
		{
			if(cpf.equals(funcionario.getCpfFuncionario()))
			{
				arrayListFuncionario.remove(funcionario);
				JOptionPane.showMessageDialog(null, "Funcionário Removido com Sucesso");
			}
		}
	}

	
	
	@Override
	public Funcionario procurar(String cpf) 
	{
		for (Funcionario funcionario : arrayListFuncionario) 
		{
			if(cpf.equals(funcionario.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcionário Encontrado com Sucesso");
				return funcionario;
			}
		}
		JOptionPane.showMessageDialog(null, "Funcionário não Encontrado!!");
		return null;
	}

	
	
	@Override
	public boolean existir(String cpf) 
	{
		for (Funcionario funcionario : arrayListFuncionario) 
		{
			if(cpf.equals(funcionario.getCpfFuncionario()))
			{
				JOptionPane.showMessageDialog(null, "Funcionário Existe!!    :)");
				return true;
			}
		}
		return false;
	}

	
	
	@Override
	public ArrayList<Funcionario> listar() 
	{
		return arrayListFuncionario;
	}
	
}
