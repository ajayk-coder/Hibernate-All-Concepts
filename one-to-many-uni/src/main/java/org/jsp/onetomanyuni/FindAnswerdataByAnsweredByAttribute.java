package org.jsp.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerdataByAnsweredByAttribute {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the answer to find AnswerData");
		String answer=sc.next();
		String jpql="select a From Answerdata a where a.answeredBy=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	    EntityManager manager=factory.createEntityManager();
	    Query query=manager.createQuery(jpql);
	    query.setParameter(1, answer);
	    List<Answerdata> answerDatas=query.getResultList();
	    if(answerDatas.isEmpty())
		{
			System.err.println("invalid studentname");
		}
		else
		{
			for(Answerdata ad:answerDatas)
			{
				System.out.println(ad);
			}
		}

	}

}
