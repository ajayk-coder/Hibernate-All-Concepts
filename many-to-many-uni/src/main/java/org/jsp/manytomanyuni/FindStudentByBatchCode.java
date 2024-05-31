package org.jsp.manytomanyuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByBatchCode {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the batch_code ");
		String bcode=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		String jpql="select b.students from Batch b where b.batch_code=?1";
		Query query=manager.createQuery(jpql);
		query.setParameter(1, bcode);
		List<Student> students=query.getResultList();
		if(students.isEmpty())
		{
			System.out.println("Invalid Batch_code");
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
