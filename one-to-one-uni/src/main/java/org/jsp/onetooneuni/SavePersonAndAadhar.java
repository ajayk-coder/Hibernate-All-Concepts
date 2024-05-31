package org.jsp.onetooneuni;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePersonAndAadhar {

	public static void main(String[] args) {
    person p=new person();
    p.setName("maitry");
    p.setPhone(6352022532l);
    
    AadharCard card=new AadharCard();
    card.setDate_of_birth(LocalDate.of(2001, 10, 14));
    card.setNumber(657645342534l);
    card.setPincode(560004);
    
    p.setAadhar(card);   //Assigning Aadhar to person
    
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    EntityManager manager=factory.createEntityManager();
    EntityTransaction transaction=manager.getTransaction();
    manager.persist(p);
    manager.persist(card);
    transaction.begin();
    transaction.commit();
	}

}
