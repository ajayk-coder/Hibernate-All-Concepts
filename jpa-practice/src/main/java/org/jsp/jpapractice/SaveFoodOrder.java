package org.jsp.jpapractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveFoodOrder {

	public static void main(String[] args) {
    FoodOrder order=new FoodOrder();
    order.setFood_item("coffee");
    order.setCost(400);
    EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	transaction.begin();
	manager.persist(order);
	transaction.commit();
	}

}
