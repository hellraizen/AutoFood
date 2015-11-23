package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JFFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 684, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 356, 648, 72);
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
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(66, 8, 228, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
