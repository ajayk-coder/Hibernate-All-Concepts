package org.jsp.jpapractice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FilterFoodOrderByRangeOfCost {

	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Query query=manager.createQuery("select f from FoodOrder f where f.cost between 100 and 250");
		List<FoodOrder>f=query.getResultList();
		if(!f.isEmpty()) {
			for(FoodOrder o:f) {
				System.out.println(o);
			}
		}
	    else
	    	System.err.println("No details");
	}

}
