package org.jsp.jpapractice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ListAllFoodOrders {

	public static void main(String[] args) {
		 EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query=manager.createQuery("select f from FoodOrder f");
			List<FoodOrder>f=query.getResultList();
			 if(f.isEmpty())
			    	System.err.println("no fooditems");
			    else
			    	for(FoodOrder foodorder:f)
			    		System.out.println(foodorder);
	}

}
