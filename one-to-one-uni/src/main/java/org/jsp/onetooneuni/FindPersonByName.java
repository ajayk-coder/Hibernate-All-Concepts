package org.jsp.onetooneuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindPersonByName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name to display details");
		String name=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindPersonByName");
		query.setParameter(1, name);
		List<person> persons=query.getResultList();
		if(persons.isEmpty()) 
		{
			System.out.println("Invalid name");

		}
		else {
			for(person p:persons)
			{
				System.out.println(p);
			}
		}

	}

}
