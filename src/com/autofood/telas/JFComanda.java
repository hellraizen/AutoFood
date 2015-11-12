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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JFComanda extends JFrame {

	private JPanel contentPane;
	private JTable tableComandaPedidos;
	private JTextField txtPagamento;
	private JTextField txtDesconto;
	private JTextField txtTotal;
	private JTextField textField;

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
		
		JPanel panel_1 = new JPanel();
		
		JButton btnAdcionar = new JButton("+");
		
		JButton btnAlterar = new JButton("Alterar");
		
		JButton btnFinalizar = new JButton("Finalizar");
		
		JLabel lblPagamento = new JLabel("Pagamento");
		
		JLabel lblDesconto = new JLabel("Desconto");
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotal.setForeground(new Color(0, 0, 0));
		
		txtPagamento = new JTextField();
		txtPagamento.setColumns(10);
		
		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(JFComanda.class.getResource("/com/autofood/imagens/image004.gif")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnAdcionar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(btnAlterar, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnFinalizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtPagamento, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))))
									.addGap(94))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(92))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnAdcionar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAlterar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addGap(1)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnFinalizar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(2)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
		);
		
		tableComandaPedidos = new JTable();
		tableComandaPedidos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "Pedido", "Quantidade", "Valor Unitario", "Total"
			}
		));
		scrollPane.setViewportView(tableComandaPedidos);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 386, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 414, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
