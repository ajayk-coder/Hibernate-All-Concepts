package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindPanCardByNumber {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number by display PanCard details");
		String number=sc.next();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("FindPanCardByNumber");
		query.setParameter(1, number);
		try
		{
			PanCard p=(PanCard)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.out.println("Invalid PanCard Number");
		}
	}

}
