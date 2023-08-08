package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textIdSessao;
	private JTextField textNomeSessao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIdSessao = new JTextField();
		textIdSessao.setBounds(101, 23, 86, 20);
		contentPane.add(textIdSessao);
		textIdSessao.setColumns(10);
		
		textNomeSessao = new JTextField();
		textNomeSessao.setBounds(101, 66, 86, 20);
		contentPane.add(textNomeSessao);
		textNomeSessao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID Sessão:");
		lblNewLabel.setBounds(28, 26, 63, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome da Sessão:");
		lblNewLabel_1.setBounds(10, 69, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(39, 133, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer idSessão = Integer.valueOf(textIdSessao.getText());
				String nomeSessao = textNomeSessao.getText();
			}
		});
		
		
	}
}
