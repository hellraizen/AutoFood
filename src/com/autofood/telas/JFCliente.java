package com.autofood.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.autofood.clientes.Cliente;
import com.autofood.fachada.Fachada;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class JFCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtCpfCliente;
	private JTextField txtDataCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtEmailCliente;
	private JTextField txtRua;
	private JTextField txtCep;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private ButtonGroup bg = new ButtonGroup();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCliente frame = new JFCliente();
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

	public JFCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Cadastro Cliente");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 22));

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel.setToolTipText("");
		panel.setBackground(new Color(240, 240, 240));

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Endere\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_1.setBackground(SystemColor.menu);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				limpar();
			
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(270, Short.MAX_VALUE)
					.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(187)
					.addComponent(lblNewLabel)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(7)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCadastrar, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(null);

		txtRua = new JTextField();
		txtRua.setBounds(10, 31, 234, 20);
		txtRua.setColumns(10);
		panel_1.add(txtRua);

		JLabel rua = new JLabel("Rua");
		rua.setBounds(17, 18, 81, 14);
		panel_1.add(rua);

		txtCep = new JTextField();
		txtCep.setBounds(10, 81, 138, 20);
		txtCep.setColumns(10);
		panel_1.add(txtCep);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(20, 62, 49, 14);
		panel_1.add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setBounds(158, 81, 170, 20);
		txtBairro.setColumns(10);
		panel_1.add(txtBairro);

		JLabel lblN = new JLabel("N\u00BA");
		lblN.setBounds(356, 62, 42, 14);
		panel_1.add(lblN);

		txtNumero = new JTextField();
		txtNumero.setBounds(352, 81, 123, 20);
		txtNumero.setColumns(10);
		panel_1.add(txtNumero);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(163, 62, 81, 14);
		panel_1.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(261, 18, 81, 14);
		panel_1.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(254, 31, 234, 20);
		panel_1.add(txtCidade);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 26, 71, 14);
		panel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(10, 45, 335, 20);
		panel.add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 76, 71, 14);
		panel.add(lblCpf);

		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(10, 91, 154, 20);
		panel.add(txtCpfCliente);

		JLabel labe2 = new JLabel("Data Nascimento");
		labe2.setBounds(355, 26, 136, 14);
		panel.add(labe2);

		txtDataCliente = new JTextField();
		txtDataCliente.setColumns(10);
		txtDataCliente.setBounds(355, 45, 118, 20);
		panel.add(txtDataCliente);

		JLabel labe1 = new JLabel("Telefone");
		labe1.setBounds(200, 76, 118, 14);
		panel.add(labe1);

		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(200, 91, 118, 20);
		panel.add(txtTelefoneCliente);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 122, 71, 14);
		panel.add(lblEmail);

		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(10, 137, 463, 20);
		panel.add(txtEmailCliente);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(392, 76, 46, 14);
		panel.add(lblSexo);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			
			
			}
		});
		bg.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(329, 90, 83, 23);
		panel.add(rdbtnMasculino);

		JRadioButton rdbtFeminino = new JRadioButton("Feminino");
		rdbtFeminino.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		bg.add(rdbtFeminino);
		rdbtFeminino.setBounds(414, 90, 81, 23);
		panel.add(rdbtFeminino);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void cadastrar(){
		// Entrada de dados Pessoais
		String nome = txtNomeCliente.getText();
		String cpf = txtCpfCliente.getText();
		String dataN = txtDataCliente.getText();
		String sexo = "Masculina";
		String email = txtEmailCliente.getText();
		String telefone = txtTelefoneCliente.getText();

		// Entrada de Endereço
		String rua = txtRua.getText();
		String bairro = txtBairro.getText();
		String cep = txtCep.getText();
		String numero = txtNumero.getText();
		String cidade = txtCidade.getText();

		Cliente cliente = new Cliente(nome, cpf, dataN, sexo, email, telefone);
		try {
			Fachada.getInstance().cadastrarCliente(cliente);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void limpar(){
		//campos dados cliente
		
		txtNomeCliente.setText(" ");
		txtCpfCliente.setText(" ");
		txtDataCliente.setText(" ");
		txtEmailCliente.setText(" ");
		txtTelefoneCliente.setText(" ");
		
		//campos endereco
		
		txtRua.setText("");
		txtBairro.setText("");
		txtCep.setText("");
		txtNumero.setText("");
		txtCidade.setText("");
		
	}
}

