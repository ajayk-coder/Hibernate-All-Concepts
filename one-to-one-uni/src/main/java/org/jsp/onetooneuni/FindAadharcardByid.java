package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharcardByid {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ente the id to diplay adharcard");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindAadharcardByid");
		query.setParameter(1, id);
		try {
			AadharCard a=(AadharCard)query.getSingleResult();
			System.out.println(a);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid Aadharcard details");
		}

	}

}
