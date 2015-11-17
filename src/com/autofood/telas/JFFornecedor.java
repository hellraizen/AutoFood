package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtFornecedor;
	private JTextField txtCodigo;
	private JTextField txtCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFFornecedor frame = new JFFornecedor();
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
	public JFFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setToolTipText("");
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro Produtos",
								TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCadastro.setBackground(SystemColor.menu);
		panelCadastro.setBounds(10, 11, 619, 164);
		contentPane.add(panelCadastro);
		
		txtProduto = new JTextField();
		txtProduto.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto");
		
		JLabel lblTelefone = new JLabel("Telefone");
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		
		JLabel lblCodigo = new JLabel("Codigo");
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		
		txtCnpj = new JTextField();
		txtCnpj.setColumns(10);
		
		JLabel lblCnpj = new JLabel("Cnpj");
		GroupLayout gl_panelCadastro = new GroupLayout(panelCadastro);
		gl_panelCadastro.setHorizontalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGap(0, 607, Short.MAX_VALUE)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProduto, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefone, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(126))
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtFornecedor, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelCadastro.createSequentialGroup()
									.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panelCadastro.createSequentialGroup()
											.addComponent(lblFornecedor, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(91))
										.addGroup(gl_panelCadastro.createSequentialGroup()
											.addComponent(lblCodigo)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCnpj)
								.addComponent(lblCnpj, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelCadastro.setVerticalGroup(
			gl_panelCadastro.createParallelGroup(Alignment.LEADING)
				.addGap(0, 141, Short.MAX_VALUE)
				.addGroup(gl_panelCadastro.createSequentialGroup()
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFornecedor)
								.addComponent(lblCnpj)))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCadastro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addComponent(lblProduto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelCadastro.createSequentialGroup()
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(lblEmail))
							.addGap(1)
							.addGroup(gl_panelCadastro.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(83))
		);
		panelCadastro.setLayout(gl_panelCadastro);
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(null);
		panelBotoes.setBounds(10, 451, 619, 68);
		contentPane.add(panelBotoes);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(10, 22, 89, 23);
		panelBotoes.add(btnCadastrar);
		
		JButton bntAtualizar = new JButton("Atualizar");
		bntAtualizar.setBounds(109, 22, 89, 23);
		panelBotoes.add(bntAtualizar);
		
		JButton bntEditar = new JButton("Editar");
		bntEditar.setBounds(211, 22, 89, 23);
		panelBotoes.add(bntEditar);
		
		JButton bntRemover = new JButton("Remover");
		bntRemover.setBounds(313, 22, 89, 23);
		panelBotoes.add(bntRemover);
		
		JButton bntListar = new JButton("Listar");
		bntListar.setBounds(511, 22, 89, 23);
		panelBotoes.add(bntListar);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.setBounds(412, 22, 89, 23);
		panelBotoes.add(bntProcurar);
	}
}