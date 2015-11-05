package com.autofood.fachada;


import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;
import com.autofood.produto.ControladorProduto;
import com.autofood.produto.Produto;

public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorProduto controladorProduto;

	private Fachada() throws ClassNotFoundException {
		this.controladorCliente = new ControladorCliente();
		this.controladorProduto = new ControladorProduto();

	}
	

	public static Fachada getInstance() throws ClassNotFoundException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}
	
	// -------------------------------------------------------------------CLIENTE------------------------------------------------------------------

	public void cadastrarCliente(Cliente cliente) throws SQLException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) throws SQLException {
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

	public ArrayList<Cliente> listarCliente() throws SQLException {

		return controladorCliente.listar();
	}

	// -------------------------------------------------------------------PRODUTO------------------------------------------------------------------

	public void cadastra(Produto produto) {

		controladorProduto.cadastra(produto);

	}

	public void atualizar(Produto produto) {

		controladorProduto.atualizar(produto);

	}

	public void remover(Integer idProduto) {

		controladorProduto.remover(idProduto);

	}

	public Produto procurar(Integer idProduto) {

		return controladorProduto.procurar(idProduto);

	}

	public Boolean existi(Integer idPrdotudo) {

		return controladorProduto.existi(idPrdotudo);

	}

	public ArrayList<Produto> listar() {

		return controladorProduto.listar();

	}
}
