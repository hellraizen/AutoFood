package com.autofood.caixa;

import java.util.ArrayList;

public interface IRepositorioCaixa {
	

	public boolean abrirCaixa();

	public boolean fecharCaixa();

	public void entradaCaixa(Caixa entradaCaixa);

	public void saidaCaixa(Caixa saidaCaixa);

	public ArrayList<Caixa> movimentoDiario();

}
