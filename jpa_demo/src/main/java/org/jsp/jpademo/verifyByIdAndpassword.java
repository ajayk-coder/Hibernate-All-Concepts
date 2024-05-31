package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class verifyByIdAndpassword {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id and password");
		int id=sc.nextInt();
		String password=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("verifyByIdAndPassword");
		query.setParameter(1, id);
		query.setParameter(2, password);
		try {
			Merchant m=(Merchant)query.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e)
		{
			System.err.println("invalid");
		}
		
	}

}
