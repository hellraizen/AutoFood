package com.autofood.funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.autofood.endereco.Endereco;

import DAL.ConectaBd;

public class RepositorioFuncionarioBd implements IRepositorioFuncionario {

	Connection conn;
	
	public RepositorioFuncionarioBd() throws ClassNotFoundException 
	{
		this.conn = ConectaBd.conectabd();
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) throws SQLException 
	{
		// Criando a String SQL
		String sql = "insert into funcionariotest (idFuncionario, nomeFuncionario, cpfFuncionario, enderecoFuncionario, dataNascimentoFuncionario, sexoFuncionario, telefoneFuncionario, emailFuncionario, tipoFuncionario, login, senha) values (?,?,?,?,?,?,?,?,?,?,?)";
		
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		// Atualizando o primeiro parametro
		preStatement.setLong(1, funcionario.getIdFuncionario());
		preStatement.setString(2, funcionario.getNomeFuncionario());
		preStatement.setString(3, funcionario.getCpfFuncionario());
		preStatement.setObject(4, funcionario.getEnderecoFuncionario());
		preStatement.setString(5, funcionario.getDataNascimentoFuncionario());
		preStatement.setString(6, funcionario.getSexoFuncionario());
		preStatement.setString(7, funcionario.getTelefoneFuncionario());
		preStatement.setString(8, funcionario.getEmailFuncionario());
		preStatement.setString(9, funcionario.getTipoFuncionario());
		preStatement.setString(10, funcionario.getLogin());
		preStatement.setString(11, funcionario.getSenha());
		
		preStatement.execute();
		
		// Retorna um ResultSet com todas as chaves geradas
		ResultSet resultSet = preStatement.getGeneratedKeys();
		Integer idFunc = 0;
		
		// Pegando o identificador gerado a partir do último insert
		while (resultSet.next())
		{
			idFunc = resultSet.getInt(1);
		}
				
		System.out.println("ID do Insert no Banco " + idFunc);
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		
	}

	
	
	@Override
	public void atualizar(Funcionario funcionario) throws SQLException 
	{
		// Criando a String SQL
		String sql = "update funcionariotest set idFuncionario = ?, nomeFuncionario = ?, cpfFuncionario = ?, enderecoFuncionario = ?, dataNascimentoFuncionario = ?, sexoFuncionario = ?, telefoneFuncionario = ?, emailFuncionario = ?, tipoFuncionario = ?, login = ?, senha = ?";
		
		// Criar o PreparedStatement, objeto para executar a query
		PreparedStatement preStatement;
		
		preStatement = conn.prepareStatement(sql);
		
		preStatement.setLong(1, funcionario.getIdFuncionario());
		preStatement.setString(2, funcionario.getNomeFuncionario());
		preStatement.setString(3, funcionario.getCpfFuncionario());
		preStatement.setObject(4, funcionario.getEnderecoFuncionario());
		preStatement.setString(5, funcionario.getDataNascimentoFuncionario());
		preStatement.setString(6, funcionario.getSexoFuncionario());
		preStatement.setString(7, funcionario.getTelefoneFuncionario());
		preStatement.setString(8, funcionario.getEmailFuncionario());
		preStatement.setString(9, funcionario.getTipoFuncionario());
		preStatement.setString(10, funcionario.getLogin());
		preStatement.setString(11, funcionario.getSenha());
	
		// Executando o select
		preStatement.executeUpdate();
		
		System.out.println("Atualizado com sucesso!");
		JOptionPane.showMessageDialog(null, "Atualizado Com Sucesso");
		
	}

	
	
	
	@Override
	public void remover(String cpf) throws SQLException 
	{
		//Criando String SQL
		String sql = "delete from funcionariotest where cpfFuncionario = ?";
		
		//Criando PreparedStatement
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1, cpf);
		
		//Executando select
		preStatement.executeUpdate();
		
		System.out.println("REMOVIDO COM SUCESSO");
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");
	}

	
	
	
	@Override
	public Funcionario procurar(String cpf) throws SQLException 
	{
		String sql = "select * from funcionariotest where cpf = ?";
		
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1, cpf);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		while(resultSet.next())
		{
			Integer idFuncionario = resultSet.getInt(1);
			String nomeFuncionario = resultSet.getString(2);
			String cpfFuncionario = resultSet.getString(3);
			Endereco enderecoFuncionario = (Endereco) resultSet.getObject(4);
			String dataNascimentoFuncionario = resultSet.getString(5);
			String sexoFuncionario = resultSet.getString(6);
			String telefoneFuncionario = resultSet.getString(7);
			String emailFuncionario = resultSet.getString(8);
			String tipoFuncionario = resultSet.getString(9);
			String login = resultSet.getString(10);
			String senha = resultSet.getString(11);
			
			Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, enderecoFuncionario, dataNascimentoFuncionario, sexoFuncionario, telefoneFuncionario, emailFuncionario, tipoFuncionario, login, senha);
			return funcionario;
		}	
		
		return null;
	}

	
	
	
	@Override
	public boolean existir(String cpf) throws SQLException 
	{
		String sql = "select * from funcionariotest where cpf = ?";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		preStatement.setString(1,cpf);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		if(resultSet.equals(cpf))
		{
			JOptionPane.showMessageDialog(null, "Funcionário Existe!");
			return true;
		}
		JOptionPane.showMessageDialog(null, "Funcionário Não Existe!");
		return false;
	}

	
	
	
	@Override
	public ArrayList<Funcionario> listar() throws SQLException 
	{
		ArrayList<Funcionario> arrayFuncionario = new ArrayList<Funcionario>();
		
		String sql = "select * from funcionariotest";
		PreparedStatement preStatement = conn.prepareStatement(sql);
		
		ResultSet resultSet = preStatement.executeQuery();
		
		while(resultSet.next())
		{
			Integer idFuncionario = resultSet.getInt(1);
			String nomeFuncionario = resultSet.getString(2);
			String cpfFuncionario = resultSet.getString(3);
			Endereco enderecoFuncionario = (Endereco) resultSet.getObject(4);
			String dataNascimentoFuncionario = resultSet.getString(5);
			String sexoFuncionario = resultSet.getString(6);
			String telefoneFuncionario = resultSet.getString(7);
			String emailFuncionario = resultSet.getString(8);
			String tipoFuncionario = resultSet.getString(9);
			String login = resultSet.getString(10);
			String senha = resultSet.getString(11);
			
			Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, enderecoFuncionario, dataNascimentoFuncionario, sexoFuncionario, telefoneFuncionario, emailFuncionario, tipoFuncionario, login, senha);
			arrayFuncionario.add(funcionario);
		}
		
		return arrayFuncionario;
	}

}
