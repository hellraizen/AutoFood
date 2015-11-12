package com.autofood.caixa;

import java.util.ArrayList;

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
			
			return true;
		}
		return false;
	}

	@Override
	public boolean fecharCaixa() {
		if (caixa) {
			caixa = false;
		}
		return true;

	}

	@Override
	public void entradaCaixa(Caixa entradaCaixa) {
		if (caixa) {
			
			double total = entradaCaixa.getTotalCaixa();
			total += entradaCaixa.getEntrada();
			entradaCaixa.setTotalCaixa(total);
			arrayCaixaList.add(entradaCaixa);
		}

	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) {
		double total = saidaCaixa.getTotalCaixa();
		total -= saidaCaixa.getSaida();
		saidaCaixa.setTotalCaixa(total);
		arrayCaixaList.add(saidaCaixa);

	}

	@Override
	public ArrayList<Caixa> movimentoDiario() {
		
		return arrayCaixaList;
	}

}
