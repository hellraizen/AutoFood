package com.autofood.funcionario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioFuncionario 
{
	public void cadastrar(Funcionario funcionario) throws SQLException, IOException; 
	
	public void atualizar(Funcionario funcionario) throws SQLException, IOException;
	
	public void remover(String cpf) throws SQLException, IOException;
	
	public Funcionario procurar(String cpf) throws SQLException, IOException;
	
	public boolean existir(String cpf) throws SQLException, IOException;
	
	public ArrayList<Funcionario> listar() throws SQLException, IOException;

}
