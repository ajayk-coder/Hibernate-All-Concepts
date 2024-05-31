package org.jsp.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FinfallUsingCreateNativeQuery {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		  Query q =manager.createNativeQuery("select * from  Merchant",Merchant.class);
		  List<Merchant>merchants=q.getResultList();
		  for(Merchant m:merchants) {
			  System.out.println(m);
			  System.out.println("---------------------");
		  }
	}

}
