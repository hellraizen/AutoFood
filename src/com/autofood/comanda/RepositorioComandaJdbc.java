package com.autofood.comanda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		String sql = "insert into comandateste(comandaid,nomeCliente,descricao,quantidadeVendida,valor,totalvalor) values(?,?,?,?,?,?)";
		
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
	public void cancelarPedido(Integer idProduto) throws SQLException {
		for (Comanda comanda : arrayComanda) {
			if (idProduto == comanda.getNumeroVenda()) {
				arrayComanda.remove(comanda);
			}
		}
		
		String sql= "delete from comandateste where vendaID = ?";
		
		PreparedStatement pst = conn.prepareStatement(sql);
		
		pst.setInt(1, idProduto );
		
		pst.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "REMOVIDO COM SUCESSO");

	}

	@Override
	public void finalizarPedido() {
	 arrayComanda.clear();
	 indexComanda++;
	 

	}

	@Override
	public ArrayList<Comanda> listar() {
		
		return arrayComanda;
	}

	@Override
	public ArrayList<Comanda> listarMontante() throws SQLException {
		
		ArrayList<Comanda> array = new ArrayList<Comanda>();
		
		String sql= "select * from comandatest";
		
		PreparedStatement pst = conn.prepareStatement(sql); 
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()){
			
			int idvenda = rs.getInt(1);
			int idComanda = rs.getInt(2);
			String nomeC = rs.getString(3);
			String descricao = rs.getString(4);
			int quantidade = rs.getInt(5);
			double valorU = rs.getDouble(6);
			double total = rs.getDouble(7);
			
			Comanda comanda = new Comanda(nomeC, idvenda, descricao, valorU, quantidade, total);
			comanda.setIdComanda(idComanda);
			
			array.add(comanda);
		}
		return array;
	}

}
