package ifsul.modulo.jpa.teste;

import ifsul.modulo.jpa.model.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TesteAula3Excluindo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModuloPU");
		EntityManager em = emf.createEntityManager();
		
		Pais p = em.find(Pais.class, 3);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
