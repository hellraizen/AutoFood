package com.autofood.clientes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.autofood.exceçõesCliente.ClienteCpfInvalidoException;
import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;
import com.autofood.util.ValidarCPF;


public class ControladorCliente {
	private IRepositorioCliente repositorioCliente;
	
	public ControladorCliente() throws ClassNotFoundException, IOException{
		//repositorioCliente= new RepositorioClienteJdbc();
		//repositorioCliente= new RepositorioClienteList();
		//repositorioCliente= new RepositorioClienteMap();
		//repositorioCliente= new RepositorioClienteSet();
		repositorioCliente= new RepositorioClienteIO();
	}

	public void cadastrar(Cliente cliente) throws SQLException, ClienteJaCadastradoException, IOException, ClienteCpfInvalidoException {
		if (!ValidarCPF.validaCPF(cliente.getCpf())) {
			throw new ClienteCpfInvalidoException();
		} else {
			repositorioCliente.cadastrar(cliente);
		}
		
	}

	public void atualizar(Cliente cliente) throws SQLException, ClienteNaoEncontradoException, IOException {
		repositorioCliente.atualizar(cliente);

	}

	public void remover(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {
		repositorioCliente.remover(cpf);

	}

	public Cliente procurar(String cpf) throws SQLException, ClienteNaoEncontradoException, IOException {
  
		return repositorioCliente.procurar(cpf);
	}

	public boolean existe(String cpf) throws SQLException, IOException {
		
		return repositorioCliente.existe(cpf);
	}

	public ArrayList<Cliente> listar() throws SQLException, IOException {
		
		return repositorioCliente.listar();
	}

}
