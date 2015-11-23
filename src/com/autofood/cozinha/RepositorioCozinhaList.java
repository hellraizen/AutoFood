package com.autofood.cozinha;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.autofood.comanda.Comanda;

public class RepositorioCozinhaList implements IRepositorioCozinha {

	private ArrayList<Comanda> arrayComanda ;
	private String pedido;
	private Integer idPedido;

	public RepositorioCozinhaList() {
		arrayComanda = new ArrayList<Comanda>();
		this.idPedido = 1;
	}

	@Override
	public void finalizarPedido(Comanda comanda) {
		for (int i = 0; i < idPedido; i++) {
			if (idPedido > 0) {
				ArrayList<Comanda> comparaComanda = new ArrayList<Comanda>();

				for (Comanda comanda2 : comparaComanda) {

					if (comanda.getIdComanda() == comanda2.getIdComanda()) {
						
						comparaComanda.remove(comanda);
						
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
						
						comparaComanda.remove(comanda2);
						comparaComanda.add(comanda);
						
						System.out.println( pedido + "\nPEDIDO CANCELADO!");
						JOptionPane.showInternalMessageDialog(null, "PEDIDO CANCELADO!");
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
			return arrayComanda;
	}

}
