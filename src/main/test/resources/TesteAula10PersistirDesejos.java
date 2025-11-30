package resources;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Categoria;
import ifsul.modulo.jpa.model.Marca;
import ifsul.modulo.jpa.model.PessoaFisica;
import ifsul.modulo.jpa.model.Produto;
import jakarta.persistence.EntityManager;

public class TesteAula10PersistirDesejos {
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
	    PessoaFisica pf = em.find(PessoaFisica.class, 5);
	    Produto produto = new Produto();

	    produto.setNome("Jeans");
	    produto.setDecricao("Calça masculina");
	    produto.setMarca(em.find(Marca.class, 2));
	    produto.setCategoria(em.find(Categoria.class, 2));
	    produto.setPreco(new BigDecimal("109.90"));
	    produto.setQuantidadeEstoque(new BigDecimal("20"));

	    pf.getDesejos().add(produto);

	    em.getTransaction().begin();
	    em.persist(produto);
	    em.persist(pf);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    exception = true;

	    e.printStackTrace();
	}

	assertEquals(false, exception);
    }

}
