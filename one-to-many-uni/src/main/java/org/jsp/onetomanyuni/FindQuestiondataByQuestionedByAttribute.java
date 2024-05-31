package org.jsp.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestiondataByQuestionedByAttribute {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the examiner name to find question data");
		String q1=sc.next();
		String jpql="select q from Questiondata q where q.questionedBy=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, q1);
		List<Questiondata> questionDataby=query.getResultList();
		if(questionDataby.isEmpty())
		{
			System.err.println("invalid questiondata");
		}
		else
		{
			for(Questiondata qd:questionDataby)
			{
				System.out.println(qd);
			}
		}

	}

}
