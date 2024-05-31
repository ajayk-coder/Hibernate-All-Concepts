package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findbyName {

	public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the name to display details");
    String name=sc.next();
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	  EntityManager manager=factory.createEntityManager();
	  Query q= manager.createNamedQuery("findbyName");
	  q.setParameter(1, name);
	  List<Merchant>merchants=q.getResultList();
	  if(merchants.isEmpty())
		  System.err.println("No merchant found with the entered name");
	  else
		  for(Merchant merchant:merchants)
			  System.out.println(merchant);
	}

}
