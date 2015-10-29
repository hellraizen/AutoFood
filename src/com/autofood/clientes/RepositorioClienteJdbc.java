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
		//String sql = "insert into clientetest (nome, cpf, dataNascimento, sexo, email, telefone, rua, bairro, numero, cep) values (?,?,?,?,?,?,?,?,?,?)";
		String sql = "insert into clientetest (nome, cpf)values(?,?)";
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		// Atualizando o primeiro parametro
		preStatement.setString(1, cliente.getNome());
		preStatement.setString(2, cliente.getCpf());
		//preStatement.setString(3, "03/12/2015");
		//preStatement.setString(4, "Mascolino");
		//preStatement.setString(5, "si.dani@gmail.com");
		//preStatement.setInt(6, 39393939);
		//preStatement.setString(7, "funala");
		//preStatement.setString(8, "vila");
		//preStatement.setString(9, "a2");
		//preStatement.setString(10, "3123-222");
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
