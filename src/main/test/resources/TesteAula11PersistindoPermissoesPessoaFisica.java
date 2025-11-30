package resources;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Permissao;
import ifsul.modulo.jpa.model.PessoaFisica;
import jakarta.persistence.EntityManager;

public class TesteAula11PersistindoPermissoesPessoaFisica {
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
	    PessoaFisica pf = em.find(PessoaFisica.class, 1);
	    Permissao permissaoAdministrador = em.find(Permissao.class, "Administrador");
	    Permissao permissaoUsuario =  em.find(Permissao.class, "Usuario");
	    
	    pf.getPermissoes().add(permissaoAdministrador);
	    pf.getPermissoes().add(permissaoUsuario);

	    em.getTransaction().begin();
	    em.persist(pf);
	    em.getTransaction().commit();
	} catch (Exception e) {
	    exception = true;

	    e.printStackTrace();
	}

	assertEquals(false, exception);
    }

}
