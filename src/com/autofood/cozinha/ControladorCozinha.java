package com.autofood.cozinha;

import java.util.ArrayList;
import com.autofood.comanda.Comanda;

public class ControladorCozinha 
{
	private IRepositorioCozinha repositorioCozinha;
	
	
	public ControladorCozinha() 
	{
		
		this.repositorioCozinha = new RepositorioCozinhaBD();
		//this.repositorioCozinha = new RepositorioCozinhaIO();
		//this.repositorioCozinha = new RepositorioCozinhaList();
		//this.repositorioCozinha = new RepositorioCozinhaMap();
		//this.repositorioCozinha = new RepositorioCozinhaSet();
		
	}
	
	
	public void receberPedido(Comanda comanda) 
	{
		
	}

	public void finalizarPedido(Comanda comanda) {
		// TODO Auto-generated method stub

	}

	public void cancelarPedido(Comanda comanda) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Comanda> listaPedidos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
