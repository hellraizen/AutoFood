package com.autofood.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.ConectaBd;

public class RepositorioEstoqueJdbc implements IRepositorioEstoque {

	Connection conn;

	public RepositorioEstoqueJdbc() throws ClassNotFoundException {

		this.conn = ConectaBd.conectabd();

	}

	public void cadastra(Estoque estoque) throws SQLException {

		String sql = "insert into estoqueteste (produtoEstoque,quantidade,dataEntrada,dataValidade,precoCusto)values(?,?,?,?,?)";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, estoque.getNomeProdutoEstoque());
		preStatement.setInt(2, estoque.getQuantidadeProdutoEstoque());
		preStatement.setString(3, estoque.getDataEntradaProdutoEstoque());
		preStatement.setString(4, estoque.getDataValidadeProdutoEstoque());
		preStatement.setDouble(5, estoque.getPrecoCustoProdutoEstoque());

		preStatement.execute();

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Estoque estoque) throws SQLException {

		String sql = "update estoqueteste set idEstoqueProduto= ?, produtoEstoque= ?,quantidade= ?,dataEntrada= ?,dataValidade= ?,precoCusto=? where idEstoqueProduto= ?";
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, estoque.getIdEstoqueProduto());
		preStatement.setString(2, estoque.getNomeProdutoEstoque());
		preStatement.setInt(3, estoque.getQuantidadeProdutoEstoque());
		preStatement.setString(4, estoque.getDataEntradaProdutoEstoque());
		preStatement.setString(5, estoque.getDataValidadeProdutoEstoque());
		preStatement.setDouble(6, estoque.getPrecoCustoProdutoEstoque());

		preStatement.setInt(7, estoque.getIdEstoqueProduto());

		preStatement.executeUpdate(sql);

		System.out.println("Atualizado Com Sucesso");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
	}

	public void remover(Integer idEstoqueProduto) throws SQLException {

		String sql = "delete from estoqueteste where idEstoqueProduto= ? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, idEstoqueProduto);

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Removido Com Sucesso");

	}

	public Estoque procurar(Integer idEstoqueProduto) throws SQLException {

		String sql = "select * from estoqueteste where idEstoqueProduto= ? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, idEstoqueProduto);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String produto = resultSet.getString(2);
			int quantidade = resultSet.getInt(3);
			String dataEntrada = resultSet.getString(4);
			String validade = resultSet.getString(5);
			Double preco = resultSet.getDouble(6);

			Estoque estoque = new Estoque(codigo, produto, quantidade, dataEntrada, validade, preco);

			return estoque;

		}
		return null;
	}

	public Boolean existi(Integer idEstoqueProduto) {

		return null;
	}

	public ArrayList<Estoque> listar() throws SQLException {

		ArrayList<Estoque> arrayListEstoque = new ArrayList<Estoque>();

		String sql = "select * from estoqueteste";

		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String produto = resultSet.getString(2);
			int quantidade = resultSet.getInt(3);
			String dataEntrada = resultSet.getString(4);
			String validade = resultSet.getString(5);
			Double preco = resultSet.getDouble(6);

			Estoque estoque = new Estoque(codigo, produto, quantidade, dataEntrada, validade, preco);

			arrayListEstoque.add(estoque);

		}
		return arrayListEstoque;
	}
}