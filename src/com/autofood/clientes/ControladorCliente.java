package com.autofood.clientes;

import java.util.ArrayList;

public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente(){
		repositorioCliente= new RepositorioCliente();
	}

	public void cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void remover(String cpf) {
		// TODO Auto-generated method stub

	}

	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
