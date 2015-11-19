package com.autofood.comanda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;



public class RepositorioComandaIO implements IRepositorioComanda {

	//private Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/RepositorioIOComanda.txt");
	Path path = Paths.get("C:/Users/Vinicius/git/AutoFood/files/repositorioio.txt");

	private Charset utf8 = StandardCharsets.UTF_8;
	private ArrayList<Comanda> arrayComandaList;
	private Integer indexComanda;
	private int index;


	public RepositorioComandaIO() throws IOException {
		Files.createDirectories(path.getParent());
		arrayComandaList = new ArrayList<Comanda>();
		indexComanda=1;
		index = 1;
	}

	@Override
	public void realizarPedido(Comanda comanda) throws SQLException, IOException {
		comanda.setIdComanda(indexComanda);
		comanda.setNumeroVenda(index);
		arrayComandaList.add(comanda);
		index++;

		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8)) {
			escrever.write(comanda.getNomeCliente() + ";" + comanda.getProduto() + ";" + comanda.getIdComanda() + ";"
					+ comanda.getIdProduto() + ";" + comanda.getIdVenda() + ";" + comanda.getNumeroVenda() + ";"
					+ comanda.getQuantidade() + ";" + comanda.getTotal() + ";" + comanda.getValor() + ";"
					+ comanda.getData()+"\n");
			
			

		}

	}

	@Override
	public void cancelarPedido(Integer numeroVenda) throws SQLException {
		for (Comanda comanda : arrayComandaList) {
			if (numeroVenda == comanda.getNumeroVenda()) {
				arrayComandaList.remove(comanda);
			}
		}	

	}

	@Override
	public void finalizarPedido() {
		arrayComandaList.clear();
		indexComanda++;

	}

	@Override
	public ArrayList<Comanda> listar() {
		
		return arrayComandaList;
	}

	@Override
	public ArrayList<Comanda> listarMontante() throws SQLException, IOException {
		ArrayList<Comanda> arrayLocal = new ArrayList<Comanda>();
		try(BufferedReader ler = Files.newBufferedReader(path,utf8)){
			String linha = null;
			
			while ((linha = ler.readLine()) != null) {
				
				String[] dados = linha.split(";");
				
				String nomeCliente= dados[0];
				String produto= dados[1];
				double valor = Double.parseDouble(dados[8]);
				int idProduto = Integer.parseInt(dados[3]);
				int quantidade = Integer.parseInt(dados[6]);
				double total = Double.parseDouble(dados[7]);
						
				
				
			Comanda comanda = new Comanda(nomeCliente, idProduto, produto, valor, quantidade, total);
			arrayLocal.add(comanda);
			
			}
		}
		return arrayLocal;
	}

}
