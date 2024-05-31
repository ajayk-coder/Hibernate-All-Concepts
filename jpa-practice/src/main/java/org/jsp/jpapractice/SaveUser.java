package org.jsp.jpapractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {

	public static void main(String[] args) {
		 EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			User user=new User();
			user.setName("ABC");
			user.setPassword("abc123");
			
			UserId userId=new UserId();
			userId.setEmail("xyz@gmail.com");
			userId.setPhone(635205532l);
			user.setUserId(userId);
			manager.persist(user);
			transaction.begin();
			transaction.commit();
	}

}
