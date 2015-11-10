package com.autofood.fachada;

import java.sql.SQLException;
import java.util.ArrayList;
import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;
import com.autofood.estoque.ControladorEstoque;
import com.autofood.estoque.Estoque;
import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;
import com.autofood.produto.ControladorProduto;
import com.autofood.produto.Produto;

public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorProduto controladorProduto;
	private ControladorEstoque controladorEstoque;

	private Fachada() throws ClassNotFoundException {
		this.controladorCliente = new ControladorCliente();
		this.controladorProduto = new ControladorProduto();
		this.controladorEstoque = new ControladorEstoque();

	}

	public static Fachada getInstance() throws ClassNotFoundException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// -------------------------------------------------------------------CLIENTE------------------------------------------------------------------

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) throws SQLException {
		controladorCliente.atualizar(cliente);

	}

	public void removerCliente(String cpf) throws SQLException {
		controladorCliente.remover(cpf);

	}

	public Cliente procurarCliente(String cpf) throws SQLException {

		return controladorCliente.procurar(cpf);
	}

	public boolean existeCliente(String cpf) throws SQLException {

		return controladorCliente.existe(cpf);
	}

	public ArrayList<Cliente> listarCliente() throws SQLException {

		return controladorCliente.listar();
	}

	// -------------------------------------------------------------------PRODUTO------------------------------------------------------------------

	public void cadastraProduto(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException {

		controladorProduto.cadastra(produto);

	}

	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException {

		controladorProduto.atualizar(produto);

	}

	public void removerProduto(Integer idProduto) throws ProdutoNaoEncontradoException {

		controladorProduto.remover(idProduto);

	}

	public Produto procurarProduto(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		return controladorProduto.procurar(idProduto);

	}

	public Boolean existiProduto(Integer idPrdotudo) {

		return controladorProduto.existi(idPrdotudo);

	}

	public ArrayList<Produto> listarProduto() {

		return controladorProduto.listar();

	}
	
	// -------------------------------------------------------------------ESTOQUE------------------------------------------------------------------


	public void cadastraEstoque(Estoque estoque) throws com.autofood.exceçõesEstoque.NomeVazioException, ProdutoJaCadastradoEstoqueException {
		
		controladorEstoque.cadastra(estoque);

	}

	public void atualizarEstoque(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException {
		
		controladorEstoque.atualizar(estoque);

	}

	public void removerEstoque(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {
		
		controladorEstoque.remover(idEstoqueProduto);
		
	}

	public Estoque procurarEstoque(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException {

		return controladorEstoque.procurar(idEstoqueProduto);
	}

	public Boolean existiEstoque(Integer idEstoqueProduto) {

		return controladorEstoque.existi(idEstoqueProduto);
	}

	public ArrayList<Estoque> listarEstoque() {

		return controladorEstoque.listar();
	}
	
}
