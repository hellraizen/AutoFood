package com.autofood.funcionario;

import java.util.ArrayList;

import com.autofood.clientes.Cliente;

public class RepositorioFuncionarioSet implements IRepositorioFuncionario 
{

	@Override
	public void cadastrar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente procurar(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existir(String cpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Funcionario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
