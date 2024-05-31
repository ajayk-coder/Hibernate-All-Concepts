package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByUserPhone {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the phone no to find pancard");
		long phone=sc.nextLong();
		String jpql="select u.card from User u where u.phone=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, phone);
		try
		{
			PanCard p=(PanCard)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid id");
		}

	}

}
