package com.autofood.caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;

public class RepositorioCaixaJdbc implements IRepositorioCaixa {

	private boolean caixa;
	private Connection conn;

	public RepositorioCaixaJdbc() throws ClassNotFoundException {
		conn = ConectaBd.conectabd();
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
	public void entradaCaixa(Caixa entradaCaixa) throws SQLException {
		if(caixa){
		String sql = "insert into caixateste( entrada,saida,idcomanda,idfuncionario)values(?,?,?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);

		pst.setDouble(1, entradaCaixa.getEntrada());
		pst.setDouble(2, entradaCaixa.getSaida());
		pst.setInt(3, entradaCaixa.getIdComanda());
		pst.setInt(4, entradaCaixa.getIdFuncionario());

		pst.execute();
		}
	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) throws SQLException {
		if(caixa){
		String sql = "insert into caixateste(entrada,saida,idcomanda,idfuncionario)values(?,?,?,?)";

		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setDouble(1, saidaCaixa.getEntrada());
		pst.setDouble(2, saidaCaixa.getSaida());
		pst.setInt(3, saidaCaixa.getIdComanda());
		pst.setInt(4, saidaCaixa.getIdFuncionario());

		pst.execute();
		}
	}

	@Override
	public ArrayList<Caixa> movimentoDiario() throws SQLException {
		ArrayList<Caixa> array = new ArrayList<Caixa>();
		String sql = "select *from caixateste";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
		double entrada = rs.getDouble(2);
		double saida = rs.getDouble(3);
		int idcomanda = rs.getInt(4);
		int idfuncionario = rs.getInt(5);
		
		Caixa caixa = new Caixa(entrada,saida,idcomanda,idfuncionario);
		array.add(caixa);
		}
		
		return array;
	}

}
