package org.jsp.manytomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FilterStudentBetweenPercRange {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		String jpql="select s from Student s where s.perc between 65 and 85";
		Query query=manager.createQuery(jpql);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.err.println("Invalid students");
		}
		else
		{
			for(Student s: students)
			{
				System.out.println(s);
			}
		}

	}

}
