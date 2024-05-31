package org.jsp.jpapractice;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindFoodOrdersById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id to find foodorder");
		int id=sc.nextInt();
		String jpql="select f from FoodOrder f where f.=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		try
		{
			FoodOrder f=(FoodOrder)query.getSingleResult();
			System.out.println(f);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid ID");
		}
	}

}
