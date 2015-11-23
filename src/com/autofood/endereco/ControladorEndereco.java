package com.autofood.endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.autofood.exceçõesEndereço.EnderecoJaCadastradoException;

public class ControladorEndereco {
	private IRepositorioEndereco repositorioEndereco;

	public ControladorEndereco() throws ClassNotFoundException {

		this.repositorioEndereco = new RepositorioEnderecoBd();
		//this.repositorioEndereco = new RepositorioEnderecoList();
		// this.repositorioEndereco = new RepositorioEnderecoSet();
		// this.repositorioEndereco = new RepositorioEnderecoMap();
		//repositorioEndereco = new RepositorioEnderecoIO();
	}

	public void cadastrar(Endereco endereco) throws SQLException, IOException  {
		repositorioEndereco.cadastrar(endereco);

	}

	public void atualizar(Endereco endereco) throws SQLException, IOException {
		repositorioEndereco.atualizar(endereco);

	}

	public void remover(Integer idEndereco) throws SQLException, IOException {
		repositorioEndereco.remover(idEndereco);
	}

	public Endereco procurar(Integer idEndereco) throws Exception {
		return repositorioEndereco.procurar(idEndereco);
	}

	public boolean existir(Integer idEndereco) throws SQLException, IOException {
		return repositorioEndereco.existir(idEndereco);
	}

	public ArrayList<Endereco> listar() throws SQLException, IOException {
		return repositorioEndereco.listar();
	}

}
