package com.autofood.endereco;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.autofood.exceçõesEndereço.EnderecoJaCadastradoException;

public interface IRepositorioEndereco 
{	
	public void cadastrar(Endereco endereco) throws SQLException, IOException; 
	public void atualizar(Endereco endereco) throws SQLException, IOException;
	public void remover(Integer codigoEndereco) throws SQLException, IOException;
	public Endereco procurar(Integer codigoEndereco) throws SQLException, Exception;
	public boolean existir(Integer codigoEndereco) throws SQLException, IOException;
	public ArrayList<Endereco> listar() throws SQLException, IOException;
	
}
