package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Sessao;

public class SessaoDAO {
	
	public ArrayList<Sessao> listar() {
		
		// Instanciar a Classe
		Conexao c = Conexao.getInstancia();
				
		// Abiir a conexão com o Banco de Dados
		Connection con = c.conectar();
		
		// Criando um Objeto de lista para guardar
		// O que o banco trouxe
		ArrayList<Sessao> sessoes = new ArrayList();
		
		String query = "SELECT * FROM sessao";
		
		try {
			// Prepara nossa Query SQL acima em um Objeto Java
			PreparedStatement ps = con.prepareStatement(query);
			
			// Executa nossa Query de Fato
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				// Pega o que o BD retornou
				int idSessao = rs.getInt("idSessao");
				String nomeSessao = rs.getString("nomeSessao");
				
				// Cria um Objeto organizadinho de Sessao
				Sessao s = new Sessao();
				s.setIdSessao(idSessao);
				s.setNomeSessao(nomeSessao);
				
				// Adiciona Sessao na lista
				sessoes.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		c.fecharConexao();
		
		return sessoes;
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
			e.printStackTrace();
		}
		
		return true;
	}
}
