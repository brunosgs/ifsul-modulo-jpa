package resources;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Estado;
import ifsul.modulo.jpa.model.Pais;
import jakarta.persistence.EntityManager;
import junit.framework.Assert;

public class TestePersistirEstado {
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
			Estado estado = new Estado();
			
			estado.setNome("Paraná");
			estado.setUf("PR");
			
			estado.setPais(em.find(Pais.class, 1));
			
			em.getTransaction().begin();
			em.persist(estado);
			em.getTransaction().commit();
		} catch (Exception e) {
			exception = true;
			
			e.printStackTrace();
		}
		
		Assert.assertEquals(false, exception);
	}

}
