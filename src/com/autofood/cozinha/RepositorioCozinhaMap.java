package com.autofood.cozinha;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.autofood.comanda.Comanda;

public class RepositorioCozinhaMap implements IRepositorioCozinha {

	private HashMap<Integer, Comanda> arrayComandaMap ;
	private String pedido;
	private Integer idPedido;

	public RepositorioCozinhaMap() 
	{
		this.arrayComandaMap = new HashMap<Integer, Comanda>();
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
						
						arrayComandaMap.remove(comanda);
						
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
						
						arrayComandaMap.remove(comanda2);
						arrayComandaMap.put(idPedido ,comanda);
						
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
		
		ArrayList<Comanda> comandasArray = new ArrayList<Comanda>();
		
		for(int i = 1; i < idPedido; i++)
		{
			Comanda comanda = arrayComandaMap.get(i);
			comandasArray.add(comanda);
		}
		
		return comandasArray;
	}

}
