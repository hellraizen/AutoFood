package com.autofood.comanda;

import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorComanda {
	private IRepositorioComanda repositorioComanda;

	public ControladorComanda() {
		repositorioComanda = new RepositorioComandaList();
		//repositorioComanda= new RepositorioComandaJdbc();
		//repositorioComanda = new RepositorioComandaMap();
		//repositorioComanda = new RepositorioComandaSet();
		//repositorioComanda = new RepositorioComandaIO();
	}

	public void realizarPedido(Comanda comanda) throws SQLException {
		repositorioComanda.realizarPedido(comanda);

	}


	
	public void cancelarPedido(Integer idProduto) throws SQLException {

		repositorioComanda.cancelarPedido(idProduto);
	}

	public void finalizarPedido() {
		repositorioComanda.finalizarPedido();
		
	}
	public ArrayList<Comanda> listar() {
		return repositorioComanda.listar();
	}
	public ArrayList<Comanda> listarMontante() throws SQLException {
		return repositorioComanda.listarMontante();
	}
}
