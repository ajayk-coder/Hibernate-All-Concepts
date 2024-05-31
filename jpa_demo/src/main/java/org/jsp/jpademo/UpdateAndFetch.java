package org.jsp.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateAndFetch {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
	    Merchant m=manager.find(Merchant.class, 1);
	    m.setEmail("abc@gmail.com");
	    m.setName("ABC");
	    m.setGst_number("ABCD1234");
	    m.setPhon(657456354l);
	    m.setPassword("abc@123");
	    transaction.begin();
	    transaction.commit();
	}

	
}
