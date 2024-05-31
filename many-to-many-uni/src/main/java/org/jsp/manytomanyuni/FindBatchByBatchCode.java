package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchByBatchCode {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the batch code to find batch");
		String batch_code=sc.next();
		String jpql="select b from Batch b where b.batch_code=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, batch_code);
		try
		{
			Batch b=(Batch)query.getSingleResult();
			System.out.println(b);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid batchcode");
		}	
	}

}
