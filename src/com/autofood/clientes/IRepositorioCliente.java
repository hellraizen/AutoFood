package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteJaCadastradoException;

public interface IRepositorioCliente {
	
		public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException;
		public void atualizar(Cliente cliente)throws SQLException; //throws ClienteNaoEncontradoException;
		public void remover(String cpf) throws SQLException; //throws ClienteNaoEncontradoException;
		public Cliente procurar(String cpf) throws SQLException;// throws ClienteNaoEncontradoException;
		public boolean existe(String cpf) throws SQLException;
		public ArrayList<Cliente> listar() throws SQLException;

}
