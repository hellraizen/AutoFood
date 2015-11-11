package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class RepositorioClienteSet implements IRepositorioCliente {

	HashSet<Cliente> arrayClienteSet;
	int index;

	public RepositorioClienteSet() {

		arrayClienteSet = new HashSet<Cliente>();
		index = 1;
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException {

		if (existe(cliente.getCpf()))
			throw new ClienteJaCadastradoException();
		cliente.setCodigo(index);
		arrayClienteSet.add(cliente);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {

		int i = cliente.getCodigo();

		for (Cliente clientes : arrayClienteSet) {
			if (i == clientes.getCodigo()) {
				arrayClienteSet.remove(clientes);
			}
		}
		arrayClienteSet.add(cliente);
		JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso");
	}

	@Override
	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException {
		for (Cliente cliente : arrayClienteSet) {

			if (cliente.getCpf().equals(cpf)) {
				arrayClienteSet.remove(cliente);
				JOptionPane.showMessageDialog(null, "Cliente Removido com Sucesso");
			}

		}
		throw new ClienteNaoEncontradoException();
	}

	@Override
	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException {
		for (Cliente cliente : arrayClienteSet) {

			if (cpf.equals(cliente.getCpf())) {
				JOptionPane.showMessageDialog(null, "Cliente Encontrado com Sucesso");
				return cliente;

			}

		}
		throw new ClienteNaoEncontradoException();
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		for (Cliente cliente : arrayClienteSet) {
			if (cpf.equals(cliente.getCpf())) {
				return true;
			}

		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {
		ArrayList<Cliente> array = new ArrayList<Cliente>();
		for (Cliente cliente : arrayClienteSet) {
			array.add(cliente);
		}
		return array;
	}

}
