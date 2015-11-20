package com.autofood.estoque;

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
import com.autofood.exceçõesEstoque.NomeVazioException;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;

public class RepositorioEstoqueIO implements IRepositorioEstoque {

	// Path path = Paths.get("C:/Users/Alternativo8/git/AutoFood/files/repositorioioEstoque.txt");
	//Path path = Paths.get("C:/Users/Longtech/git/AutoFood/files/repositorioioEstoque.txt");
	Path path = Paths.get("C:/Users/Vinicius/git/AutoFood/files/repositorioioEstoque.txt");

	Charset utf8 = StandardCharsets.UTF_8;

	public RepositorioEstoqueIO() throws IOException {

		Files.createDirectories(path.getParent());

	}

	public void cadastra(Estoque estoque) throws NomeVazioException,
			ProdutoJaCadastradoEstoqueException, SQLException, IOException {
		if (existi(estoque.getCodigoProduto()))
			throw new ProdutoJaCadastradoEstoqueException();
		if (estoque.getNomeProdutoEstoque().equals(null))
			throw new NomeVazioException();

		try (BufferedWriter escrever = Files.newBufferedWriter(path, utf8,
				StandardOpenOption.APPEND);) {

			escrever.write(estoque.getIdEstoqueProduto() + ";"
					+ estoque.getCodigoProduto() + ";"
					+ estoque.getNomeProdutoEstoque() + ";"
					+ estoque.getQuantidadeProdutoEstoque() + ";"
					+ estoque.getDataEntradaProdutoEstoque() + ";"
					+ estoque.getDataValidadeProdutoEstoque() + ";"
					+ estoque.getPrecoCustoProdutoEstoque() + "\n");

			JOptionPane.showMessageDialog(null,
					"Cadastro realizado com sucesso");

		}

	}

	public void atualizar(Estoque estoque)
			throws ProdutoEstoqueNaoEncontradoException, SQLException,
			IOException {

		ArrayList<Estoque> arraylocal = listar();

		for (Estoque estoque2 : arraylocal) {
			if (estoque2.getCodigoProduto().equals(estoque.getCodigoProduto())) {

				arraylocal.remove(estoque2);
				arraylocal.add(estoque);
				break;
			}

		}

		try (BufferedWriter apagar = Files.newBufferedWriter(path, utf8);) {

			apagar.write(" ");

		}

		for (Estoque estoque3 : arraylocal) {

			try (BufferedWriter arquivar = Files.newBufferedWriter(path, utf8,
					StandardOpenOption.APPEND);) {

				arquivar.write(estoque3.getIdEstoqueProduto() + ";"
						+ estoque3.getCodigoProduto() + ";"
						+ estoque3.getNomeProdutoEstoque() + ";"
						+ estoque3.getQuantidadeProdutoEstoque() + ";"
						+ estoque3.getDataEntradaProdutoEstoque() + ";"
						+ estoque3.getDataValidadeProdutoEstoque() + ";"
						+ estoque3.getPrecoCustoProdutoEstoque() + "\n");

			}

		}

		JOptionPane.showMessageDialog(null,
				"Produto em estoque atualizado com sucesso");

	}

	public void remover(String codigoProduto)
			throws ProdutoEstoqueNaoEncontradoException, SQLException,
			IOException {

		ArrayList<Estoque> arraylocal = listar();

		for (Estoque estoque : arraylocal) {
			if (estoque.getCodigoProduto().equals(codigoProduto)) {

				arraylocal.remove(estoque);

			}
		}

		try (BufferedWriter apagar = Files.newBufferedWriter(path, utf8);) {

			apagar.write(" ");

		}

		for (Estoque estoque1 : arraylocal) {

			try (BufferedWriter arquivar = Files.newBufferedWriter(path, utf8,
					StandardOpenOption.APPEND);) {

				arquivar.write(estoque1.getIdEstoqueProduto() + ";"
						+ estoque1.getCodigoProduto() + ";"
						+ estoque1.getNomeProdutoEstoque() + ";"
						+ estoque1.getQuantidadeProdutoEstoque() + ";"
						+ estoque1.getDataEntradaProdutoEstoque() + ";"
						+ estoque1.getDataValidadeProdutoEstoque() + ";"
						+ estoque1.getPrecoCustoProdutoEstoque() + "\n");

			}
		}

		JOptionPane.showMessageDialog(null, "Produto removido com sucesso");

	}

	public Estoque procurar(String codigoProduto)
			throws ProdutoEstoqueNaoEncontradoException, SQLException,
			IOException {
		ArrayList<Estoque> arrayArquivo = listar();

		for (Estoque estoque : arrayArquivo) {
			if (estoque.getCodigoProduto().equals(codigoProduto)) {

				return estoque;

			}
		}

		throw new ProdutoEstoqueNaoEncontradoException();
	}

	public Boolean existi(String codigoProduto) throws SQLException,
			IOException {
		ArrayList<Estoque> arrayArquivo = listar();

		for (Estoque estoque : arrayArquivo) {
			if (estoque.getCodigoProduto().equals(codigoProduto)) {

				return true;

			}
		}

		return false;
	}

	public ArrayList<Estoque> listar() throws SQLException, IOException {

		ArrayList<Estoque> arrayArquivo = new ArrayList<Estoque>();

		try (BufferedReader leitura = Files.newBufferedReader(path, utf8);) {

			String linhas = null;
			Integer index = 1;
			while ((linhas = leitura.readLine()) != null) {

				String[] arquivos = linhas.split(";");

				Estoque estoque = new Estoque(index, arquivos[1], arquivos[2],
						Integer.parseInt(arquivos[3]), (arquivos[4]),
						arquivos[5], Double.parseDouble(arquivos[6]));
				index++;
				arrayArquivo.add(estoque);

			}

			return arrayArquivo;

		}
	}
}
