package com.autofood.endereco;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class RepositorioEnderecoMap implements IRepositorioEndereco 
{
	
	HashMap<Integer, Endereco> arrayEnderecoMap;
	Integer index;

	@Override
	public void cadastrar(Endereco endereco) 
	{
		endereco.setIdEndereco(index);
		arrayEnderecoMap.put(index, endereco);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void atualizar(Endereco endereco) {
		
		Integer i = endereco.getIdEndereco();
		
		arrayEnderecoMap.put(i, endereco);
		
		JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		
	}

	@Override
	public void remover(Integer codigoEndereco) {
		
		for(int i = 1; i < index; i++)
		{
			Endereco endereco = arrayEnderecoMap.get(i);
			
			if(codigoEndereco == endereco.getIdEndereco())
			{
				arrayEnderecoMap.remove(endereco);
				
			}
				
		}
		
		JOptionPane.showInternalMessageDialog(null, "Endere�o removido com sucesso!!");
	}

	
	
	
	
	
	
	@Override
	public Endereco procurar(Integer codigoEndereco) {
	
		for(int i = 1; i < index; i++)
		{
			Endereco endereco = arrayEnderecoMap.get(i);
			if(codigoEndereco == endereco.getIdEndereco())
			{
				return endereco;
			}
		}
		return null;
	}

	
	
	
	
	@Override
	public boolean existir(Integer codigoEndereco) {
		
		for(int i= 1; i < index; i++)
		{
			Endereco endereco = arrayEnderecoMap.get(i);
			
			if(codigoEndereco == endereco.getIdEndereco())
			{
				return true;
			}
		}		
		return false;
	}

	
	
	
	
	@Override
	public ArrayList<Endereco> listar() {
		
		ArrayList<Endereco> aEndereco = new ArrayList<Endereco>();
		
		for(int i = 1; i < index; i++)
		{
			Endereco end = arrayEnderecoMap.get(i);
			aEndereco.add(end);
		}		
		return aEndereco;
	}
	
}
