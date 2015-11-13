package com.autofood.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.autofood.estoque.Estoque;
import com.autofood.exceçõesEstoque.ProdutoEstoqueNaoEncontradoException;
import com.autofood.exceçõesEstoque.ProdutoJaCadastradoEstoqueException;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;
import com.autofood.fachada.Fachada;
import com.autofood.produto.Produto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFEstoque {

	private JFrame frame;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtValidade;
	private JTextField txtProduto;
	private JTextField txtCodigo;
	private JTextField txtDataEntrada;
	private JPanel panelListar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panelBotoes;
	private Integer codigoselecao;
	private DefaultTableModel defultTabelaEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFEstoque window = new JFEstoque();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JFEstoque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelDados = new JPanel();
		panelDados.setToolTipText("");
		panelDados.setBorder(new TitledBorder(UIManager

		.getBorder("TitledBorder.border"), "Cadastro Produtos",

		TitledBorder.LEADING, TitledBorder.TOP, null,

		new Color(0, 0, 0)));
		panelDados.setBackground(SystemColor.menu);
		panelDados.setBounds(10, 11, 615, 164);
		frame.getContentPane().add(panelDados);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade\r\n");

		JLabel lblPreco = new JLabel("Pre\u00E7o Custo");

		txtPreco = new JTextField();
		txtPreco.setColumns(10);

		JLabel lblValidade = new JLabel("Validade");

		txtValidade = new JTextField();
		txtValidade.setColumns(10);

		txtProduto = new JTextField();
		txtProduto.setColumns(10);

		JLabel lblProduto = new JLabel("Produto");

		JLabel lblCodigo = new JLabel("Codigo:");

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);

		txtDataEntrada = new JTextField();
		txtDataEntrada.setColumns(10);

		JLabel lblDataFabricacao = new JLabel("Data Entrada");
		GroupLayout gl_panelDados = new GroupLayout(panelDados);
		gl_panelDados
				.setHorizontalGroup(gl_panelDados
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 605, Short.MAX_VALUE)
						.addGroup(
								gl_panelDados
										.createSequentialGroup()
										.addGap(4)
										.addGroup(
												gl_panelDados
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtQuantidade,
																								GroupLayout.PREFERRED_SIZE,
																								154,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblQuantidade,
																								GroupLayout.PREFERRED_SIZE,
																								71,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								lblPreco,
																								GroupLayout.PREFERRED_SIZE,
																								118,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtPreco,
																								GroupLayout.PREFERRED_SIZE,
																								118,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(36)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblValidade,
																								GroupLayout.PREFERRED_SIZE,
																								71,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtValidade,
																								GroupLayout.PREFERRED_SIZE,
																								197,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtProduto,
																								GroupLayout.PREFERRED_SIZE,
																								335,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_panelDados
																										.createSequentialGroup()
																										.addGroup(
																												gl_panelDados
																														.createParallelGroup(
																																Alignment.TRAILING)
																														.addGroup(
																																gl_panelDados
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblProduto,
																																				GroupLayout.PREFERRED_SIZE,
																																				71,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(91))
																														.addGroup(
																																gl_panelDados
																																		.createSequentialGroup()
																																		.addComponent(
																																				lblCodigo)
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)))
																										.addComponent(
																												txtCodigo,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								txtDataEntrada)
																						.addComponent(
																								lblDataFabricacao,
																								GroupLayout.PREFERRED_SIZE,
																								136,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(65, Short.MAX_VALUE)));
		gl_panelDados
				.setVerticalGroup(gl_panelDados
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 164, Short.MAX_VALUE)
						.addGroup(
								gl_panelDados
										.createSequentialGroup()
										.addGroup(
												gl_panelDados
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addGap(28)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblProduto)
																						.addComponent(
																								lblDataFabricacao)))
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								txtCodigo,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblCodigo))))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_panelDados
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtProduto,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																txtDataEntrada,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_panelDados
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addComponent(
																				lblQuantidade)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtQuantidade,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_panelDados
																		.createSequentialGroup()
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								lblPreco)
																						.addComponent(
																								lblValidade))
																		.addGap(1)
																		.addGroup(
																				gl_panelDados
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								txtPreco,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								txtValidade,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addGap(83)));
		panelDados.setLayout(gl_panelDados);

		panelListar = new JPanel();
		panelListar.setBounds(10, 175, 615, 239);
		frame.getContentPane().add(panelListar);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {

		});
		GroupLayout gl_panelListar = new GroupLayout(panelListar);
		gl_panelListar.setHorizontalGroup(gl_panelListar.createParallelGroup(
				Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE));
		gl_panelListar.setVerticalGroup(gl_panelListar.createParallelGroup(
				Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int linhaselecionada = table.getSelectedRow();

				String ccodigoselecao = table.getValueAt(linhaselecionada, 0)
						.toString();
				codigoselecao = Integer.parseInt(ccodigoselecao);

			}
		});
		String colunastabelaEstoque[] = new String[] { "Codigo", "Produto",
				"Quantidade", "Preco Custo", "Data Entrada", "Validade" };
		defultTabelaEstoque = new DefaultTableModel(new Object[][] {},
				colunastabelaEstoque) {

			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};

		table.setModel(defultTabelaEstoque);
		scrollPane.setViewportView(table);
		panelListar.setLayout(gl_panelListar);

		panelBotoes = new JPanel();
		panelBotoes.setBounds(10, 416, 615, 57);
		frame.getContentPane().add(panelBotoes);
		panelBotoes.setLayout(null);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnCadastrar.setBounds(10, 23, 100, 23);
		panelBotoes.add(btnCadastrar);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(120, 23, 89, 23);
		panelBotoes.add(btnAtualizar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(219, 23, 89, 23);
		panelBotoes.add(btnEditar);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(318, 23, 89, 23);
		panelBotoes.add(btnRemover);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setBounds(417, 23, 89, 23);
		panelBotoes.add(btnProcurar);

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setBounds(516, 23, 89, 23);
		panelBotoes.add(btnListar);
	}

	private void procurar() {

		Integer id = Integer.parseInt(txtCodigo.getText());

		try {
			Estoque estoque = Fachada.getInstance().procurarEstoque(id);
			listar(estoque);

			txtCodigo.setText("");

		} catch (ClassNotFoundException | SQLException | IOException | ProdutoEstoqueNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void remover() {

		try {
			Fachada.getInstance().removerEstoque(codigoselecao);
			listar();

		} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException | ProdutoEstoqueNaoEncontradoException e) {

			e.printStackTrace();
		}

	}

	private void listar(Estoque estoque) throws ClassNotFoundException,
			SQLException {
		this.limparTabelaEstoque();

		Vector vector = new Vector();
		vector.add(estoque.getIdEstoqueProduto());
		vector.add(estoque.getNomeProdutoEstoque());
		vector.add(estoque.getQuantidadeProdutoEstoque());
		vector.add(estoque.getPrecoCustoProdutoEstoque());
		vector.add(estoque.getDataValidadeProdutoEstoque());
		vector.add(estoque.getDataEntradaProdutoEstoque());
		

		defultTabelaEstoque.addRow(vector);

	}

	private void listar() throws ClassNotFoundException, SQLException,
			IOException {
		this.limparTabelaEstoque();
		ArrayList<Estoque> estoques = Fachada.getInstance().listarEstoque();
		for (Estoque estoque : estoques) {
			Vector vector = new Vector();
			vector.add(estoque.getIdEstoqueProduto());
			vector.add(estoque.getNomeProdutoEstoque());
			vector.add(estoque.getQuantidadeProdutoEstoque());
			vector.add(estoque.getPrecoCustoProdutoEstoque());
			vector.add(estoque.getDataValidadeProdutoEstoque());
			vector.add(estoque.getDataEntradaProdutoEstoque());

			defultTabelaEstoque.addRow(vector);
		}
	}

	private void limparTabelaEstoque() {
		defultTabelaEstoque.setNumRows(0);
	}

	private void cadastrar() {
		// Entrada de dados Pessoais
		String produto = txtProduto.getText();
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		Double preco = Double.parseDouble(txtPreco.getText());
		String validade = txtValidade.getText();
		String datafabricacao = txtDataEntrada.getText();

		Estoque estoque = new Estoque(produto,quantidade,validade,datafabricacao,preco);
		try {
			Fachada.getInstance().cadastraEstoque(estoque);
			limpar();
		} catch (ClassNotFoundException | SQLException | IOException |ProdutoJaCadastradoEstoqueException | com.autofood.exceçõesEstoque.NomeVazioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editar() {

		try {
			Estoque estoque = Fachada.getInstance().procurarEstoque(codigoselecao);

			Integer codigo = estoque.getIdEstoqueProduto();
			String nome = estoque.getNomeProdutoEstoque();
			Integer quantidade = estoque.getQuantidadeProdutoEstoque();
			Double preco = estoque.getPrecoCustoProdutoEstoque();
			String validade = estoque.getDataValidadeProdutoEstoque();
			String data = estoque.getDataEntradaProdutoEstoque();

			txtCodigo.setText(codigo.toString());
			txtProduto.setText(nome);
			txtQuantidade.setText(quantidade.toString());
			txtPreco.setText(preco.toString());
			txtDataEntrada.setText(validade.toString());
			txtValidade.setText(data.toString());
			

		} catch (ClassNotFoundException |SQLException | IOException | ProdutoEstoqueNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void atualizar() {

		Integer codigo = Integer.parseInt(txtCodigo.getText());
		String produto = txtProduto.getText();
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		Double preco = Double.parseDouble(txtPreco.getText());
		String validade = txtValidade.getText();
		String dataEntrada = txtDataEntrada.getText();

		Estoque estoque = new Estoque(codigo,produto,quantidade,dataEntrada,validade,preco);

		try {
			Fachada.getInstance().atualizarEstoque(estoque);
			limpar();
			listar();
		} catch (ClassNotFoundException | SQLException | IOException | ProdutoEstoqueNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void limpar() {
		// campos dados cliente

		txtCodigo.setText("");
		txtProduto.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		txtValidade.setText("");
		txtDataEntrada.setText("");

	}

}
