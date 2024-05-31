package org.jsp.jpapractice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindFoodOrdersByFood_Item {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the fooditems to find foodorder");
		String food_item =sc.next();
 		String jpql="select f from FoodOrder f where f.food_item=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, food_item);
		try
		{
			FoodOrder f=(FoodOrder)query.getSingleResult();
			System.out.println(f);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid fooditems");
		}
	}

}
