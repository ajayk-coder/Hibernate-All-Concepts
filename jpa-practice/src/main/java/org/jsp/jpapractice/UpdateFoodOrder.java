package org.jsp.jpapractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateFoodOrder {

	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		FoodOrder order=manager.find(FoodOrder.class,1);
		order.setCost(150);
		transaction.commit();
	}

}
