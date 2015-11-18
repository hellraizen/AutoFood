package com.autofood.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.autofood.caixa.Caixa;
import com.autofood.fachada.Fachada;

public class JFCaixa extends JFrame {

	private JPanel contentPane;
	private JTable tableCaixa;
	private DefaultTableModel defautTableModelCaixa;
	private JTextField txtFuncionario;
	private JTextField txtTotalCaixa;
	private DecimalFormat decimalFormat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCaixa frame = new JFCaixa();
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
	public JFCaixa() {
		setTitle("Caixa\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1139, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Op\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblFuncionario = new JLabel("Funcionario :");
		
		txtFuncionario = new JTextField();
		txtFuncionario.setBackground(new Color(0, 0, 102));
		txtFuncionario.setEnabled(false);
		txtFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuncionario.setText("02");
		txtFuncionario.setColumns(10);
		
		JLabel lblTotalEmCaixa = new JLabel("Total Caixa");
		lblTotalEmCaixa.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		txtTotalCaixa = new JTextField();
		txtTotalCaixa.setBackground(new Color(0, 0, 102));
		txtTotalCaixa.setEnabled(false);
		txtTotalCaixa.setForeground(Color.WHITE);
		txtTotalCaixa.setFont(new Font("Tahoma", Font.PLAIN, 39));
		txtTotalCaixa.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(232)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtTotalCaixa, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(lblTotalEmCaixa)
							.addPreferredGap(ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
							.addComponent(lblFuncionario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(43))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuncionario)
						.addComponent(txtFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalEmCaixa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTotalCaixa, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(13)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableCaixa = new JTable();
		String coluna[] =new String[] {"Entrada", "Saida", "Comanda", "Funcionario", "Data"};
		defautTableModelCaixa = new DefaultTableModel(new Object[][] {},coluna) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCaixa.setModel(defautTableModelCaixa);
		scrollPane.setViewportView(tableCaixa);
		
		panel_1.setLayout(gl_panel_1);
		
		JButton btnAbrir = new JButton("Abrir Caixa");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCaixa();
			}
		});
		
		JButton btnFecharCaixa = new JButton("Fechar Caixa");
		btnFecharCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().fecharCaixa();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnMovimentoCaixa = new JButton("Movimento Caixa");
		btnMovimentoCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarCaixa();
					somaCaixa();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnRetirada = new JButton("Retirada");
		btnRetirada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retirada();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnFecharCaixa, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(btnAbrir, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(17)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRetirada, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
								.addComponent(btnMovimentoCaixa, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(35)
					.addComponent(btnAbrir, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFecharCaixa, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMovimentoCaixa, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(btnRetirada, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	private void abrirCaixa(){
		try {
			Fachada.getInstance().abrirCaixa();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void listarCaixa() throws ClassNotFoundException, SQLException, IOException {
		 this.limparTabelaCaixa();
		 ArrayList<Caixa> caixas = Fachada.getInstance().movimentoDiarioCaixa();
			for (Caixa caixa : caixas) {
		
			Vector vector = new Vector();
			vector.add(caixa.getEntrada());
			vector.add(caixa.getSaida());
			vector.add(caixa.getIdComanda());
			vector.add(caixa.getIdFuncionario());
			vector.add(caixa.getData());
			

			defautTableModelCaixa.addRow(vector);
			}
		
	}
	private void limparTabelaCaixa() {
		defautTableModelCaixa.setNumRows(0);;
	}
	
	private void retirada(){
		
		double valorRetirada = Double.parseDouble(JOptionPane.showInputDialog("Digite o Valor da Retirada"));
		
		Date minhaDate = new Date();   
		
		Caixa caixa = new Caixa(valorRetirada,Integer.parseInt(txtFuncionario.getText()),minhaDate);
		
		try {
			Fachada.getInstance().saidaCaixa(caixa);
			
			
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void somaCaixa() {
		decimalFormat = new DecimalFormat("0.00");
		double totalConta = 0;
		for (int i = 0; i < tableCaixa.getRowCount(); i++) {

			totalConta += Double.parseDouble(defautTableModelCaixa.getValueAt(i, 0).toString());

		}

		txtTotalCaixa.setText(decimalFormat.format(totalConta).replace(',', '.'));

		
	}
}
