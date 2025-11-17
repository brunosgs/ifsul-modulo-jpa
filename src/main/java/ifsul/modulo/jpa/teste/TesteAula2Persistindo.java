package ifsul.modulo.jpa.teste;

import ifsul.modulo.jpa.model.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteAula2Persistindo {

    public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModuloPU");
	EntityManager em = emf.createEntityManager();

	Pais pais = new Pais();

	pais.setNome("Brasil");
	pais.setIso("BRA");

	em.getTransaction().begin();
	em.persist(pais);
	em.getTransaction().commit();
	em.close();
	emf.close();
    }

}
