package com.autofood.comanda;

import java.util.ArrayList;
import java.util.HashMap;


import javax.swing.JOptionPane;

public class RepositorioComandaMap  implements IRepositorioComanda{
	
	ArrayList <Comanda> arrayComandaMap;
	HashMap<Integer, Comanda> arrayComandaMapCon;
	Integer indexComanda;
	Integer index;
	
	public RepositorioComandaMap() {
		arrayComandaMap = new ArrayList<Comanda>();
		arrayComandaMapCon = new HashMap<Integer,Comanda>();
		indexComanda=1;
		index=1;
	}

	@Override
	public void realizarPedido(Comanda comanda) {
		comanda.setNumeroVenda(index);
		comanda.setIdComanda(indexComanda);
		arrayComandaMapCon.put(index, comanda);
		arrayComandaMap.add(comanda);
		index++;
		
	}

	@Override
	public void cancelarPedido(Integer idProduto) {
	
		for(int i =1 ; i < index; i ++){
			Comanda comanda = arrayComandaMap.get(i);
			if(idProduto == comanda.getNumeroVenda()){
				
				arrayComandaMap.remove(i);
				arrayComandaMapCon.remove(i);
				JOptionPane.showMessageDialog(null, "Pedido Removido com Sucesso");
				break;
			}
		}
		
		
	}

	@Override
	public void finalizarPedido() {
		arrayComandaMap.clear();
		indexComanda++;
		
		
	}

	@Override
	public ArrayList<Comanda> listar() {
	
			
		
		return arrayComandaMap;
	}

	@Override
	public ArrayList<Comanda> listarMontante() {
		ArrayList<Comanda> array = new ArrayList<Comanda>();
		for(int i =1 ; i < index ; i++){
			Comanda comanda = arrayComandaMapCon.get(i);
				array.add(comanda);
		
		}
		return array;
	}
}
