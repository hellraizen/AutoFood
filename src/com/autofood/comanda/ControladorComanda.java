package com.autofood.comanda;

import java.util.ArrayList;

public class ControladorComanda {
	private IRepositorioComanda repositorioComanda;

	public ControladorComanda() {
		repositorioComanda = new RepositorioComandaList();
	}

	public void realizarPedido(Comanda comanda) {
		repositorioComanda.realizarPedido(comanda);

	}

	public void alterarPedido(Comanda idComanda) {
		repositorioComanda.alterarPedido(idComanda);

	}

	public Boolean cancelarPedido(Integer idComanda) {

		return repositorioComanda.cancelarPedido(idComanda);
	}

	
	public ArrayList<Comanda> listar(){
		return repositorioComanda.listar();
	}
}
