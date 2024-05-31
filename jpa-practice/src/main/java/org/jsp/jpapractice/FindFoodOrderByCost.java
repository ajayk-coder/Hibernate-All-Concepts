package org.jsp.jpapractice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindFoodOrderByCost {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the cost to find foodorder");
		double cost=sc.nextDouble();
		String jpql="select f from FoodOrder f where f.cost=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, cost);
		try
		{
			FoodOrder f=(FoodOrder)query.getSingleResult();
			System.out.println(f);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid cost");
		}
	}

}
