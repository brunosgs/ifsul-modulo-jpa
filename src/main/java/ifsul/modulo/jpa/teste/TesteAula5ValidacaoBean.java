package main.java.ifsul.modulo.jpa.teste;

import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import main.java.ifsul.modulo.jpa.model.Pais;

public class TesteAula5ValidacaoBean {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFSULModuloPU");
		EntityManager em = emf.createEntityManager();
		
		Pais pais = new Pais();
		
		pais.setNome("Uruguai");
		pais.setIso("URUG");
		
		em.getTransaction().begin();
		
		Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Pais>> errors = validador.validate(pais);
		
		if (errors.size() > 0) {
			for (ConstraintViolation<Pais> constraintViolationError : errors) {
				System.out.println("Erro: " + constraintViolationError.getMessage());
			}
		} else {
			em.persist(pais);			
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
