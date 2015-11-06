package com.autofood.telas;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.autofood.clientes.Cliente;
import com.autofood.fachada.Fachada;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFClienteListar extends JFrame {

	private JPanel contentPane;
	private JTable tableCliente;
	private DefaultTableModel defaultTableModelCliente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFClienteListar frame = new JFClienteListar();
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
	public JFClienteListar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane PanelClienteLista = new JScrollPane();
		
		JButton button = new JButton("Atualizar");
		
		JButton button_1 = new JButton("Remover");
		
		JLabel lblListaDeCliente = new JLabel("Lista de Clientes");
		lblListaDeCliente.setFont(new Font("Impact", Font.PLAIN, 22));
		
		JButton Listar = new JButton("Listar");
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(PanelClienteLista, GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(267)
							.addComponent(Listar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(246)
							.addComponent(lblListaDeCliente, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListaDeCliente, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addComponent(Listar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(PanelClienteLista, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
		);
		
		table = new JTable();
		String colunaTabelaCliente[] = new String[] {"Codigo", "Nome", "CPF", "Data Nascimento", "Telefone", "Sexo", "Email"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		PanelClienteLista.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	
	
	
 }
	private void listar() throws ClassNotFoundException, SQLException {
		
		ArrayList<Cliente> clientes = Fachada.getInstance().listarCliente();
		for(Cliente cliente: clientes) {
			Vector vector = new Vector();
			vector.add(cliente.getCodigo());
			vector.add(cliente.getNome());
			vector.add(cliente.getCpf());
			vector.add(cliente.getDataNascimento());
			vector.add(cliente.getTelefone());
			vector.add(cliente.getSexo());
			vector.add(cliente.getEmail());
			
			defaultTableModelCliente.addRow(vector);
		}
	}
}
