package com.autofood.endereco;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class RepositorioEnderecoSet implements IRepositorioEndereco 
{
	HashSet<Endereco> arrayEnderecoSet;
	int index;
	
	public RepositorioEnderecoSet() {
		this.arrayEnderecoSet = new HashSet<Endereco>();
		index = 1;
	}

	@Override
	public void cadastrar(Endereco endereco) {
		
		endereco.setIdEndereco(index);
		arrayEnderecoSet.add(endereco);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
	}

	@Override
	public void atualizar(Endereco endereco) {
		
		int i = endereco.getIdEndereco();
		
		for (Endereco endereco2 : arrayEnderecoSet) 
		{
			if(i == endereco.getIdEndereco())
			{
				arrayEnderecoSet.remove(endereco2);
				arrayEnderecoSet.add(endereco);
				JOptionPane.showMessageDialog(null, "Endereço Atualizado com Sucesso");
			}
		}
		
	}

	@Override
	public void remover(Integer codigoEndereco) {
		
		for (Endereco endereco : arrayEnderecoSet) 
		{
			if(codigoEndereco == endereco.getIdEndereco())
			{
				arrayEnderecoSet.remove(endereco);
				JOptionPane.showMessageDialog(null, "Endereço Removido com Sucesso!");
			}
		}
	}

	@Override
	public Endereco procurar(Integer codigoEndereco) {
		
		for (Endereco endereco : arrayEnderecoSet) 
		{
			if(endereco.getIdEndereco() == codigoEndereco)
			{
				return endereco;
			}
		}
		JOptionPane.showInternalMessageDialog(null, "ENDEREÇO NÃO ENCONTRADO!");
		return null;
	}

	@Override
	public boolean existir(Integer codigoEndereco) {
		
		for (Endereco endereco : arrayEnderecoSet) 
		{
			if(endereco.getIdEndereco() == codigoEndereco)
			{
				JOptionPane.showInternalMessageDialog(null, "Endereco existe!!");
				return true;
			}
		}
		JOptionPane.showInternalMessageDialog(null, "Endereco não existe!!");
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() {
		
		ArrayList<Endereco> array = new ArrayList<>();
 		
		for (Endereco endereco : array) 
		{
			array.add(endereco);
		}
		
		return array;
	}
	
}
