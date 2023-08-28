package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DAOplanoSaude;
import controle.SessaoDAO;
import modelo.PlanoSaude;
import modelo.Sessao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdSessao;
	private JTextField txtNomeSessao;
	private JTable table;
	
	String [] colunas = {"ID", "Nome Sessão"};
	
	Object [][] dados = {
	        {"1", "Vingadores"},
	        {"2", "Transformers"},
	        {"3", "Piratas do Caribe"}
	    };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		txtIdSessao = new JTextField();
		txtIdSessao.setColumns(10);
		
		txtNomeSessao = new JTextField();
		txtNomeSessao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Sessão:");
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Sessão:");
		
		JButton btnListar = new JButton("Cadastrar");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable(dados, colunas);
		scrollPane.setViewportView(table);
		
		JButton btListar = new JButton("Listar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNomeSessao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
								.addComponent(txtIdSessao, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btListar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(btnListar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
							.addGap(23)))
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtIdSessao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel)))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtNomeSessao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(btnListar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btListar)
					.addContainerGap(102, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sessao s = new Sessao();
				SessaoDAO sDAO = new SessaoDAO();
						
				Integer id = Integer.valueOf(txtIdSessao.getText());
				String nome = txtNomeSessao.getText();

				s.setIdSessao(id);
				s.setNomeSessao(nome);
				
				Boolean inserir = sDAO.inserir(s);
			}
		});
		
		btListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessaoDAO sDAO = new SessaoDAO();
				ArrayList<Sessao> listar = sDAO.listar();
				
			}
		});
	}
}
