package com.autofood.endereco;

import java.sql.SQLException;
import java.util.ArrayList;

//import com.autofood.exceçõesEndereço.EnderecoJaCadastradoException;

public interface IRepositorioEndereco 
{	
	public void cadastrar(Endereco endereco) throws SQLException; 
	public void atualizar(Endereco endereco) throws SQLException;
	public void remover(Integer codigoEndereco) throws SQLException;
	public Endereco procurar(Integer codigoEndereco) throws SQLException;
	public boolean existir(Integer codigoEndereco) throws SQLException;
	public ArrayList<Endereco> listar() throws SQLException;
	
}
