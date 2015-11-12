package com.autofood.endereco;

import java.util.ArrayList;

import com.autofood.exceçõesEndereço.EnderecoJaCadastradoException;

public class RepositorioEnderecoList implements IRepositorioEndereco {

	ArrayList<Endereco> arrayListEndereco;
	int index;

	public RepositorioEnderecoList() {

		this.arrayListEndereco = new ArrayList<Endereco>();
		this.index = 1;
	}

	@Override
	public void cadastrar(Endereco endereco) throws EnderecoJaCadastradoException {
		if(existir(endereco.getIdEndereco())) throw new EnderecoJaCadastradoException();
		{}
	}

	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remover(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		return false;
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
