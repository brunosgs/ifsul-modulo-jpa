package main.java.ifsul.modulo.jpa.teste;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.java.ifsul.modulo.jpa.model.Pais;

public class Teste {

	public static void main(String[] args) {
		System.out.println("TESTE");
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
