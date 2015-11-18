package com.autofood.produto;

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

import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;

public class RepositorioProdutoIO implements IRepositorioProduto {

	
	// Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioprodutoio.txt");
	//Path path = Paths.get("C:/Users/Longtech/git/AutoFood/files/repositorioprodutoio.txt");
	Path path = Paths.get("C:/Users/Vinicius/git/AutoFood/files/repositorioprodutoio.txt");

	Charset utf8 = StandardCharsets.UTF_8;

	public RepositorioProdutoIO() throws IOException {

		Files.createDirectories(path.getParent());

	}

	public void cadastra(Produto produto)
			throws ProdutoJáCadastradoException, NomeVazioException, SQLException, IOException {
		
		if (existi(produto.getCodigoProduto()))
			throw new ProdutoJáCadastradoException();
		if (produto.getNomeProduto().equals(null))
			throw new NomeVazioException();

		try (BufferedWriter arquivar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {

			arquivar.write(produto.getIdProduto() + ";" + produto.getCodigoProduto() + ";" + produto.getNomeProduto() + ";"
					+ produto.getQuantidadeProduto() + ";" + produto.getPrecoProduto() + ";"
					+ produto.getDataFabricacaoProduto() + ";" + produto.getValidadeProduto() + "\n");

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
		}

	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException, SQLException, IOException {

		ArrayList<Produto> arrayArquivo = listar();

		for (Produto produto1 : arrayArquivo) {
			if (produto1.getIdProduto() == (produto.getIdProduto())) {

				arrayArquivo.remove(produto1);
				arrayArquivo.add(produto);
				break;
			}
		}

		try (BufferedWriter apagar = Files.newBufferedWriter(path, utf8);) {

			apagar.write(" ");
		}
		for (Produto produto2 : arrayArquivo) {

			try (BufferedWriter arquivar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND);) {

				arquivar.write(produto.getIdProduto() + ";" + produto.getCodigoProduto() + ";" + produto.getNomeProduto() + ";"
						+ produto.getQuantidadeProduto() + ";" + produto.getPrecoProduto() + ";"
						+ produto.getDataFabricacaoProduto() + ";" + produto.getValidadeProduto() + "\n");

			}
		}
	}

	public void remover(String codigoProduto) throws ProdutoNaoEncontradoException, SQLException, IOException {

		ArrayList<Produto> arrayArquivo = listar();

		for (Produto produto : arrayArquivo) {
			if (produto.getCodigoProduto().equals((codigoProduto))) {
				arrayArquivo.remove(produto);
				break;
			}

			try (BufferedWriter apagar = Files.newBufferedWriter(path, utf8)) {

				apagar.write(" ");
			}

			for (Produto produto1 : arrayArquivo) {
				try (BufferedWriter arquivar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND)) {

				arquivar.write(produto.getIdProduto() + ";" + produto.getCodigoProduto() + ";" + produto.getNomeProduto() + ";"
						+ produto.getQuantidadeProduto() + ";" + produto.getPrecoProduto() + ";"
						+ produto.getDataFabricacaoProduto() + ";" + produto.getValidadeProduto() + "\n");

				}
			}
		}

	}

	public Produto procurar(String codigoProduto) throws ProdutoNaoEncontradoException, SQLException, IOException {

		ArrayList<Produto> arrayArquivo = listar();

		for (Produto produto : arrayArquivo) {
			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return produto;
			}
		}

		throw new ProdutoNaoEncontradoException();
	}

	public Boolean existi(String codigoProduto) throws SQLException, IOException {

		ArrayList<Produto> arrayArquivo = listar();
		
		for (Produto produto : arrayArquivo) {
			if (produto.getCodigoProduto().equals(codigoProduto)) {

				return true;
			}
		}

		return false;
	}

	public ArrayList<Produto> listar() throws SQLException, IOException {
		
		ArrayList<Produto> arrayArquivo = new ArrayList<Produto>();
		
		try(BufferedReader leitura = Files.newBufferedReader(path,utf8)){
			
			String contandoLinhas = null;
			Integer index = 1;
			
			while((contandoLinhas = leitura.readLine()) != null){
				
				String[] lista = contandoLinhas.split(";");
				
				Produto produto = new Produto(index,lista[1],lista[2],Integer.parseInt(lista[3]),Double.parseDouble(lista[4]),lista[5],lista[6]);
				index++;
				arrayArquivo.add(produto);	
				
				}
			
		return arrayArquivo;
		
		}
	}
}