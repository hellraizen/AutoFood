package com.autofood.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.clientes.Cliente;
import com.autofood.fornecedor.Fornecedor;
import com.autofood.funcionario.Funcionario;

import DAL.ConectaBd;

public class RepositorioEnderecoBd implements IRepositorioEndereco {

	Connection conn;

	public RepositorioEnderecoBd() throws ClassNotFoundException {
		this.conn = ConectaBd.conectabd();
	}

	@Override
	public void cadastrar(Endereco endereco) throws SQLException {
		String sql = "insert into testEndereco( rua, bairro, numero, cep, complemento) values(?,?,?,?,?) ";
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setString(1, endereco.getRua());
		preStatement.setString(2, endereco.getBairro());
		preStatement.setString(3, endereco.getNumero());
		preStatement.setString(4, endereco.getCep());
		preStatement.setString(5, endereco.getComplemento());
	

		preStatement.execute();
		
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
	}

	@Override
	public void atualizar(Endereco endereco) throws SQLException {
		String sql = "update testEndereco set idEndereco =?, rua =?, bairro =?, numero =?,cep =?, complemento =?";
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setLong(1, endereco.getIdEndereco());
		preStatement.setString(2, endereco.getRua());
		preStatement.setString(3, endereco.getBairro());
		preStatement.setString(4, endereco.getNumero());
		preStatement.setString(5, endereco.getCep());
		preStatement.setString(6, endereco.getComplemento());

		preStatement.executeUpdate();

		System.out.println("Atualizado com sucesso!");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");

	}

	@Override
	public void remover(Integer codigoEndereco) throws SQLException {
		String sql = "delete from testEndereco where codigoEndereco = ?";
		PreparedStatement prestatement = conn.prepareStatement(sql);

		prestatement.setLong(1, codigoEndereco);

		prestatement.executeUpdate();

		System.out.println("REMOVIDO COM SUCESSO");
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");

	}

	@Override
	public Endereco procurar(Integer codigoEndereco) throws SQLException {
		String sql = "select * from testEndereco where codigoEndereco = ?";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.setInt(1, codigoEndereco);

		ResultSet resultSet = preStatement.executeQuery();

		while (resultSet.next()) {
			Integer idEndereco = resultSet.getInt(1);
			String rua = resultSet.getString(2);
			String bairro = resultSet.getString(3);
			String numero = resultSet.getString(4);
			String cep = resultSet.getString(5);
			String complemento = resultSet.getString(6);
			Cliente cliente = (Cliente) resultSet.getObject(7);
			Funcionario funcionario = (Funcionario) resultSet.getObject(8);
			Fornecedor fornecedor = (Fornecedor) resultSet.getObject(9);

			Endereco endereco = new Endereco(idEndereco, rua, bairro, numero, cep, complemento, cliente, funcionario,
					fornecedor);
			return endereco;
		}

		return null;
	}

	@Override
	public boolean existir(Integer codigoEndereco) throws SQLException {
		String sql = "select * from testEndereco where codigoEndereco = ?";
		PreparedStatement preStatement = conn.prepareStatement(sql);

		preStatement.setInt(1, codigoEndereco);

		ResultSet resultSet = preStatement.executeQuery();

		if (resultSet.equals(codigoEndereco)) {
			JOptionPane.showMessageDialog(null, "Endereço Existe!");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Endereço Não Existe!");
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() throws SQLException {
		String sql = "select * from testEndereco";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		ResultSet resultSet = preStatement.executeQuery();

		ArrayList<Endereco> arrayEndereco = new ArrayList<Endereco>();

		while (resultSet.next()) {

			Integer idEndereco = resultSet.getInt(1);
			String rua = resultSet.getString(2);
			String bairro = resultSet.getString(3);
			String numero = resultSet.getString(4);
			String cep = resultSet.getString(5);
			String complemento = resultSet.getString(6);

			Endereco endereco = new Endereco(idEndereco, rua, bairro, numero, cep, complemento);
			arrayEndereco.add(endereco);
		}

		return arrayEndereco;

	}

}
