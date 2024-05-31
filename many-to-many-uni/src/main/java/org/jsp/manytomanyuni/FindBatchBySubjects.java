package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindBatchBySubjects {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the subject to find batch");
		String subject=sc.next();
		String jpql="select b from Batch b where b.subject=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, subject);
		try
		{
			Batch b=(Batch)query.getSingleResult();
			System.out.println(b);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid subject");
		}	
	}

}
