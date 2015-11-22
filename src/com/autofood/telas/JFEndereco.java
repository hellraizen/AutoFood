package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.autofood.clientes.Cliente;
import com.autofood.endereco.Endereco;
import com.autofood.fachada.Fachada;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class JFEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField textRua;
	private JTextField textBairro;
	private JTextField textNumero;
	private JTextField textCep;
	private JTextField textComplemento;
	private JTable table;
	private DefaultTableModel defaultEndereco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFEndereco frame = new JFEndereco();
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
	public JFEndereco() {
		setTitle("ENDERE\u00C7O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 711, 0);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 343, 711, 70);
		contentPane.add(panel_1);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCadastrar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0)
			{
				cadastrar();
			}
		});
		panel_1.add(btnCadastrar);
		
		JButton btnNewButton = new JButton("ATUALIZAR");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) 
			{
				atualizar();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e)
			{
				remover();
			}
		});
		btnRemover.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnRemover);
		
		JButton btnProcurar = new JButton("PROCURAR");
		btnProcurar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnProcurar.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnProcurar);
		
		JButton btnExiste = new JButton("EXISTE");
		btnExiste.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnExiste);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnListar.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_1.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 87, 706, 248);
		contentPane.add(scrollPane);
		
		table = new JTable();
		String[] coluna = new String[] {"RUA", "BAIRRO","NUMERO","CEP","COMPLEMENTO",};
		defaultEndereco =new DefaultTableModel(new Object[][] {},coluna){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		table.setModel(defaultEndereco);
		table.getColumnModel().getColumn(0).setPreferredWidth(95);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(table);
		
		textRua = new JTextField();
		textRua.setBounds(50, 11, 227, 20);
		contentPane.add(textRua);
		textRua.setColumns(10);
		
		JLabel lblRua = new JLabel("RUA");
		lblRua.setBounds(15, 16, 46, 14);
		contentPane.add(lblRua);
		
		textBairro = new JTextField();
		textBairro.setBounds(362, 11, 227, 20);
		contentPane.add(textBairro);
		textBairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("BAIRRO");
		lblBairro.setBounds(306, 14, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lbNumero = new JLabel("N\u00B0");
		lbNumero.setBounds(615, 14, 28, 14);
		contentPane.add(lbNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(653, 11, 44, 20);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(78, 49, 46, 14);
		contentPane.add(lblCep);
		
		textCep = new JTextField();
		textCep.setBounds(110, 46, 167, 20);
		contentPane.add(textCep);
		textCep.setColumns(10);
		
		JLabel lblComplemento = new JLabel("COMPLEMENTO");
		lblComplemento.setBounds(316, 49, 101, 14);
		contentPane.add(lblComplemento);
		
		textComplemento = new JTextField();
		textComplemento.setBounds(445, 46, 249, 20);
		contentPane.add(textComplemento);
		textComplemento.setColumns(10);
	}
	
	public void cadastrar()
	{
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String numero = textNumero.getText();
		String cep = textCep.getText();
		String complemento = textComplemento.getText();
		
		Endereco endereco = new Endereco( rua, bairro, numero, cep, complemento);
		
		try {
			Fachada.getInstance().cadastrarEndereco(endereco);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void atualizar()
	{
		String rua = textRua.getText();
		String bairro = textBairro.getText();
		String numero = textNumero.getText();
		String cep = textCep.getText();
		String complemento = textComplemento.getText();
		
		Endereco endereco = new Endereco(rua, bairro, numero, cep, complemento);
		
		try {
			Fachada.getInstance().cadastrarEndereco(endereco);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void remover()
	{
		textRua.setText(" ");
		textBairro.setText(" ");
		textNumero.setText(" ");
		textCep.setText(" ");
		textComplemento.setText(" ");
		
	}
	
	
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		 this.limparTabelaEndereco();
		ArrayList<Endereco> arrayEndereco = Fachada.getInstance().listarEndereco();
		for (Endereco endereco : arrayEndereco) {
			Vector vector = new Vector();
			vector.add(endereco.getIdEndereco());
			vector.add(endereco.getRua());
			vector.add(endereco.getBairro());
			vector.add(endereco.getCep());
			vector.add(endereco.getComplemento());
			
			
			defaultEndereco.addRow(vector);
		}
	}
		
		private void limparTabelaEndereco() {
			defaultEndereco.setNumRows(0);;
		}
	
	
	
}
