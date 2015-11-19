package com.autofood.caixa;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCaixa {
	

	public boolean abrirCaixa();

	public boolean fecharCaixa();

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException;

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException;

	public ArrayList<Caixa> movimentoDiario() throws SQLException;

}
