package org.jsp.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllMerchants {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		  Query query=manager.createQuery("select m from Merchant m");
		  List<Merchant> merchants=query.getResultList();
		  for(Merchant m :merchants) {
			  System.out.println(m);
			  System.out.println("---------------------");
		  }
	}

}
