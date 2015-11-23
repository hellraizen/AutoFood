package com.autofood.cozinha;

import java.util.ArrayList;

import com.autofood.comanda.Comanda;

public interface IRepositorioCozinha {
	
	public void receberPedido(Comanda comanda);
	
	public void finalizarPedido(Comanda comanda);
	
	public void cancelarPedido(Comanda comanda);
	
	public ArrayList<Comanda> listaPedidos();
}
