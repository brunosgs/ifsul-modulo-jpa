package resources;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Categoria;
import ifsul.modulo.jpa.model.Marca;
import jakarta.persistence.EntityManager;

public class TesteAula10PersistirCategoriaMarca {
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
	    Categoria categoria = new Categoria();
	    Marca marca = new Marca();

	    categoria.setNome("Vestuário");
	    marca.setNome("AlphaCo");

	    em.getTransaction().begin();
	    em.persist(categoria);
	    em.persist(marca);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    exception = true;

	    e.printStackTrace();
	}

	assertEquals(false, exception);
    }

}
