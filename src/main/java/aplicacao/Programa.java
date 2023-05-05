package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-teste");
		EntityManager em = emf.createEntityManager();

		Pessoa p = em.find(Pessoa.class, 6);
		Pessoa p2 = new Pessoa(null, "anarelly gomes", "anarelly@gmail.com");

		em.getTransaction().begin();
		em.remove(p); // Deletar
		em.persist(p2); // criar
		Pessoa p3 = em.find(Pessoa.class, 7); // procurar
		em.getTransaction().commit();
		System.out.println(p3);
		System.out.println("Programa executado!");
		em.close();
		emf.close();
	}
}
