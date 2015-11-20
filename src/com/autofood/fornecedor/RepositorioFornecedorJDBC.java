package com.autofood.fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;

import DAL.ConectaBd;

public class RepositorioFornecedorJDBC implements IRepositorioFornecedor {

	Connection conn;

	public RepositorioFornecedorJDBC() throws ClassNotFoundException {

		this.conn = ConectaBd.conectabd();

	}

	public void cadastra(Fornecedor fornecedor)
			throws FornecedorJaCadastradoException, FornecedorNuloException, SQLException {

		String sql = "insert into fornecedorteste (nomeFornecedor,cnpjFornecedor,produtoFornecido,telefoneFornecedor,emailFornecedor) values(?,?,?,?,?)";

		PreparedStatement preStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		preStatement.setString(1, fornecedor.getNomeFornecedor());
		preStatement.setString(2, fornecedor.getCnpjFornecedor());
		preStatement.setString(3, fornecedor.getProdutoFornecido());
		preStatement.setString(4, fornecedor.getTelefoneFornecedor());
		preStatement.setString(5, fornecedor.getEmailFornecedor());

		preStatement.execute();

		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");

	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException, SQLException {

		String sql = "update fornecedorteste set nomeFornecedor= ?,cnpjFornecedor= ?,produtoFornecido= ?,telefoneFornecedor= ?,emailFornecedor= ? where cnpjFornecedor= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, fornecedor.getNomeFornecedor());
		preStatement.setString(2, fornecedor.getCnpjFornecedor());
		preStatement.setString(3, fornecedor.getProdutoFornecido());
		preStatement.setString(4, fornecedor.getTelefoneFornecedor());
		preStatement.setString(5, fornecedor.getEmailFornecedor());

		preStatement.setString(6, fornecedor.getCnpjFornecedor());
		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");

	}

	public void remover(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException {

		String sql = "delete from fornecedorteste where cnpjFornecedor = ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cnpjFornecedor);

		preStatement.executeUpdate();

		JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");

	}

	public Fornecedor procurar(String cnpjFornecedor) throws FornecedorNaoEncontradoException, SQLException {

		String sql = "select * from fornecedorteste where cnpjFornecedor= ?";

		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, cnpjFornecedor);

		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			String cnpj = resultSet.getString(3);
			String produto = resultSet.getString(4);
			String telefone = resultSet.getString(5);
			String email = resultSet.getString(6);

			Fornecedor fornecedor = new Fornecedor(codigo, nome, cnpj, produto, telefone, email);
			
			return fornecedor;

		}
		return null;
	}

	public Boolean existi(String cnpjFornecedor) {

		return null;
	}

	public ArrayList<Fornecedor> listar() throws SQLException {

		ArrayList<Fornecedor> arrayListFornecedor = new ArrayList<Fornecedor>();

		String sql = "select * from fornecedorteste";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();
		while (resultSet.next()) {

			int codigo = resultSet.getInt(1);
			String nome = resultSet.getString(2);
			String cnpj = resultSet.getString(3);
			String produto = resultSet.getString(4);
			String telefone = resultSet.getString(5);
			String email = resultSet.getString(6);

			Fornecedor fornecedor = new Fornecedor(codigo, nome, cnpj, produto, telefone, email);
			arrayListFornecedor.add(fornecedor);

		}

		return arrayListFornecedor;
	}

}
