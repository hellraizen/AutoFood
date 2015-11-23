package com.autofood.cozinha;

import java.util.ArrayList;
import com.autofood.comanda.Comanda;

public class ControladorCozinha 
{
	private IRepositorioCozinha repositorioCozinha;
	
	
	public ControladorCozinha() 
	{
		
		//this.repositorioCozinha = new RepositorioCozinhaBD();
		//this.repositorioCozinha = new RepositorioCozinhaIO();
		this.repositorioCozinha = new RepositorioCozinhaList();
		//this.repositorioCozinha = new RepositorioCozinhaMap();
		//this.repositorioCozinha = new RepositorioCozinhaSet();
		
	}
	
	

	public void finalizarPedido(Comanda comanda) 
	{
		repositorioCozinha.finalizarPedido(comanda);
	}

	public void cancelarPedido(Comanda comanda) 
	{
		repositorioCozinha.editarPedido(comanda);
	}
	
	public ArrayList<Comanda> listaPedidos() 
	{
		return repositorioCozinha.listaPedidos();
	}
	
}
