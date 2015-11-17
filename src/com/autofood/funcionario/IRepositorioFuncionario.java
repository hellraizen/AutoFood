package com.autofood.funcionario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioFuncionario 
{
	public void cadastrar(Funcionario funcionario) throws SQLException, IOException; 
	
	public void atualizar(Funcionario funcionario) throws SQLException;
	
	public void remover(String cpf) throws SQLException;
	
	public Funcionario procurar(String cpf) throws SQLException;
	
	public boolean existir(String cpf) throws SQLException;
	
	public ArrayList<Funcionario> listar() throws SQLException;

}
