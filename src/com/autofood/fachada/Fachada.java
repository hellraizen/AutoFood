package com.autofood.fachada;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;
import com.autofood.comanda.Comanda;
import com.autofood.comanda.ControladorComanda;
import com.autofood.endereco.ControladorEndereco;
import com.autofood.endereco.Endereco;
import com.autofood.estoque.ControladorEstoque;
import com.autofood.estoque.Estoque;
import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;
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
	private ControladorEndereco controladorEndereco;
	private ControladorComanda controladorComanda;

	private Fachada() throws ClassNotFoundException, IOException {
		this.controladorCliente = new ControladorCliente();
		this.controladorProduto = new ControladorProduto();
		this.controladorEstoque = new ControladorEstoque();
		this.controladorEndereco = new ControladorEndereco();
		this.controladorComanda = new ControladorComanda();

	}

	public static Fachada getInstance() throws ClassNotFoundException, IOException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// -------------------------------------------------------------------CLIENTE------------------------------------------------------------------

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException {
		controladorCliente.atualizar(cliente);

	}

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException {
		controladorCliente.remover(cpf);

	}

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException {

		return controladorCliente.procurar(cpf);
	}

	public boolean existeCliente(String cpf) throws SQLException {

		return controladorCliente.existe(cpf);
	}

	public ArrayList<Cliente> listarCliente() throws SQLException, IOException {

		return controladorCliente.listar();
	}

	// -------------------------------------------------------------------PRODUTO------------------------------------------------------------------

	public void cadastraProduto(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException, SQLException {

		controladorProduto.cadastra(produto);

	}

	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException, SQLException {

		controladorProduto.atualizar(produto);

	}

	public void removerProduto(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException {

		controladorProduto.remover(idProduto);

	}

	public Produto procurarProduto(Integer idProduto)
			throws ProdutoNaoEncontradoException, SQLException {

		return controladorProduto.procurar(idProduto);

	}

	public Boolean existiProduto(Integer idPrdotudo) {

		return controladorProduto.existi(idPrdotudo);

	}

	public ArrayList<Produto> listarProduto() throws SQLException {

		return controladorProduto.listar();

	}
	
	// -------------------------------------------------------------------ESTOQUE------------------------------------------------------------------


	public void cadastraEstoque(Estoque estoque) throws com.autofood.exceçõesEstoque.NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException {
		
		controladorEstoque.cadastra(estoque);

	}

	public void atualizarEstoque(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException, SQLException {
		
		controladorEstoque.atualizar(estoque);

	}

	public void removerEstoque(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {
		
		controladorEstoque.remover(idEstoqueProduto);
		
	}

	public Estoque procurarEstoque(Integer idEstoqueProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException {

		return controladorEstoque.procurar(idEstoqueProduto);
	}

	public Boolean existiEstoque(Integer idEstoqueProduto) {

		return controladorEstoque.existi(idEstoqueProduto);
	}

	public ArrayList<Estoque> listarEstoque() throws SQLException {

		return controladorEstoque.listar();
	}
	// -------------------------------------------------------------------ENDEREÇO------------------------------------------------------------------
	
	public void cadastrarEndereco(Endereco endereco) {
		controladorEndereco.cadastrar(endereco);
		
	}

	public void atualizarEndereco(Endereco endereco) {
		controladorEndereco.atualizar(endereco);
		
	}

	public void removerEndereco(Integer codigoEndereco) {
		
		controladorEndereco.remover(codigoEndereco);
	}

	public Endereco procurarEndereco(Integer codigoEndereco) {
	
		return controladorEndereco.procurar(codigoEndereco);
	}

	public boolean existirEndereco(Integer codigoEndereco) {

		return controladorEndereco.existir(codigoEndereco);
	}

	public ArrayList<Endereco> listarEndereco() {

		return controladorEndereco.listar();
	}
	
	// -------------------------------------------------------------------Comanda------------------------------------------------------------------
	
	public void adicionarComanda(Comanda comanda) {
		controladorComanda.realizarPedido(comanda);
		

	}

	public void alterarComanda(Comanda idProduto) {
		controladorComanda.alterarPedido(idProduto);

	}

	public void cancelarPedidoComanda(Integer idProduto) {
		controladorComanda.cancelarPedido(idProduto);
	
	}

	public void finalizarPedidoComanda() {
		controladorComanda.finalizarPedido();
		
	}
	public ArrayList<Comanda> listarComanda() {
		return controladorComanda.listar();
	}
	public ArrayList<Comanda> listarComandaMontante() {
		return controladorComanda.listarMontante();
	}
}
