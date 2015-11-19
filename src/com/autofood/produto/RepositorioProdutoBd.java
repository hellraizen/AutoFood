package com.autofood.produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAL.ConectaBd;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoBd implements IRepositorioProduto {

	Connection conn;

	public RepositorioProdutoBd() throws ClassNotFoundException {

		this.conn = ConectaBd.conectabd();
	}

	public void cadastra(Produto produto) throws ProdutoJáCadastradoException,
			NomeVazioException, SQLException {

		String sql = "insert into produtoteste (codigoProduto, nome_produto, quantidade, preco, validade, data_fabricacao) values(?,?,?,?,?,?)";

		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1,produto.getCodigoProduto());
		preStatement.setString(2, produto.getNomeProduto());
		preStatement.setInt(3, produto.getQuantidadeProduto());
		preStatement.setDouble(4, produto.getPrecoProduto());
		preStatement.setString(5, produto.getValidadeProduto());
		preStatement.setString(6, produto.getDataFabricacaoProduto());

		preStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	public void atualizar(Produto produto)
			throws ProdutoNaoEncontradoException, SQLException {

		String sql = "update produtoteste set codigoProduto= ?,nome_produto= ?,quantidade= ?,preco=?,validade= ?,data_fabricacao= ? where codigoProduto = ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1,produto.getCodigoProduto());
		preStatement.setString(2, produto.getNomeProduto());
		preStatement.setInt(3, produto.getQuantidadeProduto());
		preStatement.setDouble(4, produto.getPrecoProduto());
		preStatement.setString(5, produto.getValidadeProduto());
		preStatement.setString(6, produto.getDataFabricacaoProduto());

		preStatement.setString(7, produto.getCodigoProduto());

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");

	}

	public void remover(String codigoProduto)
			throws ProdutoNaoEncontradoException, SQLException {
	
		String sql = "delete from produtoteste where codigoProduto =? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, codigoProduto);
	
		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Removido Com Sucesso");

	}

	public Produto procurar(String codigoProduto)
			throws ProdutoNaoEncontradoException, SQLException {

		String sql = "select * from produtoteste where codigoProduto = ? ";

		PreparedStatement preStatement;

		preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, codigoProduto);
		ResultSet resultset = preStatement.executeQuery();
		while (resultset.next()) {
			
			int id = resultset.getInt(1);
			String codigo = resultset.getString(2);
			String produto = resultset.getString(3);
			int quantidade = resultset.getInt(4);
			Double preco = resultset.getDouble(5);
			String validade = resultset.getString(6);
			String datafrabicacao = resultset.getString(7);

			Produto produto1 = new Produto(id,codigo, produto, quantidade, preco,
					validade, datafrabicacao);
			
			return produto1;

		}

		return null;
	}

	public Boolean existi(String codigoProduto) {

		return null;
	}

	public ArrayList<Produto> listar() throws SQLException {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		String sql = "select * from produtoteste";

		PreparedStatement preStatement;
		preStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int id = resultSet.getInt(1);
			String codigo = resultSet.getString(2);
			String produto = resultSet.getString(3);
			int quantidade = resultSet.getInt(4);
			Double preco = resultSet.getDouble(5);
			String validade = resultSet.getString(6);
			String datafrabicacao = resultSet.getString(7);

			Produto produto1 = new Produto(id,codigo, produto, quantidade, preco,
					validade, datafrabicacao);
			arrayListProduto.add(produto1);
		}

		return arrayListProduto;
	}
}