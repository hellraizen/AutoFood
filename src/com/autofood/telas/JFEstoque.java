package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class JFEstoque extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantidade;
	private JTextField txtPrecoCusto;
	private JTextField txtValidade;
	private JTextField txtProduto;
	private JTextField txtCodigo;
	private JTextField txtDataEntrada;
	private JPanel panelBotoes;

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
		setBounds(100, 100, 680, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panelDados = new JPanel();
		panelDados.setToolTipText("");
		panelDados.setBorder(new TitledBorder(UIManager
						.getBorder("TitledBorder.border"), "Cadastro Produtos",
						TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		panelDados.setBackground(SystemColor.menu);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade\r\n");
		
		JLabel lblPrecoCusto = new JLabel("Pre\u00E7o Custo");
		
		txtPrecoCusto = new JTextField();
		txtPrecoCusto.setColumns(10);
		
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
		GroupLayout gl_panelDados = new GroupLayout(panelDados);
		gl_panelDados.setHorizontalGroup(
			gl_panelDados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDados.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelDados.createSequentialGroup()
							.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING)
								.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPrecoCusto, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPrecoCusto, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING)
								.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelDados.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING)
								.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDados.createSequentialGroup()
									.addGroup(gl_panelDados.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelDados.createSequentialGroup()
											.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(91))
										.addGroup(gl_panelDados.createSequentialGroup()
											.addComponent(lblCodigo)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDataEntrada)
								.addComponent(lblDataEntrada, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_panelDados.setVerticalGroup(
			gl_panelDados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDados.createSequentialGroup()
					.addGroup(gl_panelDados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDados.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblProduto)
								.addComponent(lblDataEntrada)))
						.addGroup(gl_panelDados.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelDados.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDados.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelDados.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelDados.createSequentialGroup()
							.addComponent(lblQuantidade)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDados.createSequentialGroup()
							.addGroup(gl_panelDados.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPrecoCusto)
								.addComponent(lblValidade))
							.addGap(1)
							.addGroup(gl_panelDados.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPrecoCusto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(83))
		);
		panelDados.setLayout(gl_panelDados);
		
		panelBotoes = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelDados, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panelDados, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addGap(237)
					.addComponent(panelBotoes, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		JButton btnEditar = new JButton("Editar");
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnProcurar = new JButton("Procurar");
		
		JButton btnListar = new JButton("Listar");
		GroupLayout gl_panelBotoes = new GroupLayout(panelBotoes);
		gl_panelBotoes.setHorizontalGroup(
			gl_panelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotoes.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAtualizar, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnProcurar, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelBotoes.setVerticalGroup(
			gl_panelBotoes.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelBotoes.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(gl_panelBotoes.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnListar)
						.addComponent(btnProcurar)
						.addComponent(btnRemover)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar))
					.addGap(23))
		);
		panelBotoes.setLayout(gl_panelBotoes);
		contentPane.setLayout(gl_contentPane);
	}
}
