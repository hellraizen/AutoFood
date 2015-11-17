package com.autofood.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;

public interface IRepositorioCliente {

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException;

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException, IOException;

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException;

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException;

	public boolean existe(String cpf) throws SQLException, IOException;

	public ArrayList<Cliente> listar() throws SQLException, IOException;

}
