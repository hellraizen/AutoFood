package com.autofood.estoque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;

import DAL.ConectaBd;

public class RepositorioEstoqueJdbc implements IRepositorioEstoque {

	Connection conn;

	public RepositorioEstoqueJdbc() throws ClassNotFoundException {

		this.conn = ConectaBd.conectabd();

	}

	public void cadastra(Estoque estoque) throws SQLException {

		String sql = "insert into estoqueteste (codigoProduto,produtoEstoque,quantidade,dataEntrada,dataValidade,precoCusto)values(?,?,?,?,?,?)";

		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		preStatement.setString(1,estoque.getCodigoProduto());
		preStatement.setString(2, estoque.getNomeProdutoEstoque());
		preStatement.setInt(3, estoque.getQuantidadeProdutoEstoque());
		preStatement.setString(4, estoque.getDataEntradaProdutoEstoque());
		preStatement.setString(5, estoque.getDataValidadeProdutoEstoque());
		preStatement.setDouble(6, estoque.getPrecoCustoProdutoEstoque());

		preStatement.execute();

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Estoque estoque) throws SQLException {

		String sql = "update estoqueteste set codigoProduto= ?, produtoEstoque= ?,quantidade= ?,dataEntrada= ?,dataValidade= ?,precoCusto= ? where codigoProduto= ?";
		PreparedStatement preStatement;
		preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1,estoque.getCodigoProduto());
		preStatement.setString(2, estoque.getNomeProdutoEstoque());
		preStatement.setInt(3, estoque.getQuantidadeProdutoEstoque());
		preStatement.setString(4, estoque.getDataEntradaProdutoEstoque());
		preStatement.setString(5, estoque.getDataValidadeProdutoEstoque());
		preStatement.setDouble(6, estoque.getPrecoCustoProdutoEstoque());
		preStatement.setString(7, estoque.getCodigoProduto());

		preStatement.executeUpdate();

		
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
	}

	public void remover(String codigoProduto) throws SQLException {

		String sql = "delete from estoqueteste where codigoProduto= ? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, codigoProduto);

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Removido Com Sucesso");

	}

	public Estoque procurar(String codigoProduto) throws SQLException, ProdutoEstoqueNaoEncontradoException {

		String sql = "select * from estoqueteste where codigoProduto= ? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, codigoProduto);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String codigo = resultSet.getString(2);
			String produto = resultSet.getString(3);
			int quantidade = resultSet.getInt(4);
			String dataEntrada = resultSet.getString(5);
			String validade = resultSet.getString(6);
			Double preco = resultSet.getDouble(7);

			Estoque estoque = new Estoque(id,codigo, produto, quantidade, dataEntrada, validade, preco);

			return estoque;
			
		}
		throw new ProdutoEstoqueNaoEncontradoException();
	}

	public Boolean existi(String codigoProduto) {

		return null;
	}

	public ArrayList<Estoque> listar() throws SQLException {

		ArrayList<Estoque> arrayListEstoque = new ArrayList<Estoque>();

		String sql = "select * from estoqueteste";

		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String codigo = resultSet.getString(2);
			String produto = resultSet.getString(3);
			int quantidade = resultSet.getInt(4);
			String dataEntrada = resultSet.getString(5);
			String validade = resultSet.getString(6);
			Double preco = resultSet.getDouble(7);

			Estoque estoque = new Estoque(id,codigo, produto, quantidade, dataEntrada, validade, preco);

			arrayListEstoque.add(estoque);

		}
		return arrayListEstoque;
	}
}