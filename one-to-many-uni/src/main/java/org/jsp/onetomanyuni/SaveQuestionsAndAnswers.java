package org.jsp.onetomanyuni;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveQuestionsAndAnswers {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	    EntityManager manager=factory.createEntityManager();
	    EntityTransaction transaction=manager.getTransaction();
	    Questiondata question=new Questiondata();
	    
	    question.setQuestion("What are the specifications of ORM?");
	    question.setQuestionedBy("keshava");
	    
	    Answerdata answer1=new Answerdata();
	    answer1.setAnswer("every entity class will represent a table in the database server");
	    answer1.setAnsweredBy("radhe");
	    
	    Answerdata answer2=new Answerdata();
	    answer2.setAnswer("every fiels of an entity class represents a column in the table");
	    answer2.setAnsweredBy("bansi");
	    
	    Answerdata answer3=new Answerdata();
	    answer3.setAnswer("every object of an entity class will represents a record in the database server");
	    answer3.setAnsweredBy("arzoo");
	    
	   question.setAnswers(Arrays.asList(answer1,answer2,answer3));
	    manager.persist(question);
	    transaction.begin();
	    transaction.commit();
	}

}
