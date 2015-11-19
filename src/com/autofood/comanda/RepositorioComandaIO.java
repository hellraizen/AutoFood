package com.autofood.comanda;

import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioComandaIO implements IRepositorioComanda{

	@Override
	public void realizarPedido(Comanda comanda) throws SQLException {
		
		
	}

	@Override
	public void cancelarPedido(Integer idProduto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarPedido() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Comanda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comanda> listarMontante() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
