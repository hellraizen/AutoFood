package com.autofood.comanda;

import java.util.ArrayList;

public interface IRepositorioComanda {

	public void realizarPedido(Comanda comanda);

	public void alterarPedido(Comanda idComanda);

	public Boolean cancelarPedido(Integer idComanda);

	public ArrayList<Comanda> listar();

}
