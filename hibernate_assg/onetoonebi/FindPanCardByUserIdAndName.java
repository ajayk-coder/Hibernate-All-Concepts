package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByUserIdAndName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the user id and name to fetch pancard details");
		int id=sc.nextInt();
		String name=sc.next();
		String jpql="select u.card from User u where u.id=?1 and u.name=?2";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		query.setParameter(2, name);
		try
		{
			PanCard p=(PanCard)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid user id and name");
		}

	}

}
