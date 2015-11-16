package com.autofood.comanda;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioComanda {

	public void realizarPedido(Comanda comanda) throws SQLException;


	public void cancelarPedido(Integer idProduto);
	
	public void finalizarPedido();

	public ArrayList<Comanda> listar();
	public ArrayList<Comanda> listarMontante();

}
