package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findbyid {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	    System.out.println("Enter the id to display details");
	    Integer id=sc.nextInt();
	    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		  Query q= manager.createNamedQuery("findbyid");
		  q.setParameter(1, id);
		  List<Merchant>merchants=q.getResultList();
		  if(merchants.isEmpty())
			  System.err.println("No merchant found with the entered id");
		  else
			  for(Merchant merchant:merchants)
				  System.out.println(merchant);
	}

}
