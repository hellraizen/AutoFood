package com.autofood.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.autofood.comanda.Comanda;
import com.autofood.fachada.Fachada;
import com.autofood.produto.Produto;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class JFPedidoComanda extends JFrame {

	private JPanel contentPane;
	private JTable tablePedidos;
	private JTable tableProdutos;
	private JTextField txtTotal;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultTableModel defultTabelaProduto;
	private DefaultTableModel defultTabelaComanda;
	private JTextField txtQuantidade;
	private JTextField textField_3;
	private Integer selecaoProdutoId;
	private String selecaoProdutoNome;
	private Double selecaoProdutoPreco;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFPedidoComanda frame = new JFPedidoComanda();
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
	public JFPedidoComanda() {
		setTitle("Comanda\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		txtTotal = new JTextField();
		txtTotal.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		
		JLabel lblDesconto = new JLabel("Desconto");
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarPedido();
				listarComanda();
				
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(JFPedidoComanda.class.getResource("/com/autofood/imagens/image004.gif")));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setForeground(Color.BLUE);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textField_2)
									.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
								.addComponent(txtTotal, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(button_1))
								.addComponent(btnAtualizar, 0, 0, Short.MAX_VALUE))
							.addGap(127)
							.addComponent(btnFinalizar, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPagamento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesconto))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFinalizar, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnListarProdutos = new JButton("Listar ");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
					
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		btnListarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		txtQuantidade = new JTextField();
		txtQuantidade.setText("1");
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblProcurar = new JLabel("Procurar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnListarProdutos)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(29)
									.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblProcurar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
							.addGap(15))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantidade)
								.addComponent(lblProcurar))
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnListarProdutos, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		tableProdutos = new JTable();
		tableProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaselecionada = tableProdutos.getSelectedRow();
				String codigoselecao = tableProdutos.getValueAt(linhaselecionada, 0).toString();
				String codigoselecaopreco = tableProdutos.getValueAt(linhaselecionada, 2).toString();
				
				selecaoProdutoId = Integer.parseInt(codigoselecao);
				selecaoProdutoNome = tableProdutos.getValueAt(linhaselecionada, 1).toString();
				selecaoProdutoPreco= Double.parseDouble(codigoselecaopreco);
	
			}
		});
		String colunasTabelaProduto[]= new String[] {"Codigo", "Descricao", "Valor"};
		defultTabelaProduto =new DefaultTableModel(new Object[][] {}, colunasTabelaProduto) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableProdutos.setModel(defultTabelaProduto);
		scrollPane_1.setViewportView(tableProdutos);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tablePedidos = new JTable();
		tablePedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tablePedidos.setToolTipText("");
		String colunaTabelaPedido[] =new String[] {"Codigo", "Descricao", "Quantidade", "Valor", "Total"};
		defultTabelaComanda = new DefaultTableModel(new Object[][] {},colunaTabelaPedido){
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		
		tablePedidos.setModel(defultTabelaComanda);
		scrollPane.setViewportView(tablePedidos);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}
	private void listar() throws ClassNotFoundException, SQLException, IOException {
		this.limparTabelaProduto();
		ArrayList<Produto> produtos = Fachada.getInstance().listarProduto();
		for (Produto produto : produtos) {
			Vector vector = new Vector();
			vector.add(produto.getIdProduto());
			vector.add(produto.getNomeProduto());
			vector.add(produto.getPrecoProduto());
			

			defultTabelaProduto.addRow(vector);
		}
	}

	private void limparTabelaProduto() {
		defultTabelaProduto.setNumRows(0);
	}
	private void limparTabelaComanda() {
		defultTabelaComanda.setNumRows(0);
	}
	private void adicionarPedido(){
		int quantidade = Integer.parseInt(txtQuantidade.getText());
		
		double total= selecaoProdutoPreco * quantidade;
		
		double totalConta = 0;
		
		totalConta = totalConta + total;
		
		txtTotal.setText( String.valueOf(totalConta));
	
		
		Comanda comanda = new Comanda(selecaoProdutoId, selecaoProdutoNome, selecaoProdutoPreco, quantidade, total);
		
		try {
			Fachada.getInstance().adicionarComanda(comanda);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void listarComanda(){
		this.limparTabelaComanda();
		ArrayList<Comanda> Comandas;
		try {
			Comandas = Fachada.getInstance().listarComanda();
			for (Comanda Comanda : Comandas) {
				Vector vector = new Vector();
				vector.add(Comanda.getIdProduto());
				vector.add(Comanda.getProduto());
				vector.add(Comanda.getQuantidade());
				vector.add(Comanda.getValor());
				vector.add(Comanda.getTotal());
				

				defultTabelaComanda.addRow(vector);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
