package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import com.autofood.clientes.Cliente;
import com.autofood.fachada.Fachada;

import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JFCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCpfCliente;
	private JTextField txtDataCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtEmailCliente;
	private JTextField txtRuaCliente;
	private JTextField txtCepCliente;
	private JTextField txtBairroCliente;
	private JTextField txtNumeroCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCliente frame = new JFCliente();
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
	public JFCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Cadastro Cliente");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 22));
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel.setToolTipText("");
		panel.setBackground(new Color(240, 240, 240));
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_1.setBackground(SystemColor.menu);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente(txtNomeCliente.getText(), txtCpfCliente.getText(),txtDataCliente.getText(),"Maculotest", txtEmailCliente.getText(), Integer.parseInt(txtTelefoneCliente.getText()), txtRuaCliente.getText(), txtBairroCliente.getText(), txtNumeroCliente.getText(), txtCepCliente.getText());
				try {
					Fachada.getInstance().cadastrarCliente(cliente);
					Fachada.getInstance().listarCliente();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(187)
					.addComponent(lblNewLabel)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		txtRuaCliente = new JTextField();
		txtRuaCliente.setBounds(10, 31, 465, 20);
		txtRuaCliente.setColumns(10);
		panel_1.add(txtRuaCliente);
		
		JLabel rua = new JLabel("Rua");
		rua.setBounds(17, 18, 27, 14);
		panel_1.add(rua);
		
		txtCepCliente = new JTextField();
		txtCepCliente.setBounds(10, 81, 138, 20);
		txtCepCliente.setColumns(10);
		panel_1.add(txtCepCliente);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 62, 19, 14);
		panel_1.add(lblCep);
		
		txtBairroCliente = new JTextField();
		txtBairroCliente.setBounds(158, 81, 170, 20);
		txtBairroCliente.setColumns(10);
		panel_1.add(txtBairroCliente);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(356, 62, 42, 14);
		panel_1.add(lblN);
		
		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setBounds(352, 81, 123, 20);
		txtNumeroCliente.setColumns(10);
		panel_1.add(txtNumeroCliente);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(163, 62, 81, 14);
		panel_1.add(lblBairro);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 26, 27, 14);
		panel.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(10, 45, 335, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 76, 27, 14);
		panel.add(lblCpf);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(10, 91, 154, 20);
		panel.add(txtCpfCliente);
		
		JLabel labe2 = new JLabel("Data Nascimento");
		labe2.setBounds(355, 26, 118, 14);
		panel.add(labe2);
		
		txtDataCliente = new JTextField();
		txtDataCliente.setColumns(10);
		txtDataCliente.setBounds(355, 45, 118, 20);
		panel.add(txtDataCliente);
		
		JLabel labe1 = new JLabel("Telefone");
		labe1.setBounds(200, 76, 118, 14);
		panel.add(labe1);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(200, 91, 118, 20);
		panel.add(txtTelefoneCliente);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 122, 27, 14);
		panel.add(lblEmail);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(10, 137, 463, 20);
		panel.add(txtEmailCliente);
		
		JRadioButton txtMaculinoCliente = new JRadioButton("Masculino");
		txtMaculinoCliente.setBounds(337, 90, 78, 23);
		panel.add(txtMaculinoCliente);
		
		JRadioButton txtFemininoCliente = new JRadioButton("Feminino");
		txtFemininoCliente.setBounds(417, 90, 78, 23);
		panel.add(txtFemininoCliente);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(392, 76, 46, 14);
		panel.add(lblSexo);
		contentPane.setLayout(gl_contentPane);
	}
}
