package com.autofood.comanda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioComanda {

	public void realizarPedido(Comanda comanda) throws SQLException, IOException;


	public void cancelarPedido(Integer idProduto) throws SQLException;
	
	public void finalizarPedido();

	public ArrayList<Comanda> listar();
	public ArrayList<Comanda> listarMontante() throws SQLException, IOException;

}
	