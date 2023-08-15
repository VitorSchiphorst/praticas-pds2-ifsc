package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Sessao;

public class SessaoDAO {
	
	public ArrayList<Sessao> listar() {
		
		// Instanciar a Classe
		Conexao c = Conexao.getInstancia();
				
		// Abiir a conexão com o Banco de Dados
		Connection con = c.conectar();
		
		ArrayList<Sessao> sessoes = new ArrayList();
		
		String query = "";
		
		return null;
	}
	
	public boolean inserir (Sessao s) {
		
		// Instanciar a Classe
		Conexao c = Conexao.getInstancia();
		
		// Abiir a conexão com o Banco de Dados
		Connection con = c.conectar();
		
		String query = "INSERT INTO sessao(id_sessao, nome_sessao) VALUES (?, ?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, s.getIdSessao());
			ps.setString(2, s.getNomeSessao());
			
			// Consilidar a Excução do comando no Banco
			ps.executeUpdate();
			
			// Fecha a Conexão com o Banco
			c.fecharConexao();
			
			return true;
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return true;
	}
}
