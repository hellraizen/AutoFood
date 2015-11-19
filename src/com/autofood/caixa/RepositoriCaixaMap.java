package com.autofood.caixa;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;



public class RepositoriCaixaMap implements IRepositorioCaixa{
	
	private HashMap<Integer, Caixa> arrayMap;
	private Integer index;
	private boolean caixa;
	
	public RepositoriCaixaMap() {
	arrayMap = new HashMap<Integer,Caixa>();
	index = 1;
	caixa = false;
	}
	
	@Override
	public boolean abrirCaixa() {
		if (caixa == false) {
			caixa = true;
			JOptionPane.showMessageDialog(null, "Caixa aberto");
			return true;
		}
		return false;
	}

	@Override
	public boolean fecharCaixa() {
		if (caixa) {
			caixa = false;
			JOptionPane.showMessageDialog(null, "Caixa Fechado");
		}
		return true;

	}

	@Override
	public void entradaCaixa(Caixa entradaCaixa) {
		if(caixa){
			arrayMap.put(index, entradaCaixa);
			index++;
		}
		
	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) {
		if(caixa){
			arrayMap.put(index, saidaCaixa);
			index++;
		}
		
	}

	@Override
	public ArrayList<Caixa> movimentoDiario() {
		ArrayList<Caixa> array = new ArrayList<Caixa>();
		for (int i = 1; i < index; i++) {
			Caixa caixa = arrayMap.get(i);
			array.add(caixa);
		}
		return array;
	}

}
