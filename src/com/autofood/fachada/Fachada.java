package com.autofood.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;

public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;

	private Fachada() throws ClassNotFoundException {
		this.controladorCliente = new ControladorCliente();

	}

	public static Fachada getInstance() throws ClassNotFoundException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarCliente(Cliente cliente) throws SQLException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) {
		controladorCliente.atualizar(cliente);

	}

	public void removerCliente(String cpf) {
		controladorCliente.remover(cpf);

	}

	public Cliente procurarCliente(String cpf) {
		
		return controladorCliente.procurar(cpf);
	}

	public boolean existeCliente(String cpf) {
		
		return controladorCliente.existe(cpf);
	}

	public ArrayList<Cliente> listarCliente() {
		
		return controladorCliente.listar();
	}
}
