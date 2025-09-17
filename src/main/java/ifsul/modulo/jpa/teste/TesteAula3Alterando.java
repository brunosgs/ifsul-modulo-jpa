package main.java.ifsul.modulo.jpa.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.java.ifsul.modulo.jpa.model.Pais;

public class TesteAula3Alterando {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModuloPU");
		EntityManager em = emf.createEntityManager();
		
		Pais p = em.find(Pais.class, 2);
		
		p.setNome("Argentina");
		p.setIso("ARG");
		
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
