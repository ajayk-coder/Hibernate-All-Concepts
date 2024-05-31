package org.jsp.manytomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentWhosePercIsGreaterThan85 {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		String jpql="select s from Student s where s.perc>85";
		Query query=manager.createQuery(jpql);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.out.println("Invalid Students");
		}
		else
		{
			for(Student s:students)
			{
				System.out.println(s);
			}
		}
		

	}

}
