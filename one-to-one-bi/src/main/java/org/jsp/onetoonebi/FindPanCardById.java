package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindPanCardById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Ente the id to diplay pancard");
		int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindPanCardById");
		query.setParameter(1, id);
		try {
		PanCard a=(PanCard)query.getSingleResult();
			System.out.println(a);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid PanCard details");
		}
	}

}
