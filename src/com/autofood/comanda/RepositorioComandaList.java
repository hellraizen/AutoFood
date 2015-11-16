package com.autofood.comanda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioComandaList implements IRepositorioComanda {

	private ArrayList<Comanda> arrayComandaList;
	private ArrayList<Comanda> arrayComandaListConstante;
	private Integer indexComanda;
	private int index;

	public RepositorioComandaList() {
		arrayComandaList = new ArrayList<Comanda>();
		arrayComandaListConstante = new ArrayList<Comanda>();
		indexComanda = 1;
		index = 1;
	}

	@Override
	public void realizarPedido(Comanda comanda) {
		comanda.setNumeroVenda(index);
		index++;
		comanda.setIdComanda(indexComanda);
		arrayComandaList.add(comanda);
		arrayComandaListConstante.add(comanda);

	}

	


	@Override
	public void cancelarPedido(Integer numeroVenda) {
		for (Comanda comanda : arrayComandaList) {
			if (numeroVenda == comanda.getNumeroVenda()) {
				arrayComandaList.remove(comanda);
				arrayComandaListConstante.remove(comanda);
				JOptionPane.showMessageDialog(null, "Pedido Removido com Sucesso");
			}
		}

	}

	@Override
	public void finalizarPedido() {
		arrayComandaList.clear();
		indexComanda++;
	}

	@Override
	public ArrayList<Comanda> listar() {

		return arrayComandaList;
	}

	@Override
	public ArrayList<Comanda> listarMontante() {

		return arrayComandaListConstante;
	}

}
