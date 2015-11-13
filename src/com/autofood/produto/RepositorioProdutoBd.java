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

		String sql = "insert into produtoteste (nome_produto, quantidade, preco, validade, data_fabricacao) values(?,?,?,?,?)";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, produto.getNomeProduto());
		preStatement.setInt(2, produto.getQuantidadeProduto());
		preStatement.setDouble(3, produto.getPrecoProduto());
		preStatement.setString(4, produto.getValidadeProduto());
		preStatement.setString(5, produto.getDataFabricacaoProduto());

		preStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	public void atualizar(Produto produto)
			throws ProdutoNaoEncontradoException, SQLException {

		String sql = "update produtoteste set idProduto=? ,nome_produto= ?,quantidade= ?,preco=?,validade= ?,data_fabricacao= ? where idProduto = ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, produto.getIdProduto());
		preStatement.setString(2, produto.getNomeProduto());
		preStatement.setInt(3, produto.getQuantidadeProduto());
		preStatement.setDouble(4, produto.getPrecoProduto());
		preStatement.setString(5, produto.getValidadeProduto());
		preStatement.setString(6, produto.getDataFabricacaoProduto());

		preStatement.setInt(7, produto.getIdProduto());

		preStatement.executeUpdate(sql);

		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");

	}

	public void remover(Integer idProduto)
			throws ProdutoNaoEncontradoException, SQLException {
	
		String sql = "delete from produtoteste where idProduto =? ";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, idProduto);
	
		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Removido Com Sucesso");

	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException, SQLException {

		String sql = "select * from produtoteste where idProduto = ? ";

		PreparedStatement preStatement;

		preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, idProduto);
		ResultSet resultset = preStatement.executeQuery();
		while (resultset.next()) {
			int codigo = resultset.getInt(1);
			String produto = resultset.getString(2);
			int quantidade = resultset.getInt(3);
			Double preco = resultset.getDouble(4);
			String validade = resultset.getString(5);
			String datafrabicacao = resultset.getString(6);

			Produto produto1 = new Produto(codigo, produto, quantidade, preco,
					validade, datafrabicacao);
			
			return produto1;

		}

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {

		return null;
	}

	public ArrayList<Produto> listar() throws SQLException {

		ArrayList<Produto> arrayListProduto = new ArrayList<Produto>();

		String sql = "select * from produtoteste";

		PreparedStatement preStatement;
		preStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String produto = resultSet.getString(2);
			int quantidade = resultSet.getInt(3);
			Double preco = resultSet.getDouble(4);
			String validade = resultSet.getString(5);
			String datafrabicacao = resultSet.getString(6);

			Produto produto1 = new Produto(codigo, produto, quantidade, preco,
					validade, datafrabicacao);
			arrayListProduto.add(produto1);
		}

		return arrayListProduto;
	}
}