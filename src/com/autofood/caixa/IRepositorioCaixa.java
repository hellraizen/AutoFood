package com.autofood.caixa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IRepositorioCaixa {
	

	public boolean abrirCaixa();

	public boolean fecharCaixa();

	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException;

	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException;

	public ArrayList<Caixa> movimentoDiario() throws SQLException, IOException;

}
