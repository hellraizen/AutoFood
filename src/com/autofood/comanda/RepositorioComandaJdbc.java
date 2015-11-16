package com.autofood.comanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.ConectaBd;

public class RepositorioComandaJdbc implements IRepositorioComanda {
	Integer indexComanda;
	Connection conn;
	ArrayList<Comanda> arrayComanda;

	public RepositorioComandaJdbc() throws ClassNotFoundException {
		indexComanda= 1;
		arrayComanda = new ArrayList <Comanda>();
		this.conn = ConectaBd.conectabd(); 
	}

	@Override
	public void realizarPedido(Comanda comanda) throws SQLException {
		comanda.setIdComanda(indexComanda);
		arrayComanda.add(comanda);
		
		String sql = "insert into (comandaid,nomeCliente,descricao,quantidadeVendida,valor,totalvalor) values(?,?,?,?,?,?)";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, comanda.getIdComanda());
		pst.setString(2, comanda.getNomeCliente());
		pst.setString(3, comanda.getProduto());
		pst.setInt(4, comanda.getQuantidade());
		pst.setDouble(5,comanda.getValor());
		pst.setDouble(6,comanda.getTotal());
		
		pst.execute();
		
		
	}

	@Override
	public void cancelarPedido(Integer idProduto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finalizarPedido() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Comanda> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Comanda> listarMontante() {
		// TODO Auto-generated method stub
		return null;
	}

}
