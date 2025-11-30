package resources;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Permissao;
import jakarta.persistence.EntityManager;

public class TesteAula11PersistindoPermissao {
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
	    Permissao permissao = new Permissao();
	    Permissao permissao2 = new Permissao();

	    permissao.setNome("Administrador");
	    permissao.setDescricao("Administrador do sistemas");

	    permissao2.setNome("Usuario");
	    permissao2.setDescricao("Usuario do sistemas");

	    em.getTransaction().begin();
	    em.persist(permissao);
	    em.persist(permissao2);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    exception = true;

	    e.printStackTrace();
	}

	assertEquals(false, exception);
    }

}
