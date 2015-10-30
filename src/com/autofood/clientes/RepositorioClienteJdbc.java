package com.autofood.clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DAL.ConectaBd;

public class RepositorioClienteJdbc implements IRepositorioCliente {

	Connection conn;

	public RepositorioClienteJdbc() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}

	@Override
	public void cadastrar(Cliente cliente) throws SQLException {
		// Criando a String SQL
		String sql = "insert into clientetest (nome, cpf, dataNascimento, sexo, email, telefone) values (?,?,?,?,?,?)";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Atualizando o primeiro parametro
		preStatement.setString(1, cliente.getNome());
		preStatement.setString(2, cliente.getCpf());
		preStatement.setString(3, cliente.getDataNascimento());
		preStatement.setString(4, cliente.getSexo());
		preStatement.setString(5, cliente.getEmail());
		preStatement.setString(6, cliente.getTelefone());

		preStatement.execute();

		// Retorna um ResultSet com todas as chaves geradas
		ResultSet resultSet = preStatement.getGeneratedKeys();
		Integer clienteId = 0;

		// Pegando o identificador gerado a partir do último insert
		while (resultSet.next()) {
			clienteId = resultSet.getInt(1);
		}
		System.out.println("ID do Insert no Banco " + clienteId);

		// Fechando conexões
		conn.close();
		preStatement.close();
		resultSet.close();

	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(String cpf) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existe(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Cliente> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
