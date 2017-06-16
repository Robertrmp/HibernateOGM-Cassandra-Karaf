package com.db;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class UserImpl implements IUser {

	@PersistenceContext(unitName = "userUnit")
	private EntityManager em;

	public User addUser(User user) {
		System.out.println("Entity Manager via annotation::" + em);
		
		
		try {
			if (em == null) {
				Map<String, String> props = new HashMap<String, String>();
				Thread.currentThread().setContextClassLoader(
						this.getClass().getClassLoader());
				EntityManagerFactory emf = Persistence
						.createEntityManagerFactory("userUnit", props);
				em = emf.createEntityManager();

				System.out.println("Entity Manager via creation::" + em);
			}

			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(user);
			em.flush();
			tx.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
