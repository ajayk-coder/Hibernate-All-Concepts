package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindUserByphon {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the phonenumber to display details");
		long phone=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindUserByPhone");
		query.setParameter(1, phone);
		try
		{
			User u=(User)query.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid phone number");
		}
	}

}
