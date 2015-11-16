package com.autofood.comanda;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;



public class RepositorioComandaSet implements IRepositorioComanda{
	
	private HashSet<Comanda> arrayComandaSet;
	private HashSet<Comanda> arrayComandaSetConstante;
	private Integer indexComanda;
	private int index;
	
	public RepositorioComandaSet() {
		arrayComandaSet= new HashSet<Comanda>();
		arrayComandaSetConstante = new HashSet<Comanda>();
		index=1;
		indexComanda=1;
	}
	

	@Override
	public void realizarPedido(Comanda comanda) {
		comanda.setIdComanda(indexComanda);
		comanda.setNumeroVenda(index);
		arrayComandaSet.add(comanda);
		arrayComandaSetConstante.add(comanda);
		index ++;
		
		
	}



	@Override
	public void cancelarPedido(Integer idProduto) {
		for (Comanda comanda : arrayComandaSet) {
			if(idProduto == comanda.getNumeroVenda()){
				arrayComandaSet.remove(comanda);
				arrayComandaSetConstante.remove(comanda);
				JOptionPane.showMessageDialog(null, "Pedido Removido com Sucesso");
			}
		}
		
	}

	@Override
	public void finalizarPedido() {
		arrayComandaSet.clear();
		indexComanda++;
		
		
	}

	@Override
	public ArrayList<Comanda> listar() {
		ArrayList<Comanda> array = new ArrayList<Comanda>();
		for (Comanda comanda : arrayComandaSet) {
			array.add(comanda);
		}
		return array;
	}

	@Override
	public ArrayList<Comanda> listarMontante() {
		ArrayList<Comanda> arrayC = new ArrayList<Comanda>();
		for (Comanda comanda : arrayComandaSetConstante) {
			arrayC.add(comanda);
		}
		return arrayC;
	}

}
