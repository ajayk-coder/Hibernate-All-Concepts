package org.jsp.onetoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FindUserByName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the name to display details");
		String name=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindUserByName");
		query.setParameter(1, name);
		List<User> users=query.getResultList();
		if(users.isEmpty()) 
		{
			System.out.println("Invalid name");

		}
		else {
			for(User u:users)
			{
				System.out.println(u);
			}
	}

	}
}
