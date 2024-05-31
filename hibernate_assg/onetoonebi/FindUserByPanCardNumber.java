package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByPanCardNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Pancard number to find user");
		String number=sc.next();
		String jpql="select p.user from PanCard p where p.number=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, number);
		try
		{
			User u=(User)query.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid number");
		}

	}

}
