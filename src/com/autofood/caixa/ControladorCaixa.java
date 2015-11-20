package com.autofood.caixa;

import java.io.IOException;
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

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException {
		repositorioCaixa.entradaCaixa(entradaCaixa);
	}

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException {
		repositorioCaixa.saidaCaixa(saidaCaixa);
	}

	public ArrayList<Caixa> movimentoDiario() throws SQLException, IOException {
		return repositorioCaixa.movimentoDiario();
	}
	
}
