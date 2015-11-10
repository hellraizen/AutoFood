package com.autofood.produto;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {

	}

	public void remover(Integer idProduto) throws ProdutoNaoEncontradoException {

	}

	public Produto procurar(Integer idProduto)
			throws ProdutoNaoEncontradoException {

		return null;
	}

	public Boolean existi(Integer idPrdotudo) {

		return null;
	}

	public ArrayList<Produto> listar() {

		return null;
	}

}
