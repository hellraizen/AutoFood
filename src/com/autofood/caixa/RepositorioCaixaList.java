package com.autofood.caixa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioCaixaList implements IRepositorioCaixa {

	private ArrayList<Caixa> arrayCaixaList;
	private Boolean caixa;

	public RepositorioCaixaList() {
		arrayCaixaList = new ArrayList<Caixa>();
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
			
			arrayCaixaList.add(entradaCaixa);
			System.out.println("Enviado ao Caixa");
		}

	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) {
		arrayCaixaList.add(saidaCaixa);
		System.out.println("Removido ao Caixa");

	}

	@Override
	public ArrayList<Caixa> movimentoDiario() {
		
		return arrayCaixaList;
	}

}
