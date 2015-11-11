package com.autofood.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exce��esCliente.ClienteJaCadastradoException;
import com.autofood.exce��esCliente.ClienteNaoEncontradoException;

public interface IRepositorioCliente {

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException;

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException;

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException;

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException;

	public boolean existe(String cpf) throws SQLException;

	public ArrayList<Cliente> listar() throws SQLException;

}
