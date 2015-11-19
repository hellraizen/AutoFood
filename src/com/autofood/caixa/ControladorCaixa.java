package com.autofood.caixa;

import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorCaixa {

	private IRepositorioCaixa repositorioCaixa;

	public ControladorCaixa() {
		repositorioCaixa = new RepositorioCaixaList();
	}

	public boolean abrirCaixa() {
		return repositorioCaixa.abrirCaixa();
	}

	public boolean fecharCaixa() {
		return repositorioCaixa.fecharCaixa();
	}

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException {
		repositorioCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException {
		repositorioCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiario() throws SQLException {
		return repositorioCaixa.movimentoDiario();
	}
	
}
