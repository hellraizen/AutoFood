package com.autofood.fachada;

import java.util.ArrayList;

import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;

public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;

	private Fachada() {
		this.controladorCliente = new ControladorCliente();

	}

	public static Fachada getInstance() {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	public void cadastrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void atualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void removerCliente(String cpf) {
		// TODO Auto-generated method stub

	}

	public Cliente procurarCliente(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existeCliente(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return null;
	}
}
