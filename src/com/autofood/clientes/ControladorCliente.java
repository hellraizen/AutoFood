package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException{
		repositorioCliente= new RepositorioClienteJdbc();
	}

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException {
		repositorioCliente.cadastrar(cliente);
	}

	public void atualizar(Cliente cliente) throws SQLException {
		repositorioCliente.atualizar(cliente);

	}

	public void remover(String cpf) throws SQLException {
		repositorioCliente.remover(cpf);

	}

	public Cliente procurar(String cpf) throws SQLException {
  
		return repositorioCliente.procurar(cpf);
	}

	public boolean existe(String cpf) throws SQLException {
		
		return repositorioCliente.existe(cpf);
	}

	public ArrayList<Cliente> listar() throws SQLException {
		
		return repositorioCliente.listar();
	}

}
