package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUser {

	public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("enter the name,phon,password,email and gst_number");
    Merchant merchant=new Merchant();
    merchant.setName(s.next());
    merchant.setEmail(s.next());
    merchant.setPhon(s.nextLong());
    merchant.setGst_number(s.next());
    merchant.setPassword(s.next());
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    EntityManager manager=factory.createEntityManager();
    EntityTransaction transaction=manager.getTransaction();
    manager.persist(merchant);
    transaction.begin();
    transaction.commit();
    System.out.println("Merchant saved with ID:"+merchant.getId());
	}

}
