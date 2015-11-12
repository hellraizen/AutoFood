package com.autofood.endereco;

import java.util.ArrayList;

public class ControladorEndereco {
	private IRepositorioEndereco repositorioEndereco;

	public ControladorEndereco() {

		// this.repositorioEndereco = new RepositorioEnderecoBd();
		this.repositorioEndereco = new RepositorioEnderecoList();
		// this.repositorioEndereco = new RepositorioEnderecoSet();
		// this.repositorioEndereco = new RepositorioEnderecoMap();

	}

	public void cadastrar(Endereco endereco) {
		repositorioEndereco.cadastrar(endereco);

	}

	public void atualizar(Endereco endereco) {
		repositorioEndereco.atualizar(endereco);

	}

	public boolean remover(Integer codigoEndereco) {
		return repositorioEndereco.remover(codigoEndereco);
	}

	public Endereco procurar(Integer codigoEndereco) {
		return repositorioEndereco.procurar(codigoEndereco);
	}

	public boolean existir(Integer codigoEndereco) {
		return repositorioEndereco.existir(codigoEndereco);
	}

	public ArrayList<Endereco> listar() {
		return repositorioEndereco.listar();
	}

}
