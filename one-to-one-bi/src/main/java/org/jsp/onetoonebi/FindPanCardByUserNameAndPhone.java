package org.jsp.onetoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPanCardByUserNameAndPhone {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name and phone to find pancard details");
		String name=sc.next();
		long phone=sc.nextLong();
		String jpql="select u.card from User u where u.name=?1 and u.phone=?2";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, name);
		query.setParameter(2, phone);
		List<PanCard> pancards=query.getResultList();
//		if(pancards.isEmpty())
//		{
//			System.err.println("Invalid name and phone");
//		}
//		else
//		{
//			for(PanCard p:pancards)
//			{
//				System.out.println(p);
//			}
//		}
		try
		{
			PanCard p=(PanCard)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.out.println("Inavlid name and phone");
		}

	}

}
