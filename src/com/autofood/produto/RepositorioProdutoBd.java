package com.autofood.produto;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
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
		
		preStatement.setString(1,produto.getNomeProduto());
		preStatement.setInt(2,produto.getQuantidadeProduto());
		preStatement.setDouble(3,produto.getPrecoProduto());
		preStatement.setString(4,produto.getValidadeProduto());
		preStatement.setString(5,produto.getDataFabricacaoProduto());
		
		preStatement.execute();
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, SQLException {
		
		String sql = "update produtoteste set nome_produto= ?,quantidade= ?,preco=?,validade= ?,data_fabricacao= ? where idProduto = ?";

		PreparedStatement preStatement; 
		
		preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1,produto.getNomeProduto());
		preStatement.setInt(2,produto.getQuantidadeProduto());
		preStatement.setDouble(3,produto.getPrecoProduto());
		preStatement.setString(4,produto.getValidadeProduto());
		preStatement.setString(5,produto.getDataFabricacaoProduto());
		
		preStatement.setInt(6,produto.getIdProduto());
		
		preStatement.executeUpdate(sql);
		
		System.out.println("Atualizado Com Sucesso");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");

	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException {
		// criando sql para remover
		String sql = "delete from produtoteste where idProduto =? ";
		
		PreparedStatement preStatement;
		//preparanto conecção 
		preStatement = conn.prepareStatement(sql);
		
		preStatement.setInt(1,idProduto);
		// execulta o delete 
		preStatement.executeUpdate();
		
		System.out.println("REMOVIDO COM SUCESSO");
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
		

	}

	public Produto procurar(Integer idProduto) throws ProdutoNaoEncontradoException, SQLException {
		
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
			
			Produto produto1 = new Produto(codigo,produto,quantidade,preco,validade,datafrabicacao);
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
			
		return null;
	}

}
