package com.autofood.caixa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


public class ControladorCaixa {

	private IRepositorioCaixa repositorioCaixa;

	public ControladorCaixa() throws IOException, ClassNotFoundException {
		repositorioCaixa = new RepositorioCaixaList();
		//repositorioCaixa = new RepositorioCaixaSet();
		//repositorioCaixa = new RepositoriCaixaMap();
		//repositorioCaixa = new RepositorioCaixaIO();
		//repositorioCaixa = new RepositorioCaixaJdbc();
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
