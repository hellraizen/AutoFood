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

import com.autofood.clientes.Cliente;
import com.autofood.exceçõesCliente.ClienteJaCadastradoException;
import com.autofood.exceçõesProduto.NomeVazioException;
import com.autofood.exceçõesProduto.ProdutoJáCadastradoException;
import com.autofood.exceçõesProduto.ProdutoNaoEncontradoException;
import com.autofood.fachada.Fachada;
import com.autofood.produto.Produto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtQuantidade;
	private JTextField txtDataFabricacao;
	private JTextField txtPreco;
	private JTextField txtValidade;
	private JTable tableProduto;
	private DefaultTableModel defultTabelaProduto;
	private JTextField txtidProduto;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 512);
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
		
		txtidProduto = new JTextField();
		txtidProduto.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		GroupLayout gl_panelCadastroProduto = new GroupLayout(panelCadastroProduto);
		gl_panelCadastroProduto.setHorizontalGroup(
			gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
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
											.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(91))
										.addGroup(gl_panelCadastroProduto.createSequentialGroup()
											.addComponent(lblCodigo)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addComponent(txtidProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastroProduto.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataFabricacao)
								.addComponent(lblDataFabricao, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
								.addComponent(txtidProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
					.addGap(83))
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
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				limpar();
			}
		});

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remover();
			}
		});

		JButton button_1 = new JButton("New button");

		JButton button_2 = new JButton("New button");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(panelCadastroProduto, Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 543,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(Alignment.TRAILING,
																gl_contentPane.createSequentialGroup().addContainerGap()
																		.addComponent(panelListaProdudos,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE))
														.addGroup(gl_contentPane.createSequentialGroup()
																.addContainerGap().addComponent(btnListar).addGap(18)
																.addComponent(btnNewButton_1).addGap(18)
																.addComponent(btnRemover).addGap(18).addComponent(button_1)
																.addGap(18).addComponent(button_2)))
				.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(panelCadastroProduto, GroupLayout.PREFERRED_SIZE, 142,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(panelListaProdudos, GroupLayout.PREFERRED_SIZE, 267,
												GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnListar)
								.addComponent(btnNewButton_1).addComponent(btnRemover).addComponent(button_1)
								.addComponent(button_2))));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelListaProdudos = new GroupLayout(panelListaProdudos);
		gl_panelListaProdudos.setHorizontalGroup(gl_panelListaProdudos.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE));
		gl_panelListaProdudos.setVerticalGroup(gl_panelListaProdudos.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelListaProdudos.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)));
		//new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				//)
				
		tableProduto = new JTable();
		String colunasTabelaProduto[]= new String[] { "IdProduto", "Produto", "Quantidade", "Preco", "Validade", "DataFabricacao" };
		defultTabelaProduto=  new DefaultTableModel(new Object[] []{ }, colunasTabelaProduto){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableProduto.setModel(defultTabelaProduto);
		scrollPane.setViewportView(tableProduto);
		panelListaProdudos.setLayout(gl_panelListaProdudos);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void remover(){
		
		Integer id = Integer.parseInt( txtidProduto.getText());
		
		try {
			Fachada.getInstance().removerProduto(id);
		} catch (NumberFormatException | ClassNotFoundException
				| ProdutoNaoEncontradoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void listar() throws ClassNotFoundException, SQLException {
		 this.limparTabelaProduto();
		ArrayList<Produto> produtos = Fachada.getInstance().listarProduto();
		for (Produto produto : produtos ) {
			Vector vector = new Vector();
			vector.add(produto.getIdProduto());
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
		String produto = txtProduto.getText();
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		Double preco = Double.parseDouble(txtPreco.getText()); 
		String validade = txtValidade.getText();
		String datafabricacao = txtDataFabricacao.getText();
		

		

		Produto produto1 = new Produto(produto,quantidade,preco,validade,datafabricacao);
		try {
			Fachada.getInstance().cadastraProduto(produto1);

		} catch (ClassNotFoundException | ProdutoJáCadastradoException | NomeVazioException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void limpar() {
		// campos dados cliente

		txtProduto.setText("");
		txtQuantidade.setText("");
		txtPreco.setText("");
		txtValidade.setText("");
		txtDataFabricacao.setText("");
		
	}
}
