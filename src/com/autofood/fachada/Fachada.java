package com.autofood.fachada;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.caixa.Caixa;
import com.autofood.caixa.ControladorCaixa;
import com.autofood.clientes.Cliente;
import com.autofood.clientes.ControladorCliente;
import com.autofood.comanda.Comanda;
import com.autofood.comanda.ControladorComanda;
import com.autofood.endereco.ControladorEndereco;
import com.autofood.endereco.Endereco;
import com.autofood.estoque.ControladorEstoque;
import com.autofood.estoque.Estoque;
import com.autofood.exceçoesFornecedor.CNPJFornecedorInvalido;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;
import com.autofood.exceçõesCliente.ClienteCpfInvalidoException;
import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;
import com.autofood.fornecedor.ControladorFornecedor;
import com.autofood.fornecedor.Fornecedor;
import com.autofood.funcionario.ControladorFuncionario;
import com.autofood.funcionario.Funcionario;
import com.autofood.produto.ControladorProduto;
import com.autofood.produto.Produto;

public class Fachada {
	private static Fachada instance;
	private ControladorCliente controladorCliente;
	private ControladorProduto controladorProduto;
	private ControladorEstoque controladorEstoque;
	private ControladorEndereco controladorEndereco;
	private ControladorComanda controladorComanda;
	private ControladorFuncionario controladorFuncionario;
	private ControladorFornecedor controladorFornecedor;
	private ControladorCaixa controladorCaixa;

	private Fachada() throws ClassNotFoundException, IOException {
		this.controladorCliente = new ControladorCliente();
		this.controladorProduto = new ControladorProduto();
		this.controladorEstoque = new ControladorEstoque();
		this.controladorEndereco = new ControladorEndereco();
		this.controladorComanda = new ControladorComanda();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorCaixa = new ControladorCaixa();
	}

	public static Fachada getInstance() throws ClassNotFoundException, IOException {
		if (Fachada.instance == null) {
			Fachada.instance = new Fachada();
		}
		return Fachada.instance;
	}

	// -------------------------------------------------------------------CLIENTE------------------------------------------------------------------

	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException, ClienteCpfInvalidoException {
		controladorCliente.cadastrar(cliente);

	}

	public void atualizarCliente(Cliente cliente) throws SQLException, ClienteNaoEncontradoException, IOException {
		controladorCliente.atualizar(cliente);

	}

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {
		controladorCliente.remover(cpf);

	}

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {

		return controladorCliente.procurar(cpf);
	}

	public boolean existeCliente(String cpf) throws SQLException, IOException {

		return controladorCliente.existe(cpf);
	}

	public ArrayList<Cliente> listarCliente() throws SQLException, IOException {

		return controladorCliente.listar();
	}

	// -------------------------------------------------------------------PRODUTO------------------------------------------------------------------

