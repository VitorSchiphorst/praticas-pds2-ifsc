package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PessoaDAOTest {
	
	// Annotation
	@Test
	public void testMetodoInserirPessoa() {
		Pessoa p = new Pessoa();
		
		p.setNome("Baunilha");
		p.setIdade(500);
		
		PessoaDAO dao = new PessoaDAO();
		
		// AssertNotNull usando Integer
		Integer idPessoaInserida = dao.inserir(p);
		assertNotNull(idPessoaInserida);
		
		// AssertNotNull usando Boolean(True ou False)
		Boolean inseriuOk = dao.inserirTest(null);
		assertEquals(false, inseriuOk);
	
	}
}	
