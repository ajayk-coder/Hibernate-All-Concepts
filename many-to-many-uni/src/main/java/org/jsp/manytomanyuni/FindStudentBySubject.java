package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentBySubject {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the subject");
		String sub=sc.nextLine();
		String jpql="select b.students from Batch b where b.subject=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, sub);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.out.println("Invalid students");
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
