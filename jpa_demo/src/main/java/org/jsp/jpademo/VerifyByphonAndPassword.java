package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyByphonAndPassword {

	public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    System.out.println("enter the pho number and password");
    long phon=sc.nextLong();
    String password=sc.next();
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	  EntityManager manager=factory.createEntityManager();
	  Query q=manager.createNamedQuery("VerifyByphonAndPassword");
	  q.setParameter(1, phon);
	  q.setParameter(2, password);
	  try {
		  Merchant merchant=(Merchant)q.getSingleResult();
		  System.out.println(merchant);
	  }catch(NoResultException e) {
		  System.err.println("Invalid phon and password");
	  }
	}

}
