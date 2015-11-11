package com.autofood.endereco;

import java.util.ArrayList;

public interface IRepositorioEndereco 
{	
	public void cadastrar(Endereco endereco); 
	public void atualizar(Endereco endereco);
	public boolean remover(Integer codigoEndereco);
	public Endereco procurar(Integer codigoEndereco);
	public boolean existir(Integer codigoEndereco);
	public ArrayList<Endereco> listar();
	
}
