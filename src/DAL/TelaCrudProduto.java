package DAL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.SystemColor;

public class TelaCrudProduto {

	private JFrame frame;
	private JTextField txtProduto;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTextField txtValidade;
	private JTextField txtFabricacao;
	private JTextField txtCodigoDoProduto;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrudProduto window = new TelaCrudProduto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCrudProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 654, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Botoes = new JPanel();
		Botoes.setBackground(new Color(192, 192, 192));
		Botoes.setBounds(0, 311, 638, 76);
		frame.getContentPane().add(Botoes);
		Botoes.setLayout(null);
		
		JButton btnCadastra = new JButton("Cadastra");
		btnCadastra.setBounds(13, 11, 91, 43);
		btnCadastra.setBackground(SystemColor.activeCaption);
		Botoes.add(btnCadastra);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(SystemColor.activeCaption);
		btnAtualizar.setBounds(117, 11, 91, 43);
		Botoes.add(btnAtualizar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(SystemColor.activeCaption);
		btnRemover.setBounds(221, 11, 91, 43);
		Botoes.add(btnRemover);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setBackground(SystemColor.activeCaption);
		btnProcurar.setBounds(325, 11, 91, 43);
		Botoes.add(btnProcurar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(SystemColor.activeCaption);
		btnLimpar.setBounds(429, 11, 89, 43);
		Botoes.add(btnLimpar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBackground(SystemColor.activeCaption);
		btnListar.setBounds(531, 11, 89, 43);
		Botoes.add(btnListar);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBackground(new Color(255, 255, 255));
		lblProduto.setBounds(305, 11, 125, 20);
		frame.getContentPane().add(lblProduto);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(367, 11, 125, 20);
		frame.getContentPane().add(txtProduto);
		txtProduto.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBackground(new Color(255, 255, 255));
		lblQuantidade.setBounds(10, 58, 125, 20);
		frame.getContentPane().add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(91, 58, 125, 20);
		frame.getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(305, 58, 125, 20);
		frame.getContentPane().add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(367, 58, 125, 20);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setBackground(new Color(255, 255, 255));
		lblValidade.setBounds(10, 107, 125, 20);
		frame.getContentPane().add(lblValidade);
		
		txtValidade = new JTextField();
		txtValidade.setBounds(66, 107, 125, 20);
		frame.getContentPane().add(txtValidade);
		txtValidade.setColumns(10);
		
		JLabel lblDataFabricao = new JLabel("Data Fabrica\u00E7\u00E3o:");
		lblDataFabricao.setBackground(new Color(245, 255, 250));
		lblDataFabricao.setBounds(306, 107, 125, 20);
		frame.getContentPane().add(lblDataFabricao);
		
		JLabel lblCodigoDoProduto = new JLabel("Codigo do Produto:");
		lblCodigoDoProduto.setBackground(new Color(255, 255, 255));
		lblCodigoDoProduto.setBounds(10, 11, 125, 20);
		frame.getContentPane().add(lblCodigoDoProduto);
		
		JPanel Campos = new JPanel();
		Campos.setBackground(new Color(192, 192, 192));
		Campos.setBounds(0, 0, 638, 145);
		frame.getContentPane().add(Campos);
		Campos.setLayout(null);
		
		txtCodigoDoProduto = new JTextField();
		txtCodigoDoProduto.setBounds(117, 11, 125, 20);
		Campos.add(txtCodigoDoProduto);
		txtCodigoDoProduto.setColumns(10);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setBounds(423, 103, 125, 20);
		Campos.add(txtFabricacao);
		txtFabricacao.setColumns(10);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(621, 145, 17, 164);
		frame.getContentPane().add(scrollBar);
		
		table = new JTable();
		table.setBounds(0, 145, 638, 164);
		frame.getContentPane().add(table);
	}
}
