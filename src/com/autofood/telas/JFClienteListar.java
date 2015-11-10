package com.autofood.telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.autofood.clientes.Cliente;
import com.autofood.exceçõesCliente.ClienteNaoEncontradoException;
import com.autofood.fachada.Fachada;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFClienteListar extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel defaultTableModelCliente;
	private JTable tableListaCliente;
	private JTextField txtProcurar;
	private String cpfControle;
	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
				
				
			}
		});

		JButton btnRemover = new JButton("-");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().removerCliente(cpfControle);
				} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

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

		JPanel panel = new JPanel();
		
		txtProcurar = new JTextField();
		txtProcurar.setColumns(10);
		
		JLabel lblPesquisar = new JLabel("Pesquisar");
		
		JButton btnCadastrar = new JButton("+");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFCliente telaCliente = new JFCliente();
				telaCliente.setVisible(true);
			}
		});
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String procura =txtProcurar.getText();
				
				try {
					Cliente cliente = Fachada.getInstance().procurarCliente(procura);
					listar(cliente);
					
					txtProcurar.setText("");
					
					
				} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 627, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(275, Short.MAX_VALUE)
					.addComponent(lblListaDeCliente)
					.addGap(265))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPesquisar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnCadastrar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnRemover))
								.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnProcurar)
							.addGap(128)
							.addComponent(Listar)
							.addGap(5)
							.addComponent(btnEditar)))
					.addGap(74))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblListaDeCliente)
					.addGap(11)
					.addComponent(lblPesquisar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(Listar)
								.addComponent(btnEditar))
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnProcurar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCadastrar)
								.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addContainerGap())
		);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE));

		tableListaCliente = new JTable();
		tableListaCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaSelecao = tableListaCliente.getSelectedRow();
			cpfControle= tableListaCliente.getValueAt(linhaSelecao, 2).toString();
			
			}
		});
		String colunaTabelaCliente[] = new String[] {"Codigo", "Nome", "CPF", "Data de Nascimanto", "Telefone", "Sexo", "Email"};
		defaultTableModelCliente = new DefaultTableModel(new Object[] []{ }, colunaTabelaCliente){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
	
		tableListaCliente.setModel(defaultTableModelCliente);
		scrollPane.setViewportView(tableListaCliente);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}

	private void listar() throws ClassNotFoundException, SQLException {
		 this.limparTabelaCliente();
		ArrayList<Cliente> clientes = Fachada.getInstance().listarCliente();
		for (Cliente cliente : clientes) {
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
	private void listar(Cliente cliente) throws ClassNotFoundException, SQLException {
		 this.limparTabelaCliente();
		
		
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
	private void limparTabelaCliente() {
		defaultTableModelCliente.setNumRows(0);;
	}
	private void editar() {
		try {
			Cliente cliente = Fachada.getInstance().procurarCliente(cpfControle);
			
			JFCliente telaC = new JFCliente();
			telaC.setVisible(true);
			
			telaC.txtNomeCliente.setText(cliente.getNome());
			telaC.txtCpfCliente.setText(cliente.getCpf());
			telaC.txtDataCliente.setText(cliente.getDataNascimento());
			telaC.txtEmailCliente.setText(cliente.getEmail());
			telaC.txtTelefoneCliente.setText(cliente.getTelefone());
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException | ClienteNaoEncontradoException e) {
			JOptionPane.showMessageDialog( null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
