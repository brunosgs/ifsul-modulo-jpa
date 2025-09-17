package main.java.ifsul.modulo.jpa.teste;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import main.java.ifsul.modulo.jpa.model.Pais;

public class TesteAula2Persistindo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModuloPU");
		EntityManager em = emf.createEntityManager();
		
		Pais pais = new Pais();
		
		pais.setNome("Canadá");
		pais.setIso("CAN");
		
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
