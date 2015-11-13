package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JOptionPane;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public class RepositorioClienteMap implements IRepositorioCliente {

	HashMap<Integer, Cliente> arrayClienteMap;
	Integer index;

	public RepositorioClienteMap() {
		arrayClienteMap = new HashMap<Integer, Cliente>();
		index = 1;
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException {
	
		if (existe(cliente.getCpf()))throw new ClienteJaCadastradoException();
		
		cliente.setCodigo(index);
		arrayClienteMap.put(index, cliente);
		index++;
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {

		Integer i = cliente.getCodigo();
		arrayClienteMap.put(i, cliente);
		JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		
	}

	@Override
	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException {

		for (int i = 1; i < index; i++) {
			Cliente cliente = arrayClienteMap.get(i);
			if (cpf.equals(cliente.getCpf())) {
				arrayClienteMap.remove(cliente);
				JOptionPane.showMessageDialog(null, "Cadastro Removido com sucesso");
			}
		}

	}

	@Override
	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException {
		for (int i = 1; i < index; i++) {
			Cliente cliente = arrayClienteMap.get(i);
			if (cpf.equals(cliente.getCpf())) {
				return cliente;
			}
		}
		throw new ClienteNaoEncontradoException();

	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		for (int i = 1; i < index; i++) {
			Cliente cliente = arrayClienteMap.get(i);
			if (cpf.equals(cliente.getCpf())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {
		ArrayList<Cliente> arrayListLocal = new ArrayList<Cliente>();
		for (int i = 1; i < index; i++) {
			Cliente cliente = arrayClienteMap.get(i);
			arrayListLocal.add(cliente);

		}
		return arrayListLocal;
	}

}
