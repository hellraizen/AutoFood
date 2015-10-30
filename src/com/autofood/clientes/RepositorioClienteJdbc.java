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
	public void atualizar(Cliente cliente) throws SQLException {

		// Criando a String SQL
		String sql = "update cliente set nome = ? where cliente_id = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;

		preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, "Pedro");
		preStatement.setInt(2, 1);
		// Executando o select
		preStatement.executeUpdate();

		// Fechando a Conexão
		preStatement.close();
		conn.close();

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
	public ArrayList<Cliente> listar() throws SQLException {

		ArrayList<Cliente> arrayListCliente = new ArrayList<Cliente>();

		// Criando a String SQL
		String sql = "select * from clientetest";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		ResultSet resultSet = preStatement.executeQuery();

		/*
		 * Exemplo de Select
		 */

		// Verifica se retornou dados na consulta
		while (resultSet.next()) {
			// Pegando as colunas do registro

			String nome = resultSet.getString(2);
			String cpf = resultSet.getString(3);
			String dataN = resultSet.getString(4);
			String sexo = resultSet.getString(5);
			int codigo = resultSet.getInt(1);
			String email = resultSet.getString(6);
			String telefone = resultSet.getString(7);
			Cliente cliente = new Cliente(nome, cpf, dataN, sexo, codigo, email, telefone);
			arrayListCliente.add(cliente);
		}
		// Fechando a Conexão
		preStatement.close();
		resultSet.close();
		conn.close();

		return arrayListCliente;
	}

}
