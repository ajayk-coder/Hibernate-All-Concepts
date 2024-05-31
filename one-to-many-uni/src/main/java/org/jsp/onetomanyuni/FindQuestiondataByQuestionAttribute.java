package org.jsp.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestiondataByQuestionAttribute {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the question attribute to find Question data");
		String question=sc.nextLine();
		String jpql="select q from QuestionData q where q.question=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, question);
		List<Questiondata> questiondatas=query.getResultList();
		if(questiondatas.isEmpty())
		{
			System.err.println("invalid questiondata");
		}
		else
		{
			for(Questiondata qd:questiondatas)
			{
				System.out.println(qd);
			}
		}

	}

}
