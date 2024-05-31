package org.jsp.onetomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAnswerDataFromQuestionId {

	public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter the Questiondata id to fetch answers");
    int qid=s.nextInt();
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    EntityManager manager=factory.createEntityManager();
    String jpql="select q.answers from Questiondata q where q.id=?1";
    Query q= manager.createQuery(jpql);
    q.setParameter(1, qid);
    List<Answerdata> answers=q.getResultList();
    if(answers.isEmpty())
    	System.err.println("No answer found for entered questiondata");
    else
    	for(Answerdata answerdataa:answers);
    		System.out.println(answers);
    
	}

}
