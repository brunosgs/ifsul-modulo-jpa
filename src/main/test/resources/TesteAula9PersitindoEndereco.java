package resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Endereco;
import ifsul.modulo.jpa.model.PessoaFisica;
import ifsul.modulo.jpa.model.TipoEndereco;
import jakarta.persistence.EntityManager;
import junit.framework.Assert;

public class TesteAula9PersitindoEndereco {
	EntityManager em;

	@Before
	public void setUp() throws Exception {
		em = EntityManagerUtil.getEntityManager();
	}

	@After
	public void tearDown() throws Exception {
		em.close();
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		boolean exception = false;

		try {
			PessoaFisica pf = em.find(PessoaFisica.class, 5);
			Endereco endereco = new Endereco();

			endereco.setBairro("Centro");
			endereco.setCep("888999-99");
			endereco.setEndereco("Rua xxx");
			endereco.setNumero("2163");
			endereco.setComplemento("AP 1804");
			endereco.setNickName("APTO");
			endereco.setReferencia("Prox. ao mercado");
			
			endereco.setTipoEnderco(em.find(TipoEndereco.class, 1));
			
			pf.adicionarEndereco(endereco);

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
