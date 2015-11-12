package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class JFComanda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFComanda frame = new JFComanda();
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
	public JFComanda() {
		setTitle("Comanda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 805, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
		);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton btnNewButton = new JButton("Adicionar");
		
		JButton btnRemover = new JButton("Remover");
		
		JButton btnFinalizar = new JButton("Finalizar");
		
		JButton btnAlterar = new JButton("Alterar");
		
		JLabel lblNewLabel = new JLabel("Total ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("Total ");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("Total ");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnAlterar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnFinalizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton, Alignment.LEADING))
									.addGap(2147483173))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnRemover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(28)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel))
								.addComponent(btnRemover))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnFinalizar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar))
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		
		table = new JTable();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_3, null);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
