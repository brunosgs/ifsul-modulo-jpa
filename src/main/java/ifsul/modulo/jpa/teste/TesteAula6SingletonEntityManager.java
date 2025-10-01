package main.java.ifsul.modulo.jpa.teste;

import jakarta.persistence.EntityManager;
import main.java.ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import main.java.ifsul.modulo.jpa.model.Pais;

public class TesteAula6SingletonEntityManager {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();

		Pais pais = new Pais();

		pais.setNome("Chile");
		pais.setIso("CHI");

		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
		em.close();
	}

}
