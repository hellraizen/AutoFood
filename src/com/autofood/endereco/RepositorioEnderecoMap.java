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
		
		
		
	}

	@Override
	public Endereco procurar(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existir(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
