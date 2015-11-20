package com.autofood.caixa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RepositorioCaixaIO implements IRepositorioCaixa {

	private Path path = Paths.get("/AutoFood/files/repositorioiocaixa.txt");
	private Charset utf8 = StandardCharsets.UTF_8;
	private Boolean caixa;

	public RepositorioCaixaIO() throws IOException {
		Files.createDirectories(path.getParent());
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
	public void entradaCaixa(Caixa entradaCaixa) throws SQLException, IOException {
		if (caixa) {
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND)) {
				escrever.write(entradaCaixa.getEntrada() + ";" + entradaCaixa.getIdComanda() + ";"
						+ entradaCaixa.getIdFuncionario() + "\n");
			}
		}

	}

	@Override
	public void saidaCaixa(Caixa saidaCaixa) throws SQLException, IOException {
		if (caixa) {
			try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,StandardOpenOption.APPEND)) {
				escrever.write(saidaCaixa.getSaida() + ";" + saidaCaixa.getIdComanda() + ";"
						+ saidaCaixa.getIdFuncionario() + "\n");
			}
		}

	}

	@Override
	public ArrayList<Caixa> movimentoDiario() throws SQLException, IOException {
		ArrayList <Caixa> array = new ArrayList<Caixa>();
		
		try(BufferedReader ler = Files.newBufferedReader(path,utf8)){
			String linha= null;
			while((linha = ler.readLine())!= null){
				
				String[] dados = linha.split(";");
				
				double entrada = Double.parseDouble(dados[0]);
				double saida =Double.parseDouble(dados[1]);
				int idcomanda = Integer.parseInt(dados[2]);
				int idfuncionario = Integer.parseInt(dados[3]);
				
				Caixa caixa = new Caixa(entrada,saida,idcomanda,idfuncionario);
				array.add(caixa);
				
				
			}
			
		}
		
		return array;
	}

}
