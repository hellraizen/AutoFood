package com.autofood.comanda;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioComandaList implements IRepositorioComanda {

	private ArrayList<Comanda> arrayComandaList;
	private Integer indexComanda;

	public RepositorioComandaList() {
		arrayComandaList = new ArrayList<Comanda>();
		indexComanda = 1;
	}

	@Override
	public void realizarPedido(Comanda comanda) {
		comanda.setIdComanda(indexComanda);
		arrayComandaList.add(comanda);

	}

	@Override
	public void alterarPedido(Comanda idProduto) {
		for (Comanda comanda : arrayComandaList) {
			if (idProduto.getIdProduto() == comanda.getIdProduto()) {
				arrayComandaList.remove(comanda);
				arrayComandaList.add(idProduto);
				JOptionPane.showMessageDialog(null, "Pedido Alterado com Sucesso");

			}
		}

	}

	@Override
	public void cancelarPedido(Integer idProduto) {
		for (Comanda comanda : arrayComandaList) {
			if (idProduto == comanda.getIdProduto()) {
				arrayComandaList.remove(comanda);
				JOptionPane.showMessageDialog(null, "Pedido Removido com Sucesso");
			}
		}

	}

	@Override
	public void finalizarPedido() {
		indexComanda++;
	}

	@Override
	public ArrayList<Comanda> listar() {

		return arrayComandaList;
	}

}
