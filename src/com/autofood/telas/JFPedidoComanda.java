package com.autofood.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.autofood.caixa.Caixa;
import com.autofood.clientes.Cliente;
import com.autofood.comanda.Comanda;
import com.autofood.fachada.Fachada;
import com.autofood.produto.Produto;

public class JFPedidoComanda extends JFrame {

	private JPanel contentPane;
	private JTable tablePedidos;
	private JTable tableProdutos;
	private JTextField txtTotal;
	private JTextField txtDesconto;
	private JTextField txtPagamento;
	private DefaultTableModel defultTabelaProduto;
	private DefaultTableModel defultTabelaComanda;
	private JTextField txtQuantidade;
	private JTextField textField_3;
	private Integer selecaoProdutoId;
	private String selecaoProdutoNome;
	private Double selecaoProdutoPreco;
	private int numeroPedido;
	private DecimalFormat decimalFormat;
	private JComboBox<String> cBClienteList;
	private JTextField txtFuncionarioId;
	private JTextField txtNumeroComanda;

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
		setBounds(100, 100, 816, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cardapio", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pedidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotal.setBackground(new Color(0, 0, 51));
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTotal.setForeground(Color.BLACK);
		txtTotal.setEnabled(false);
		txtTotal.setColumns(10);

		txtDesconto = new JTextField();
		txtDesconto.setText("0");
		txtDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesconto.setColumns(10);

		txtPagamento = new JTextField();
		txtPagamento.setText("0");
		txtPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagamento.setColumns(10);

		JLabel lblPagamento = new JLabel("Pagamento");

		JLabel lblDesconto = new JLabel("Desconto");

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 21));

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarPedido();
				listarComanda();
				somaPedido();

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnRemover = new JButton("");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerPedido();
				listarComanda();
				somaPedido();

			}
		});
		btnRemover.setIcon(new ImageIcon(JFPedidoComanda.class.getResource("/com/autofood/imagens/image004.gif")));
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pagamentoFinalizar();
				envioCaixa();
				dispose();
			}
		});
		btnFinalizar.setForeground(Color.BLUE);
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblFuncionario = new JLabel("Funcionario ");
		
		txtFuncionarioId = new JTextField();
		txtFuncionarioId.setBackground(new Color(0, 0, 102));
		txtFuncionarioId.setEnabled(false);
		txtFuncionarioId.setText("02");
		txtFuncionarioId.setHorizontalAlignment(SwingConstants.CENTER);
		txtFuncionarioId.setColumns(10);
		
		JLabel lblComandaN = new JLabel("Comanda N\u00BA");
		
		txtNumeroComanda = new JTextField();
		txtNumeroComanda.setBackground(new Color(0, 0, 102));
		txtNumeroComanda.setEnabled(false);
		txtNumeroComanda.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumeroComanda.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDesconto, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPagamento, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtPagamento)
											.addComponent(txtDesconto, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
										.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(31)
												.addComponent(lblComandaN, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(2)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(txtFuncionarioId, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(17)
														.addComponent(button)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnRemover))))
											.addComponent(txtNumeroComanda, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(30)
											.addComponent(lblFuncionario, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnFinalizar, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
							.addContainerGap())
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 439, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(207)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPagamento))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDesconto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesconto))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTotal))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnFinalizar, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblFuncionario)
									.addGap(4)
									.addComponent(txtFuncionarioId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(lblComandaN)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumeroComanda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);

		JScrollPane scrollPane_1 = new JScrollPane();

		JButton btnListarProdutos = new JButton("Listar ");
		btnListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listar();
					listarCbCliente();

				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		btnListarProdutos.setFont(new Font("Tahoma", Font.PLAIN, 17));

		txtQuantidade = new JTextField();
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setText("1");
		txtQuantidade.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade");

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		JLabel lblProcurar = new JLabel("Procurar");

		cBClienteList = new JComboBox();

		JLabel lblCliente = new JLabel("Cliente");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addComponent(btnListarProdutos).addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(29)
										.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(lblProcurar, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(cBClienteList, GroupLayout.PREFERRED_SIZE, 204,
														GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE, 80,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_3,
														GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE))))))
				.addGap(115)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel.createSequentialGroup().addGap(5)
										.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 279,
												GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblQuantidade).addComponent(lblProcurar))
										.addGap(5)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(txtQuantidade, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnListarProdutos, GroupLayout.PREFERRED_SIZE, 29,
										GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(lblCliente).addPreferredGap(ComponentPlacement.RELATED).addComponent(cBClienteList,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(21, Short.MAX_VALUE)));

		tableProdutos = new JTable();
		tableProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linhaselecionada = tableProdutos.getSelectedRow();
				String codigoselecao = tableProdutos.getValueAt(linhaselecionada, 0).toString();
				String codigoselecaopreco = tableProdutos.getValueAt(linhaselecionada, 2).toString();

				selecaoProdutoId = Integer.parseInt(codigoselecao);
				selecaoProdutoNome = tableProdutos.getValueAt(linhaselecionada, 1).toString();
				selecaoProdutoPreco = Double.parseDouble(codigoselecaopreco);

			}
		});
		String colunasTabelaProduto[] = new String[] { "Codigo", "Descricao", "Valor" };
		defultTabelaProduto = new DefaultTableModel(new Object[][] {}, colunasTabelaProduto) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableProdutos.setModel(defultTabelaProduto);
		scrollPane_1.setViewportView(tableProdutos);
		panel.setLayout(gl_panel);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panel_1
				.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
								.addContainerGap()));

		tablePedidos = new JTable();
		tablePedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int linhaPedido = tablePedidos.getSelectedRow();

				String codSelecao = tablePedidos.getValueAt(linhaPedido, 0).toString();

				numeroPedido = Integer.parseInt(codSelecao);

			}
		});
		tablePedidos.setToolTipText("");
		String colunaTabelaPedido[] = new String[] { "Nº", "Codigo", "Descricao", "Quantidade", "Valor Unit", "Total" };
		defultTabelaComanda = new DefaultTableModel(new Object[][] {}, colunaTabelaPedido) {
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

	private void adicionarPedido() {
		int quantidade = Integer.parseInt(txtQuantidade.getText());

		double total = selecaoProdutoPreco * quantidade;
		String cliente = cBClienteList.getSelectedItem().toString();
		
		Comanda comanda = new Comanda(cliente,selecaoProdutoId, selecaoProdutoNome, selecaoProdutoPreco, quantidade, total);

		try {
			Fachada.getInstance().adicionarComanda(comanda);
			txtNumeroComanda.setText(comanda.getIdComanda().toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void listarComanda() {
		this.limparTabelaComanda();
		ArrayList<Comanda> Comandas;
		try {
			Comandas = Fachada.getInstance().listarComanda();
			for (Comanda comanda : Comandas) {
				Vector vector = new Vector();
				vector.add(comanda.getNumeroVenda());
				vector.add(comanda.getIdProduto());
				vector.add(comanda.getProduto());
				vector.add(comanda.getQuantidade());
				vector.add(comanda.getValor());
				vector.add(comanda.getTotal());

				defultTabelaComanda.addRow(vector);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public double somaPedido() {
		decimalFormat = new DecimalFormat("0.00");
		double totalConta = 0;
		for (int i = 0; i < tablePedidos.getRowCount(); i++) {

			totalConta += Double.parseDouble(defultTabelaComanda.getValueAt(i, 5).toString());

		}

		txtTotal.setText(decimalFormat.format(totalConta).replace(',', '.'));

		return totalConta;
	}

	private void removerPedido() {
		try {
		
			Fachada.getInstance().cancelarPedidoComanda(numeroPedido);
			

			listarComanda();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean pagamentoFinalizar() {
		boolean validado = false;
		double pagamento = Double.parseDouble(txtPagamento.getText());
		double desconto = Double.parseDouble(txtDesconto.getText());
		double totalPagamento = somaPedido();
		double troco=0;
		
		if (desconto == 0 ) {
			 troco = pagamento - totalPagamento;
			JOptionPane.showMessageDialog(null, "Troco = R$ " + troco);
			 validado = true;
		}
		if (desconto > 0) {
			 troco= pagamento - totalPagamento - desconto;
			JOptionPane.showMessageDialog(null, "Troco = R$ " + troco);
			validado = true;
		}
		//fazer excption
		if(troco < 0 ){
			
			JOptionPane.showMessageDialog(null, "Falta = R$ " + troco);
			validado = false;
			
		}
		
		if(validado){
			try {
				Fachada.getInstance().finalizarPedidoComanda();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else return false;
		
		

	}
	
	private void listarCbCliente(){
		cBClienteList.removeAllItems();
		cBClienteList.addItem("");
		
		try {
			ArrayList<Cliente> listaCliente = Fachada.getInstance().listarCliente();
			
			Iterator<Cliente> it = listaCliente.iterator();  
		    while(it.hasNext()){  
		  
		        Cliente e = it.next();  
		        String cliente = e.getNome();  
		  
		        cBClienteList.addItem(cliente); 
			
		    }
			
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	private void envioCaixa(){
		
		double entrada = Double.parseDouble(txtTotal.getText());
		int idComanda = Integer.parseInt(txtNumeroComanda.getText());
		int idFuncionario = Integer.parseInt(txtFuncionarioId.getText());
		Date data = new Date();

		Caixa caixa = new Caixa(entrada, idComanda, idFuncionario,data);
		
		try {
			Fachada.getInstance().entradaCaixa(caixa);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
