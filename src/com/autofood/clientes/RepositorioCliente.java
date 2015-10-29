package com.autofood.clientes;

import java.util.ArrayList;

public class RepositorioCliente implements IRepositorioCliente{
	
	ArrayList<Cliente> arrayListCliente;
	int index;
	public RepositorioCliente(){
		arrayListCliente = new <Cliente> ArrayList();
		index=1;
	}
	
	
	@Override
	public void cadastrar(Cliente cliente) {
		cliente.setCodigo(index);
		arrayListCliente.add(cliente);
		index++;
		
	}

	@Override
	public void atualizar(Cliente cliente) {
		
		
	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		for (Cliente cliente : arrayListCliente) {
			System.out.println(cliente.toString());
		}
		
		return arrayListCliente;
	}

}
