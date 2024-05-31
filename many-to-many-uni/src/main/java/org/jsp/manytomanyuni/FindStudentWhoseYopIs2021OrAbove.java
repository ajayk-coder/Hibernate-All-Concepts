package org.jsp.manytomanyuni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentWhoseYopIs2021OrAbove {

	public static void main(String[] args) {
		String jpql="select s from Student s where s.yop>=2021";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.err.println("invalid students");
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
