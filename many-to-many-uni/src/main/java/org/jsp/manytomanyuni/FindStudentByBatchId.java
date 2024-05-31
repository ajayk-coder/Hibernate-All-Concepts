package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindStudentByBatchId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the batch id to find Students");
		int id=sc.nextInt();
		String jpql="select b.students from Batch b where b.id=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.err.println("Invalid id");
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


