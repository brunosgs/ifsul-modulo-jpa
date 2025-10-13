package ifsul.modulo.jpa.teste;

import ifsul.modulo.jpa.infra.jpa.EntityManagerUtil;
import ifsul.modulo.jpa.model.Pais;
import jakarta.persistence.EntityManager;

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
