package com.autofood.cozinha;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.JOptionPane;

import com.autofood.comanda.Comanda;

public class RepositorioCozinhaSet implements IRepositorioCozinha {

	HashSet<Comanda> arrayCozinhaSet;
	String pedido;
	Integer idPedido;
	
	
	public RepositorioCozinhaSet() 
	{
		this.arrayCozinhaSet = new HashSet<Comanda>();
		this.idPedido = 1;
	}
	
	@Override
	public void finalizarPedido(Comanda comanda) 
	{
		for (int i = 0; i < idPedido; i++) {
			if (idPedido > 0) {
				ArrayList<Comanda> comparaComanda = new ArrayList<Comanda>();

				for (Comanda comanda2 : comparaComanda) {

					if (comanda.getIdComanda() == comanda2.getIdComanda()) {
						
						arrayCozinhaSet.remove(comanda);
						
						System.out.println( pedido + "\nPEDIDO FINALIZADO!");
						JOptionPane.showInternalMessageDialog(null, "PEDIDO FINALIZADO!");
					}

				}

			} else {
				JOptionPane.showInternalMessageDialog(null, "COMANDA INVÁLIDA OU NÃO EXISTE!");
				System.out.println("COMANDA INVÁLIDA OU NÃO EXISTE!");
			}
		}

	}

	@Override
	public void editarPedido(Comanda comanda) 
	{
		
		for (int i = 0; i < idPedido; i++) {
			if (idPedido > 0) {
				ArrayList<Comanda> comparaComanda = new ArrayList<Comanda>();

				for (Comanda comanda2 : comparaComanda) {

					if (comanda.getIdComanda() == comanda2.getIdComanda()) {
						
						arrayCozinhaSet.remove(comanda2);
						arrayCozinhaSet.add(comanda);
						
						System.out.println( pedido + "\nPEDIDO ATUALIZADO!");
						JOptionPane.showInternalMessageDialog(null, "PEDIDO ATUALIZADO!");
					}

				}

			} else {
				JOptionPane.showInternalMessageDialog(null, "COMANDA INVÁLIDA OU NÃO EXISTE!");
				System.out.println("COMANDA INVÁLIDA OU NÃO EXISTE!");
			}
		}
		
		
	}

	@Override
	public ArrayList<Comanda> listaPedidos() 
	{
		
		ArrayList<Comanda> comandArraySet = new ArrayList<Comanda>();
		
		for(int i = 1; i < idPedido; i++)
		{
			Comanda comanda = ((List<Comanda>) arrayCozinhaSet).get(i);
			comandArraySet.add(comanda);
		}
		
		return comandArraySet;
	}
		
}
