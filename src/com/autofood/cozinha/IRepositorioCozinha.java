package com.autofood.cozinha;

import java.util.ArrayList;

import com.autofood.comanda.Comanda;

public interface IRepositorioCozinha {
	
	public void finalizarPedido(Comanda comanda);
	
	public void editarPedido(Comanda comanda);
	
	public ArrayList<Comanda> listaPedidos();
}
