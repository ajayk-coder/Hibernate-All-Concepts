package org.jsp.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerdataByQuestionedByAttribute {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the examiner to find answerdata");
		String questionedBy=sc.next();
		String jpql="select q.answers from Questiondata q where q.questionedBy=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, questionedBy);
		List<Answerdata> answers=query.getResultList();
		if( answers.isEmpty())
		{
			System.err.println("no answered found for entered examiner name");
		}
		else
		{
			for(Answerdata ad:answers)
			{
				System.out.println(ad);
			}
		}

	}

}
