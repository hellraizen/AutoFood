package com.autofood.clientes;

import java.util.ArrayList;

public interface IRepositorioCliente {
	
		public void cadastrar(Cliente cliente);// throws ClienteJaCadastradoException;
		public void atualizar(Cliente cliente); //throws ClienteNaoEncontradoException;
		public void remover(String cpf); //throws ClienteNaoEncontradoException;
		public Cliente procurar(String cpf);// throws ClienteNaoEncontradoException;
		public boolean existe(String cpf);
		public ArrayList<Cliente> listar();

}
