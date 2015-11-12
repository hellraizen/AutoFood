package com.autofood.caixa;

import java.util.ArrayList;


public class ControladorCaixa {

	private IRepositorioCaixa repositorioCaixa;

	public ControladorCaixa() {
		repositorioCaixa = new RepositorioCaixaList();
	}

	public boolean abrirCaixa(Double dinheiroCaixa) {
		return repositorioCaixa.abrirCaixa(dinheiroCaixa);
	}

	public boolean fecharCaixa() {
		return repositorioCaixa.fecharCaixa();
	}

	public void entradaCaixa(Caixa entradaCaixa) {
		repositorioCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) {
		repositorioCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiario() {
		return repositorioCaixa.movimentoDiario();
	}
	
}
