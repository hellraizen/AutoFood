package com.autofood.telas;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.autofood.imagens.FundoDaTela;

public class JFMenuInicial extends JFrame {

	private JPanel contentPane;
	private FundoDaTela desktop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMenuInicial frame = new JFMenuInicial();

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
	public JFMenuInicial() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(JFMenuInicial.class.getResource("/com/autofood/imagens/logoFundo.jpg")));
		getContentPane().setLayout(new GridLayout());
		desktop = new FundoDaTela("/com/autofood/imagens/logoFundo.jpg");
		getContentPane().add(desktop);
		desktop.setVisible(true);

		setTitle("Autofood");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);

		setBounds(100, 100, 621, 359);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArquivo = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnArquivo);

		JMenuItem mntmLogoff = new JMenuItem("Cliente\r\n");
		mntmLogoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFClienteListar clienteLista = new JFClienteListar();
				clienteLista.setVisible(true);
			}
		});
		mnArquivo.add(mntmLogoff);

		JMenuItem mntmFuncionrio = new JMenuItem("Funcion\u00E1rio");
		mnArquivo.add(mntmFuncionrio);

		JMenuItem mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFProduto telaProduto = new JFProduto();
				telaProduto.setVisible(true);
			}
		});
		mnArquivo.add(mntmProduto);

		JMenuItem mntmLogoff_1 = new JMenuItem("Logoff");
		mnArquivo.add(mntmLogoff_1);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		mnArquivo.add(mntmSair);

		JMenu mnHelp = new JMenu("Atendimento");
		menuBar.add(mnHelp);

		JMenuItem mntmVerso = new JMenuItem("Cardapio");
		mnHelp.add(mntmVerso);

		JMenuItem mntmCaixa = new JMenuItem("Caixa");
		mnHelp.add(mntmCaixa);

		JMenuItem menuItem_2 = new JMenuItem("Vers\u00E3o");
		mnHelp.add(menuItem_2);

		JMenuItem menuItem_1 = new JMenuItem("Vers\u00E3o");
		mnHelp.add(menuItem_1);

		JMenu menu = new JMenu("Help");
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("Vers\u00E3o");
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(287, 0, 1238, 698);
		lblNewLabel.setIcon(new ImageIcon(JFMenuInicial.class.getResource("/com/autofood/imagens/logoFundo.jpg")));
		contentPane.add(lblNewLabel);
	}
}
