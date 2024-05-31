package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharcardBynumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number by display Aadharcard details");
		long number=sc.nextLong();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindAadharcardByNumber");
		query.setParameter(1, number);
		try
		{
			AadharCard a=(AadharCard)query.getSingleResult();
			System.out.println(a);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid Aadharcardnumber");
		}

	}

}
