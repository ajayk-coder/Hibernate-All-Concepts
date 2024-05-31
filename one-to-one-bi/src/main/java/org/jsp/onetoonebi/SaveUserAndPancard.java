package org.jsp.onetoonebi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndPancard {

	public static void main(String[] args) {
   User u=new User();
   u.setName("heer");
   u.setPhone(835208725);
   
   PanCard card=new PanCard();
  card.setDate_of_birth(LocalDate.of(2011, 11, 12));
   card.setNumber("GFWE763");
   card.setPincode(770005);
   
   u.setCard(card);
   card.setUser(u);
   
   EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
   EntityManager manager=factory.createEntityManager();
   EntityTransaction transaction=manager.getTransaction();
   manager.persist(u);
   transaction.begin();
   transaction.commit();
   
	}

}
