package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharCardByPhone {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the person phone");
	    long phone=sc.nextLong();

    String jpql="select p.aadhar from person p where p.phone=?1 ";
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	EntityManager manager=factory.createEntityManager();
	Query query=manager.createQuery(jpql);
	query.setParameter(1, phone);
	try {
		AadharCard card=(AadharCard)query.getSingleResult();
		System.out.println(card);
	}catch(NoResultException e) {
		System.err.println("Invalid person phone");
	}
	}

}
