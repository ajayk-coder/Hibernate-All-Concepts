package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findbygstnumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	    System.out.println("Enter the gstnumber to display details");
	    String gst_number=sc.next();
	    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		  Query q= manager.createNamedQuery("findbygstnumber");
		  q.setParameter(1, gst_number);
		  List<Merchant>merchants=q.getResultList();
		  if(merchants.isEmpty())
			  System.err.println("No merchant found with the entered gst_number");
		  else
			  for(Merchant merchant:merchants)
				  System.out.println(merchant);
	}

}
