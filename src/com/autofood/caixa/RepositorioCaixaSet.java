package com.autofood.caixa;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class RepositorioCaixaSet implements IRepositorioCaixa{
	
	private HashSet<Caixa> arrayCaixaSet;
	private Boolean caixa;
	
	public RepositorioCaixaSet() {
		arrayCaixaSet= new HashSet<Caixa>();
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
		if (caixa) {
			
			arrayCaixaSet.add(entradaCaixa);
			System.out.println("Enviado ao Caixa");
		}

	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) {
		arrayCaixaSet.add(saidaCaixa);
		System.out.println("Removido ao Caixa");

	}

	@Override
	public ArrayList<Caixa> movimentoDiario() {
		ArrayList<Caixa> array = new ArrayList<Caixa>();
		for (Caixa caixa : arrayCaixaSet) {
			array.add(caixa);
			
			
			
		}
		return array;
	}

}
