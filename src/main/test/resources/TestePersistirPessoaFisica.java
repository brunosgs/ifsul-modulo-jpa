package resources;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Estado;
import ifsul.modulo.jpa.model.Pais;
import ifsul.modulo.jpa.model.PessoaFisica;
import jakarta.persistence.EntityManager;
import junit.framework.Assert;

public class TestePersistirPessoaFisica {
	EntityManager em;

	@Before
	public void setUp() throws Exception {
		em = EntityManagerUtil.getEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@Test
	public void test() {
		boolean exception = false;
		
		try {
			PessoaFisica pf = new PessoaFisica();
			
			pf.setCpf("91526460092");
			pf.setEmail("email@teste.com.br");
			pf.setNascimento(LocalDate.now());
			pf.setNome("Teste de pessoa fisica");
			pf.setNomeUsuario("testePF");
			pf.setRg("1851484");
			pf.setSenha("testesenha");
			pf.setTelefone("(66)3526-5498");
			
			em.getTransaction().begin();
			em.persist(pf);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			
			e.printStackTrace();
		}
		
		Assert.assertEquals(false, exception);
	}

}
