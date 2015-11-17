package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.SystemColor;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

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
import com.autofood.fachada.Fachada;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtValidade;
	private JTextField txtProduto;
	private JTextField txtCodigo;
	private JTextField txtDataEntrada;
	private JTable table;
	private Integer codigoselecao;
	private DefaultTableModel defultTabelaEstoque;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFEstoque frame = new JFEstoque();
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
	public JFEstoque() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setToolTipText("");
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro Produtos",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastro.setBackground(SystemColor.menu);
		
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
		
		JLabel lblDataEntrada = new JLabel("Data Entrada");
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGap(0, 605, Short.MAX_VALUE)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPreco, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelCadastro.createSequentialGroup()
											.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(91))
										.addGroup(gl_panelCadastro.createSequentialGroup()
											.addComponent(lblCodigo)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataEntrada)
								.addComponent(lblDataEntrada, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGap(0, 164, Short.MAX_VALUE)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProduto)
								.addComponent(lblDataEntrada)))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPreco)
								.addComponent(lblValidade))
							.addGap(1)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(83))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel panelLista = new JPanel();
		
		JPanel panelBotoes = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotoes, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
						.addComponent(panelLista, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
						.addComponent(panelCadastro, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelCadastro, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelLista, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBotoes.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				limpar();
			}
		});
		btnCadastrar.setBounds(11, 11, 89, 23);
		panelBotoes.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(111, 11, 89, 23);
		panelBotoes.add(btnAtualizar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		btnEditar.setBounds(211, 11, 89, 23);
		panelBotoes.add(btnEditar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		btnProcurar.setBounds(311, 11, 89, 23);
		panelBotoes.add(btnProcurar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnRemover.setBounds(411, 11, 89, 23);
		panelBotoes.add(btnRemover);
		
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
		btnListar.setBounds(511, 11, 89, 23);
		panelBotoes.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelLista = new GroupLayout(panelLista);
		gl_panelLista.setHorizontalGroup(
			gl_panelLista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLista.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelLista.setVerticalGroup(
			gl_panelLista.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLista.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaselecionada = table.getSelectedRow();

				String ccodigoselecao = table.getValueAt(linhaselecionada, 0).toString();
				codigoselecao = Integer.parseInt(ccodigoselecao);
		}
		});
		String colunasTabelaProduto[] = new String[] { "Codigo", "Produto", "Quantidade", "Preco", "Validade","DataEntrada" };
		defultTabelaEstoque = new DefaultTableModel(new Object[][] {}, colunasTabelaProduto) {
		public boolean isCellEditable(int row, int col) {
		  return false;
	}
};
		table.setModel(defultTabelaEstoque);
		scrollPane.setViewportView(table);
		panelLista.setLayout(gl_panelLista);
		contentPane.setLayout(gl_contentPane);
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