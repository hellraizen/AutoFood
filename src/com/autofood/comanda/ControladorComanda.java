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

	public void alterarPedido(Comanda idProduto) {
		repositorioComanda.alterarPedido(idProduto);

	}

	public void cancelarPedido(Integer idProduto) {

		repositorioComanda.cancelarPedido(idProduto);
	}

	public void finalizarPedido() {
		repositorioComanda.finalizarPedido();
		
	}
	public ArrayList<Comanda> listar() {
		return repositorioComanda.listar();
	}
}
