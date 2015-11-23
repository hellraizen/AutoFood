package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable tableFuncionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFFuncionario frame = new JFFuncionario();
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
	public JFFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 397, 648, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBounds(14, 25, 105, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.setBounds(133, 25, 89, 23);
		panel.add(btnAtualizar);
		
		JButton btnProcurar = new JButton("PROCURAR");
		btnProcurar.setBounds(236, 25, 89, 23);
		panel.add(btnProcurar);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.setBounds(339, 25, 89, 23);
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(442, 25, 89, 23);
		panel.add(btnEditar);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.setBounds(545, 25, 89, 23);
		panel.add(btnListar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(10, 28, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(248, 11, 46, 14);
		contentPane.add(lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 28, 220, 20);
		contentPane.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 59, 46, 14);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 76, 228, 20);
		contentPane.add(textField_2);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(505, 11, 46, 14);
		contentPane.add(lblTelefone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(505, 28, 228, 20);
		contentPane.add(textField_3);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(248, 59, 46, 14);
		contentPane.add(lblLogin);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(248, 76, 220, 20);
		contentPane.add(textField_4);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(505, 59, 228, 14);
		contentPane.add(lblSenha);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(505, 76, 228, 20);
		contentPane.add(textField_5);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(10, 104, 117, 14);
		contentPane.add(lblDataNascimento);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(10, 121, 228, 20);
		contentPane.add(textField_6);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(248, 104, 46, 14);
		contentPane.add(lblCargo);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(248, 121, 220, 20);
		contentPane.add(textField_7);
		
		JLabel label = new JLabel("Sexo");
		label.setBounds(596, 104, 46, 14);
		contentPane.add(label);
		
		JRadioButton radioButton = new JRadioButton("Masculino");
		radioButton.setBounds(533, 118, 83, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Feminino");
		radioButton_1.setBounds(618, 118, 81, 23);
		contentPane.add(radioButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 155, 697, 219);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 683, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		tableFuncionario = new JTable();
		scrollPane.setViewportView(tableFuncionario);
		panel_1.setLayout(gl_panel_1);
	}
}
