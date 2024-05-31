package org.jsp.onetomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id to find AnswerData");
		int id=sc.nextInt();
		String jpql="select a from Answerdata a where a.id=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		try
		{
			Answerdata qd=(Answerdata)query.getSingleResult();
			System.out.println(qd);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid ID");
		}

	}

}
