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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.autofood.estoque.Estoque;
import com.autofood.exceçoesFornecedor.FornecedorJaCadastradoException;
import com.autofood.exceçoesFornecedor.FornecedorNaoEncontradoException;
import com.autofood.exceçoesFornecedor.FornecedorNuloException;
import com.autofood.fachada.Fachada;
import com.autofood.fornecedor.Fornecedor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class JFFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtFornecedor;
	private JTextField txtCodigo;
	private JTextField txtCnpj;
	private JTable table;
	private String cnpjselecao;
	private DefaultTableModel defaultTableModel;

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
		panelCadastro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cadastro Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
				cadastra();
			}
		});
		btnCadastrar.setBounds(10, 22, 95, 23);
		panelBotoes.add(btnCadastrar);
		
		JButton bntAtualizar = new JButton("Atualizar");
		bntAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		bntAtualizar.setBounds(109, 22, 89, 23);
		panelBotoes.add(bntAtualizar);
		
		JButton bntEditar = new JButton("Editar");
		bntEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		bntEditar.setBounds(211, 22, 89, 23);
		panelBotoes.add(bntEditar);
		
		JButton bntRemover = new JButton("Remover");
		bntRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		bntRemover.setBounds(313, 22, 89, 23);
		panelBotoes.add(bntRemover);
		
		JButton bntListar = new JButton("Listar");
		bntListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bntListar.setBounds(511, 22, 89, 23);
		panelBotoes.add(bntListar);
		
		JButton bntProcurar = new JButton("Procurar");
		bntProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurar();
			}
		});
		bntProcurar.setBounds(412, 22, 89, 23);
		panelBotoes.add(bntProcurar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 619, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaselecionada = table.getSelectedRow();

				cnpjselecao = table.getValueAt(linhaselecionada, 2).toString();
				
		}
		});
		String colunasTabelaEstoque[] = new String[] {"Codigo", "Fornecedor", "CNPJ", "Produto", "Telefone", "Email"};
		defaultTableModel = new DefaultTableModel(new Object[][]{},colunasTabelaEstoque){
		public boolean isCellEditable(int row, int col) {
			  return false;
		}
	};
		table.setModel(defaultTableModel);
		scrollPane.setViewportView(table);
	}
	
	private void cadastra(){
		
		String fornecedor = txtFornecedor.getText();
		String cnpj = txtCnpj.getText();
		String produto = txtProduto.getText();
		String telefone = txtTelefone.getText();
		String email = txtEmail.getText();
		
		Fornecedor fornecedor1 = new Fornecedor(fornecedor,cnpj,produto,telefone,email);
		
		
		try {
			Fachada.getInstance().cadastraFornecedor(fornecedor1);
			limpar();
		} catch (ClassNotFoundException | FornecedorJaCadastradoException | FornecedorNuloException | SQLException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void atualizar(){
		
		Integer codigo = Integer.parseInt(txtCodigo.getText());
		String fornecedor = txtFornecedor.getText();
		String cnpj = txtCnpj.getText();
		String produto = txtProduto.getText();
		String telefone = txtTelefone.getText();
		String email = txtEmail.getText();
		
		Fornecedor fornecedor1 = new Fornecedor(codigo,fornecedor,cnpj,produto,telefone,email);
		
		try {
			Fachada.getInstance().atualizarFornecedor(fornecedor1);
			listar();
			limpar();
		} catch (ClassNotFoundException | FornecedorNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void remover(){
		
		try {
			Fachada.getInstance().removerFornecedor(cnpjselecao);
			listar();
		} catch (ClassNotFoundException | FornecedorNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void limparTabelaEstoque() {
		defaultTableModel.setNumRows(0);
	}
	
	private void procurar(){
		
		String cnpj = txtCnpj.getText();
		
		try {
			Fornecedor fornecedor = Fachada.getInstance().procurarFornecedor(cnpj);
			listar(fornecedor);
			
			txtCnpj.setText("");
		} catch (ClassNotFoundException | FornecedorNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private void listar(Fornecedor fornecedor) throws ClassNotFoundException,SQLException {
		
		this.limparTabelaEstoque();

			Vector vector = new Vector();
			vector.add(fornecedor.getIdFornecedor());
			vector.add(fornecedor.getNomeFornecedor());
			vector.add(fornecedor.getCnpjFornecedor());
			vector.add(fornecedor.getProdutoFornecido());
			vector.add(fornecedor.getTelefoneFornecedor());
			vector.add(fornecedor.getEmailFornecedor());


	defaultTableModel.addRow(vector);

}

	private void listar() throws ClassNotFoundException, SQLException,IOException {
		
		this.limparTabelaEstoque();
		
		ArrayList<Fornecedor> fornecedores = Fachada.getInstance().listarFornecedor();
		
	for (Fornecedor fornecedor : fornecedores) {
			
			Vector vector = new Vector();
			vector.add(fornecedor.getIdFornecedor());
			vector.add(fornecedor.getNomeFornecedor());
			vector.add(fornecedor.getCnpjFornecedor());
			vector.add(fornecedor.getProdutoFornecido());
			vector.add(fornecedor.getTelefoneFornecedor());
			vector.add(fornecedor.getEmailFornecedor());
	

			defaultTableModel.addRow(vector);
  }
 }
	private void editar(){
		
		try {
			Fornecedor fornecedor1 = Fachada.getInstance().procurarFornecedor(cnpjselecao);
			
			Integer codigo = fornecedor1.getIdFornecedor();
			String fornecedor = fornecedor1.getNomeFornecedor();
			String cnpj = fornecedor1.getCnpjFornecedor();
			String produto = fornecedor1.getProdutoFornecido();
			String telefone = fornecedor1.getTelefoneFornecedor();
			String email = fornecedor1.getEmailFornecedor();
			
			txtCodigo.setText(codigo.toString());
			txtFornecedor.setText(fornecedor);
			txtCnpj.setText(cnpj);
			txtProduto.setText(produto);
			txtTelefone.setText(telefone);
			txtEmail.setText(email);
			
		} catch (ClassNotFoundException | FornecedorNaoEncontradoException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void limpar() {
		// campos dados cliente

			txtCodigo.setText("");
			txtFornecedor.setText("");
			txtCnpj.setText("");
			txtProduto.setText("");
			txtTelefone.setText("");
			txtEmail.setText("");
	}
}