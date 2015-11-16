package com.autofood.endereco;

import java.sql.Connection;
import java.util.ArrayList;

import DAL.ConectaBd;

public class RepositorioEnderecoBd implements IRepositorioEndereco 
{
	
	Connection conn;
	
	public RepositorioEnderecoBd() throws ClassNotFoundException 
	{
		this.conn = ConectaBd.conectabd();
	}

	@Override
	public void cadastrar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco procurar(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existir(Integer codigoEndereco) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Endereco> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
