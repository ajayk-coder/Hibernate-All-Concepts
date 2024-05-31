package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByPhone {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the phonenumber to display details");
		long phone=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindPersonByPhone");
		query.setParameter(1, phone);
		try
		{
			person p=(person)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid phone number");
		}

	}

}
