package com.autofood.clientes;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCliente {
	
		public void cadastrar(Cliente cliente) throws SQLException;// throws ClienteJaCadastradoException;
		public void atualizar(Cliente cliente)throws SQLException; //throws ClienteNaoEncontradoException;
		public void remover(String cpf); //throws ClienteNaoEncontradoException;
		public Cliente procurar(String cpf);// throws ClienteNaoEncontradoException;
		public boolean existe(String cpf);
		public ArrayList<Cliente> listar() throws SQLException;

}
