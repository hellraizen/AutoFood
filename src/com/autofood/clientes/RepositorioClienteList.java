package com.autofood.clientes;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class RepositorioClienteList implements IRepositorioCliente {

	ArrayList<Cliente> arrayListCliente;
	int index;

	public RepositorioClienteList() {
		arrayListCliente = new ArrayList<Cliente>();
		index = 1;
	}

	public void cadastrar(Cliente cliente) throws ClienteJaCadastradoException {
		if (existe(cliente.getCpf()))
			throw new ClienteJaCadastradoException();
		cliente.setCodigo(index);
		arrayListCliente.add(cliente);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Cliente cliente) throws ClienteNaoEncontradoException {
		int i = cliente.getCodigo();

		for (Cliente clientes : arrayListCliente) {
			if (i == clientes.getCodigo()) {
				arrayListCliente.remove(clientes);
				arrayListCliente.add(cliente);
				JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso");
			}
		}
		
	}

	public void remover(String cpf) throws ClienteNaoEncontradoException {
		for (Cliente cliente : arrayListCliente) {

			if (cliente.getCpf().equals(cpf)) {
				arrayListCliente.remove(cliente);
				JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");
			}

		}
		throw new ClienteNaoEncontradoException();
	}

	public Cliente procurar(String cpf) throws ClienteNaoEncontradoException {
		for (Cliente cliente : arrayListCliente) {

			if (cpf.equals(cliente.getCpf())) {
				
				return cliente;
			}

		}
		throw new ClienteNaoEncontradoException();
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
