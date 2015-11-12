package com.autofood.endereco;

import java.util.ArrayList;

import com.autofood.exceçõesEndereço.EnderecoJaCadastradoException;

public interface IRepositorioEndereco 
{	
	public void cadastrar(Endereco endereco) throws EnderecoJaCadastradoException; 
	public void atualizar(Endereco endereco);
	public boolean remover(Integer codigoEndereco);
	public Endereco procurar(Integer codigoEndereco);
	public boolean existir(Integer codigoEndereco);
	public ArrayList<Endereco> listar();
	
}
