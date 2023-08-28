package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.SessaoDAO;
import modelo.Sessao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtId;
    private DefaultTableModel modelo;

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

    public TelaCadastro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 50, 46, 14);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(66, 47, 86, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(10, 19, 46, 14);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(66, 16, 86, 20);
        contentPane.add(txtId);
        txtId.setColumns(10);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String id = txtId.getText();

                Sessao s = new Sessao();
                s.setNomeSessao(nome);
                s.setIdSessao(Integer.valueOf(id));

                SessaoDAO dao = new SessaoDAO();
                dao.inserir(s);

                txtNome.setText(null);
                txtId.setText(null);

                refreshTable();
            }
        });
        btnCadastrar.setBounds(10, 122, 97, 23);
        contentPane.add(btnCadastrar);

        modelo = new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome Sessao"});
        JTable tabela = new JTable(modelo);

        JScrollPane barraRolagem = new JScrollPane(tabela);
        barraRolagem.setBounds(10, 160, 414, 190);
        contentPane.add(barraRolagem);
        
        JButton btnUpdate = new JButton("Update nome");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Integer id = Integer.valueOf(txtId.getText());
                String nome =txtNome.getText();

                SessaoDAO dao = new SessaoDAO();
                dao.atualizar(id, nome);

                txtNome.setText(null);
                txtId.setText(null);

                refreshTable();
        	}
        });
        btnUpdate.setBounds(145, 122, 116, 23);
        contentPane.add(btnUpdate);
        
        JButton btnNewButton = new JButton("Deletar por id");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Integer id = Integer.valueOf(txtId.getText());

                SessaoDAO dao = new SessaoDAO();
                dao.excluir(id);

                txtNome.setText(null);
                txtId.setText(null);

                refreshTable();
        	}
        });
        btnNewButton.setBounds(301, 122, 123, 23);
        contentPane.add(btnNewButton);

        setSize(450, 400);
        setVisible(true);
        refreshTable();
    }

    private void refreshTable() {
    	SessaoDAO dao = new SessaoDAO();
        ArrayList<Sessao> sessoes = dao.listar();

        modelo.setRowCount(0);

        for (Sessao sessao : sessoes) {
            modelo.addRow(new Object[] { sessao.getIdSessao(), sessao.getNomeSessao() });
        }
    }
}