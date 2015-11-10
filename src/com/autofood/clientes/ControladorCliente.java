package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException{
		repositorioCliente= new RepositorioClienteJdbc();
		//repositorioCliente= new RepositorioCliente();
	}

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException {
		repositorioCliente.cadastrar(cliente);
	}

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		repositorioCliente.atualizar(cliente);

	}

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException {
		repositorioCliente.remover(cpf);

	}

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException {
  
		return repositorioCliente.procurar(cpf);
	}

	public boolean existe(String cpf) throws SQLException {
		
		return repositorioCliente.existe(cpf);
	}

	public ArrayList<Cliente> listar() throws SQLException {
		
		return repositorioCliente.listar();
	}

}
