package com.autofood.funcionario;

import java.util.ArrayList;

import com.autofood.clientes.Cliente;

public interface IRepositorioFuncionario 
{
	public void cadastrar(Funcionario funcionario); 
	
	public void atualizar(Funcionario funcionario);
	
	public boolean remover(String cpf);
	
	public Cliente procurar(String cpf);
	
	public boolean existir(String cpf);
	
	public ArrayList<Funcionario> listar();

}