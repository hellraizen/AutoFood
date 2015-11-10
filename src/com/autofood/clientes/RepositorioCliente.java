package com.autofood.clientes;

import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;

public class RepositorioCliente implements IRepositorioCliente {

	ArrayList<Cliente> arrayListCliente;
	int index;

	public RepositorioCliente() {
		arrayListCliente = new ArrayList<Cliente>();
		index = 1;
	}

	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if(existe(cliente.getCpf())) throw new ClienteJaCadastradoException();
		cliente.setCodigo(index);
		arrayListCliente.add(cliente);
		index++;

	}

	public void atualizar(Cliente cliente) {

	}

	public void remover(String cpf) {

	}

	public Cliente procurar(String cpf) {
		for (Cliente cliente : arrayListCliente) {
			if (cpf.equals(cliente.getCpf())) {
				return cliente;
			}
		}
		return null;
	}

	public boolean existe(String cpf) {
		for (Cliente cliente : arrayListCliente) {
			if (cpf.equals(cliente.getCpf())) {
				return true;
			}

		}
		return false;
	}

	public ArrayList<Cliente> listar() {

		return arrayListCliente;
	}

}