	public void cadastraProduto(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException, SQLException, IOException {

		controladorProduto.cadastra(produto);

	}

	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException, SQLException, IOException {

		controladorProduto.atualizar(produto);

	}

	public void removerProduto(String codigoProduto) throws ProdutoNaoEncontradoException, SQLException, IOException {

		controladorProduto.remover(codigoProduto);

	}

	public Produto procurarProduto(String codigoProduto)
			throws ProdutoNaoEncontradoException, SQLException, IOException {

		return controladorProduto.procurar(codigoProduto);

	}

	public Boolean existiProduto(String codigoProduto) throws SQLException, IOException {

		return controladorProduto.existi(codigoProduto);

	}

	public ArrayList<Produto> listarProduto() throws SQLException, IOException {

		return controladorProduto.listar();

	}
	
	// -------------------------------------------------------------------ESTOQUE------------------------------------------------------------------


	public void cadastraEstoque(Estoque estoque) throws com.autofood.exceçõesEstoque.NomeVazioException, ProdutoJaCadastradoEstoqueException, SQLException, IOException {
		
		controladorEstoque.cadastra(estoque);

	}

	public void atualizarEstoque(Estoque estoque) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {
		
		controladorEstoque.atualizar(estoque);

	}

	public void removerEstoque(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {
		
		controladorEstoque.remover(codigoProduto);
		
	}

	public Estoque procurarEstoque(String codigoProduto) throws ProdutoEstoqueNaoEncontradoException, SQLException, IOException {

		return controladorEstoque.procurar(codigoProduto);
	}

	public Boolean existiEstoque(String codigoProduto) throws SQLException, IOException {

		return controladorEstoque.existi(codigoProduto);
	}

	public ArrayList<Estoque> listarEstoque() throws SQLException, IOException {

		return controladorEstoque.listar();
	}
	// -------------------------------------------------------------------ENDEREÇO------------------------------------------------------------------
	
	public void cadastrarEndereco(Endereco endereco) throws SQLException, IOException {
		controladorEndereco.cadastrar(endereco);
		
	}

	public void atualizarEndereco(Endereco endereco) throws SQLException, IOException {
		controladorEndereco.atualizar(endereco);
		
	}

	public void removerEndereco(Integer codigoEndereco) throws SQLException, IOException {
		
		controladorEndereco.remover(codigoEndereco);
	}

	public Endereco procurarEndereco(Integer codigoEndereco) throws Exception {
	
		return controladorEndereco.procurar(codigoEndereco);
	}

	public boolean existirEndereco(Integer codigoEndereco) throws SQLException, IOException {

		return controladorEndereco.existir(codigoEndereco);
	}

	public ArrayList<Endereco> listarEndereco() throws SQLException, IOException {

		return controladorEndereco.listar();
	}
	
	// -------------------------------------------------------------------COMANDA------------------------------------------------------------------
	
	public void adicionarComanda(Comanda comanda) throws SQLException, IOException {
		controladorComanda.realizarPedido(comanda);
		

	}

	
	public void cancelarPedidoComanda(Integer idProduto) throws SQLException {
		controladorComanda.cancelarPedido(idProduto);
	
	}

	public void finalizarPedidoComanda() {
		controladorComanda.finalizarPedido();
		
	}
	public ArrayList<Comanda> listarComanda() {
		return controladorComanda.listar();
	}
	public ArrayList<Comanda> listarComandaMontante() throws SQLException, IOException {
		return controladorComanda.listarMontante();
	}



//------------------------------------------FUNCIONARIO-------------------------------------------------------------------------


	public void cadastrarFuncionario(Funcionario funcionario) throws SQLException, IOException
	{
		controladorFuncionario.cadastrar(funcionario);
	} 

	
	
	public void atualizarFuncionario(Funcionario funcionario) throws SQLException, IOException
	{
		controladorFuncionario.atualizar(funcionario);
	}


	
	
	public void removerFuncionario(String cpf) throws SQLException, IOException
	{
		
		controladorFuncionario.remover(cpf);
	}

	
	
	public Funcionario procurarFuncionario(String cpf) throws SQLException, IOException
	{
		return controladorFuncionario.procurar(cpf);
	}

	
	
	public boolean existirFuncionario(String cpf) throws SQLException, IOException
	{
		return controladorFuncionario.existir(cpf);
	}

	
	
	public ArrayList<Funcionario> listarFuncionario() throws SQLException, IOException
	{
		 return controladorFuncionario.listar();
	}
	
	//------------------------------------------FORNECEDOR-------------------------------------------------------------------------
 
	public void cadastraFornecedor(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException, SQLException, CNPJFornecedorInvalido, IOException {

		controladorFornecedor.cadastra(fornecedor);

	}

	public void atualizarFornecedor(Fornecedor fornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {

		controladorFornecedor.atualizar(fornecedor);

	}

	public void removerFornecedor(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {

		controladorFornecedor.remover(cnpjFornecedor);

	}

	public Fornecedor procurarFornecedor(String cnpjFornecedor)
			throws FornecedorNaoEncontradoException, SQLException, CNPJFornecedorInvalido, IOException {

		return controladorFornecedor.procurar(cnpjFornecedor);

	}

	public Boolean existiFornecedor(String cnpjFornecedor) throws SQLException, IOException {

		return controladorFornecedor.existi(cnpjFornecedor);

	}

	public ArrayList<Fornecedor> listarFornecedor() throws SQLException, IOException {

		return controladorFornecedor.listar();
	}
	//------------------------------------------Caixa-------------------------------------------------------------------------
	public boolean abrirCaixa() {
		return controladorCaixa.abrirCaixa();
	}

	public boolean fecharCaixa() {
		return controladorCaixa.fecharCaixa();
	}

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException {
		controladorCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException {
		controladorCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiarioCaixa() throws SQLException, IOException {
		return controladorCaixa.movimentoDiario();
	}
	
	
	
}	