package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindStudentByYop {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the yop to find student");
		int yop=sc.nextInt();
		String jpql="select s from Student s where s.yop=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, yop);
		try
		{
			Student  s=(Student )query.getSingleResult();
			System.out.println(s);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid yop");
		}
	}

}
