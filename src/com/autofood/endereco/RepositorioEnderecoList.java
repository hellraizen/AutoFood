package com.autofood.endereco;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioEnderecoList implements IRepositorioEndereco {

	ArrayList<Endereco> arrayListEndereco;
	int index;

	public RepositorioEnderecoList() {

		this.arrayListEndereco = new ArrayList<Endereco>();
		this.index = 1;
	}

	@Override
	public void cadastrar(Endereco endereco) {
		endereco.setIdEndereco(index);
		arrayListEndereco.add(endereco);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
	}

	@Override
	public void atualizar(Endereco endereco) {

		for (Endereco endereco1 : arrayListEndereco) {
			
			if (endereco.getIdEndereco() == endereco1.getIdEndereco()) {
				
				arrayListEndereco.remove(endereco1);
				arrayListEndereco.add(endereco);
				JOptionPane.showMessageDialog(null, "Endereço Atualizado com Sucesso");
			}
		}

	}

	@Override
	public void remover(Integer codigoEndereco) {

		for (Endereco endereco1 : arrayListEndereco) {

			if (endereco1.getIdEndereco() == codigoEndereco) {
				arrayListEndereco.remove(endereco1);
				JOptionPane.showMessageDialog(null, "Endereço Removido com Sucesso");
			}

		}
	}

	@Override
	public Endereco procurar(Integer codigoEndereco) {
		
		for (Endereco endereco : arrayListEndereco) {
			
			if (endereco.getIdEndereco() == codigoEndereco) {
				
				return endereco;
			}
		}

		return null;
	}

	@Override
	public boolean existir(Integer codigoEndereco) {

		for (Endereco endereco : arrayListEndereco) {
			if (endereco.getIdEndereco() == codigoEndereco) {

				JOptionPane.showInternalMessageDialog(null, "Endereco existe!");
				return true;
			}
			JOptionPane.showInternalMessageDialog(null, "Endereco não existe!!");
		}return false;

	}

	@Override
	public ArrayList<Endereco> listar() {

		return arrayListEndereco;
	}

}
