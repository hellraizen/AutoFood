	package com.autofood.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;
import com.autofood.fachada.Fachada;
import com.autofood.produto.Produto;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigoProduto;
	private JTextField txtProduto;
	private JTextField txtQuantidade;
	private JTextField txtDataFabricacao;
	private JTextField txtPreco;
	private JTextField txtValidade;
	private JTable tableProduto;
	private DefaultTableModel defultTabelaProduto;
	private String codigoselecao;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFProduto frame = new JFProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFProduto() {
		setTitle("Cadastro Produtos\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panelCadastroProduto = new JPanel();
		panelCadastroProduto.setToolTipText("");
		panelCadastroProduto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro Produtos",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastroProduto.setBackground(SystemColor.menu);

		JLabel lblProduto = new JLabel("Produto");

		txtProduto = new JTextField();
		txtProduto.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade\r\n");

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);

		JLabel lblDataFabricao = new JLabel("Data Fabrica\u00E7\u00E3o\r\n");

		txtDataFabricacao = new JTextField();
		txtDataFabricacao.setColumns(10);

		JLabel lblPreo = new JLabel("Pre\u00E7o");

		txtPreco = new JTextField();
		txtPreco.setColumns(10);

		JLabel lblValidade = new JLabel("Validade");

		txtValidade = new JTextField();
		txtValidade.setColumns(10);

		txtcodigoProduto = new JTextField();
		txtcodigoProduto.setColumns(10);

		JLabel lblCodigo = new JLabel("Codigo:");
		GroupLayout gl_panelCadastroProduto = new GroupLayout(panelCadastroProduto);
		gl_panelCadastroProduto.setHorizontalGroup(
			gl_panelCadastroProduto.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelCadastroProduto.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPreo, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCadastroProduto.createSequentialGroup()
									.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelCadastroProduto.createSequentialGroup()
											.addComponent(lblCodigo)
											.addPreferredGap(ComponentPlacement.UNRELATED))
										.addGroup(gl_panelCadastroProduto.createSequentialGroup()
											.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(91)))
									.addComponent(txtcodigoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataFabricacao)
								.addComponent(lblDataFabricao, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panelCadastroProduto.setVerticalGroup(
			gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCadastroProduto.createSequentialGroup()
					.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProduto)
								.addComponent(lblDataFabricao)))
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtcodigoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataFabricacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastroProduto.createSequentialGroup()
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPreo)
								.addComponent(lblValidade))
							.addGap(1)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panelCadastroProduto.setLayout(gl_panelCadastroProduto);

		JPanel panelListaProdudos = new JPanel();

		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remover();
			}
		});

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurar();
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panelListaProdudos, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 546,
										Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup()
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 92,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 88,
												GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnProcurar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelCadastroProduto, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup()
												.addComponent(panelCadastroProduto, GroupLayout.PREFERRED_SIZE, 164,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(panelListaProdudos, GroupLayout.PREFERRED_SIZE, 245,
														GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(btnProcurar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 20,
										GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))));
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { btnListar, btnNewButton_1, btnRemover, btnAtualizar, btnProcurar, btnEditar });

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelListaProdudos = new GroupLayout(panelListaProdudos);
		gl_panelListaProdudos.setHorizontalGroup(gl_panelListaProdudos.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE));
		gl_panelListaProdudos.setVerticalGroup(gl_panelListaProdudos.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE));
		// new DefaultTableModel(new Object[][] { { null, null, null, null,
		// null, null }, },
		// )

		tableProduto = new JTable();
		tableProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaselecionada = tableProduto.getSelectedRow();
				codigoselecao = tableProduto.getValueAt(linhaselecionada, 1).toString();
				
				

			}
		});
		String colunasTabelaProduto[] = new String[] { "ID","Codigo Produto", "Produto", "Quantidade", "Preco", "Validade","DataFabricacao" };
		defultTabelaProduto = new DefaultTableModel(new Object[][] {}, colunasTabelaProduto) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableProduto.setModel(defultTabelaProduto);
		scrollPane.setViewportView(tableProduto);
		panelListaProdudos.setLayout(gl_panelListaProdudos);
		contentPane.setLayout(gl_contentPane);
	}

	private void procurar() {

		String codigoProduto = (txtcodigoProduto.getText());

		try {
			Produto produto = Fachada.getInstance().procurarProduto(codigoProduto);
			listar(produto);

			txtcodigoProduto.setText("");

		} catch (ClassNotFoundException | ProdutoNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void remover() {

		try {
			Fachada.getInstance().removerProduto(codigoselecao);
			listar();

		} catch (NumberFormatException | ClassNotFoundException | ProdutoNaoEncontradoException | SQLException
				| IOException e) {

			e.printStackTrace();
		}

	}

	private void listar(Produto produto) throws ClassNotFoundException, SQLException {
		this.limparTabelaProduto();

		Vector vector = new Vector();
		vector.add(produto.getIdProduto());
		vector.add(produto.getCodigoProduto());
		vector.add(produto.getNomeProduto());
		vector.add(produto.getQuantidadeProduto());
		vector.add(produto.getPrecoProduto());
		vector.add(produto.getValidadeProduto());
		vector.add(produto.getDataFabricacaoProduto());

		defultTabelaProduto.addRow(vector);

	}

	private void listar() throws ClassNotFoundException, SQLException, IOException {
		this.limparTabelaProduto();
		ArrayList<Produto> produtos = Fachada.getInstance().listarProduto();
		for (Produto produto : produtos) {
			Vector vector = new Vector();
			vector.add(produto.getIdProduto());
			vector.add(produto.getCodigoProduto());
			vector.add(produto.getNomeProduto());
			vector.add(produto.getQuantidadeProduto());
			vector.add(produto.getPrecoProduto());
			vector.add(produto.getValidadeProduto());
			vector.add(produto.getDataFabricacaoProduto());

			defultTabelaProduto.addRow(vector);
		}
	}

	private void limparTabelaProduto() {
		defultTabelaProduto.setNumRows(0);
	}

	private void cadastrar() {
		// Entrada de dados Pessoais
		String codigo = txtcodigoProduto.getText();
		String produto = txtProduto.getText();
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		Double preco = Double.parseDouble(txtPreco.getText());
		String validade = txtValidade.getText();
		String datafabricacao = txtDataFabricacao.getText();

		Produto produto1 = new Produto(codigo,produto, quantidade, preco, validade, datafabricacao);
		try {
			Fachada.getInstance().cadastraProduto(produto1);
			limpar();
		} catch (ClassNotFoundException | ProdutoJáCadastradoException | NomeVazioException | SQLException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void editar() {

		try {
			Produto produto = Fachada.getInstance().procurarProduto(codigoselecao);

			String codigo = produto.getCodigoProduto();
			String nome = produto.getNomeProduto();
			Integer quantidade = produto.getQuantidadeProduto();
			Double preco = produto.getPrecoProduto();
			String validade = produto.getValidadeProduto();
			String data = produto.getDataFabricacaoProduto();

			txtcodigoProduto.setText(codigo.toString());
			txtProduto.setText(nome);
			txtQuantidade.setText(quantidade.toString());
			txtPreco.setText(preco.toString());
			txtValidade.setText(validade.toString());
			txtDataFabricacao.setText(data.toString());

		} catch (ClassNotFoundException | ProdutoNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void atualizar() {

		
		String codigo = txtcodigoProduto.getText();
		String produto = txtProduto.getText();
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		Double preco = Double.parseDouble(txtPreco.getText());
		String validade = txtValidade.getText();
		String datafabricacao = txtDataFabricacao.getText();

		Produto produto1 = new Produto(codigo, produto, quantidade, preco, validade, datafabricacao);

		try {
			Fachada.getInstance().atualizarProduto(produto1);
			limpar();
			listar();
		} catch (ClassNotFoundException | ProdutoNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void limpar() {
		// campos dados cliente

		txtcodigoProduto.setText("");
		txtProduto.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		txtValidade.setText("");
		txtDataFabricacao.setText("");

	}
}
