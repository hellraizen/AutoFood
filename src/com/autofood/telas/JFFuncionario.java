package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.autofood.clientes.Cliente;
import com.autofood.endereco.Endereco;
import com.autofood.fachada.Fachada;
import com.autofood.funcionario.Funcionario;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class JFFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JTextField txtData;
	private JTextField txtCargo;
	private JTable tableFuncionario;
	private ButtonGroup groupSexo = new ButtonGroup();
	private JRadioButton rBMasc;
	private JRadioButton rBFemi;
	private DefaultTableModel defaultFuncionario;
	private String cpfControle;
	private JTextField txtId;
	

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 769, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 397, 677, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				limparTabela();
			}

			public void limparTabela() 
			{
				txtId.setText(" ");
				txtNome.setText(" ");
				txtCpf.setText(" ");
				txtData.setText(" ");
				txtTelefone.setText(" ");
				txtEmail.setText(" ");
				txtLogin.setText(" ");
				txtSenha.setText(" ");
				txtCargo.setText(" ");
				
			}
		});
		btnCadastrar.setBounds(10, 23, 105, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("ATUALIZAR");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		btnAtualizar.setBounds(125, 23, 105, 23);
		panel.add(btnAtualizar);
		
		JButton btnProcurar = new JButton("PROCURAR");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Fachada.getInstance().procurarFuncionario(cpfControle);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnProcurar.setBounds(249, 23, 105, 23);
		panel.add(btnProcurar);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.getInstance().removerFuncionario(cpfControle);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(364, 23, 105, 23);
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				editar();
			}
		});
		btnEditar.setBounds(479, 23, 89, 23);
		panel.add(btnEditar);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listar();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setBounds(578, 23, 89, 23);
		panel.add(btnListar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 11, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 28, 228, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(248, 11, 46, 14);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(248, 28, 220, 20);
		contentPane.add(txtCpf);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 59, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 76, 228, 20);
		contentPane.add(txtEmail);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(505, 11, 46, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(505, 28, 228, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(248, 59, 46, 14);
		contentPane.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(248, 76, 220, 20);
		contentPane.add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(505, 59, 228, 14);
		contentPane.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(505, 76, 228, 20);
		contentPane.add(txtSenha);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(10, 104, 117, 14);
		contentPane.add(lblDataNascimento);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(10, 121, 228, 20);
		contentPane.add(txtData);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(248, 104, 46, 14);
		contentPane.add(lblCargo);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(248, 121, 220, 20);
		contentPane.add(txtCargo);
		
		JLabel label = new JLabel("Sexo");
		label.setBounds(596, 104, 46, 14);
		contentPane.add(label);
		
		 rBMasc = new JRadioButton("Masculino");
		 groupSexo.add(rBMasc);
		 
		rBMasc.setBounds(533, 118, 83, 23);

		contentPane.add(rBMasc);
		
		
		 rBFemi = new JRadioButton("Feminino");
		 groupSexo.add(rBFemi);
		 
		rBFemi.setBounds(618, 118, 81, 23);
		contentPane.add(rBFemi);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 155, 697, 219);
		contentPane.add(panel_1);
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
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
		tableFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linhaSelecao = tableFuncionario.getSelectedRow();
				cpfControle= tableFuncionario.getValueAt(linhaSelecao, 2).toString();
			}
		});
		String[] colunas = new String[] { "id","nome", "cpf","data Nascimanto", "telefone", "sexo", "email", "cargo",  "login", "senha",   };
		defaultFuncionario = new DefaultTableModel(new Object[][] {},colunas){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tableFuncionario.setModel(defaultFuncionario);
		scrollPane.setViewportView(tableFuncionario);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(701, 124, 16, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(715, 121, 18, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
	}
	
	private void cadastrar() {
		
		String nome = txtNome.getText();
		String cpf = txtCpf.getText();
		String dataN = txtData.getText();
		String sexo = selecaoSexo();
		String email = txtEmail.getText();
		String telefone = txtTelefone.getText();
		String login = txtLogin.getText();
		String senha = txtSenha.getText();
		String cargo = txtCargo.getText();
		
		Funcionario funcionario = new Funcionario( nome, cpf, dataN, sexo, telefone, email, cargo, login, senha);
		
		try {
			Fachada.getInstance().cadastrarFuncionario(funcionario);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String selecaoSexo() {
		String sexo = "";
		if (rBFemi.isSelected())
			sexo = "Feminino";
		if (rBMasc.isSelected())
			sexo = "Masculino";

		return sexo;
	}
	
	
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		 this.limparTabelaFuncionario();
		ArrayList<Funcionario> funcionarios = Fachada.getInstance().listarFuncionario();
		for (Funcionario funcionario : funcionarios) {
			Vector vector = new Vector();
			vector.add(funcionario.getIdFuncionario());
			vector.add(funcionario.getNomeFuncionario());
			vector.add(funcionario.getCpfFuncionario());
			vector.add(funcionario.getDataNascimentoFuncionario());
			vector.add(funcionario.getTelefoneFuncionario());
			vector.add(funcionario.getSexoFuncionario());
			vector.add(funcionario.getEmailFuncionario());
			vector.add(funcionario.getTipoFuncionario());
			vector.add(funcionario.getLogin());
			vector.add(funcionario.getSenha());
		

			defaultFuncionario.addRow(vector);
		}
	}
	
	
	private void limparTabelaFuncionario() {
		defaultFuncionario.setNumRows(0);;
	}
	
	
	public void editar()
	{
		try {
			Funcionario funcionario = Fachada.getInstance().procurarFuncionario(cpfControle);
		
			Integer idFuncionario = funcionario.getIdFuncionario();
			String nomeFuncionario = funcionario.getNomeFuncionario();
			String cpfFuncionario = funcionario.getCpfFuncionario();
			String dataNascimentoFuncionario = funcionario.getDataNascimentoFuncionario();
			String telefoneFuncionario = funcionario.getTelefoneFuncionario();
			String emailFuncionario = funcionario.getEmailFuncionario();
			String login = funcionario.getLogin();
			String senha = funcionario.getSenha();
			
			
			txtId.setText(idFuncionario.toString());
			txtNome.setText(nomeFuncionario);
			txtCpf.setText(cpfFuncionario);
			txtData.setText(dataNascimentoFuncionario);
			txtTelefone.setText(telefoneFuncionario);
			txtEmail.setText(emailFuncionario);
			txtLogin.setText(login);
			txtSenha.setText(senha);
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	}
	
	
	public void atualizar()
	{
		 
		Integer idFuncionario = Integer.parseInt(txtId.getText());
		String nomeFuncionario = txtNome.getText();
		String cpfFuncionario = txtCpf.getText();
		String dataNascimentoFuncionario = txtData.getText();
		String telefoneFuncionario = txtTelefone.getText();
		String emailFuncionario = txtEmail.getText();
		String login = txtLogin.getText();
		String senha = txtSenha.getText();
		
		Funcionario funcionario = new Funcionario(idFuncionario, nomeFuncionario, cpfFuncionario, dataNascimentoFuncionario, telefoneFuncionario, emailFuncionario, login, senha);
		
		try {
			Fachada.getInstance().atualizarFuncionario(funcionario);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
