package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException{
		repositorioCliente= new RepositorioClienteJdbc();
	}

	public void cadastrar(Cliente cliente) throws SQLException {
		repositorioCliente.cadastrar(cliente);
	}

	public void atualizar(Cliente cliente) {
		repositorioCliente.atualizar(cliente);

	}

	public void remover(String cpf) {
		repositorioCliente.remover(cpf);

	}

	public Cliente procurar(String cpf) {
  
		return repositorioCliente.procurar(cpf);
	}

	public boolean existe(String cpf) {
		
		return repositorioCliente.existe(cpf);
	}

	public ArrayList<Cliente> listar() {
		
		return repositorioCliente.listar();
	}

}
