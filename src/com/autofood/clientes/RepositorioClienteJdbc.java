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

	}

	@Override
	public void atualizar(Cliente cliente) throws SQLException {

		// Criando a String SQL
		String sql = "update clientetest set nome = ? where codigo = ?";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;

		preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cliente.getNome());
		preStatement.setInt(2, cliente.getCodigo());
		// Executando o select
		preStatement.executeUpdate();

	}

	@Override
	public void remover(String cpf) throws SQLException {

		// Criando a String SQL
		String sql = "delete from clientetest where CPF = ?";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);

		// Executando o select
		preStatement.executeUpdate();

	}

	@Override
	public Cliente procurar(String cpf) throws SQLException {

		String sql = "select * from clientetest where cpf= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		
		
		Cliente cliente = new Cliente(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7));
		
		return cliente;
	}

	@Override
	public boolean existe(String cpf) throws SQLException {
		
		String sql = "select * from clientetest where cpf= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cpf);
		ResultSet resultSet = preStatement.executeQuery();
		return true;
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {

		ArrayList<Cliente> arrayListCliente = new ArrayList<Cliente>();

		// Criando a String SQL
		String sql = "select * from clientetest";

		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);

		ResultSet resultSet = preStatement.executeQuery();

		// Verifica se retornou dados na consulta
		while (resultSet.next()) {
			// Pegando as colunas do registro
			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			String cpf = resultSet.getString(3);
			String dataN = resultSet.getString(4);
			String sexo = resultSet.getString(5);
			String email = resultSet.getString(6);
			String telefone = resultSet.getString(7);
			Cliente cliente = new Cliente(nome, cpf, dataN, sexo, codigo, email, telefone);
			arrayListCliente.add(cliente);
		}

		return arrayListCliente;
	}

}
