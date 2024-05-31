package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindPanCardByUserId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the user id to find pancard");
	    int id=sc.nextInt();

    String jpql="select u.card from User u where u.id=?1 ";
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	EntityManager manager=factory.createEntityManager();
	Query query=manager.createQuery(jpql);
	query.setParameter(1, id);
	try {
		PanCard card=(PanCard)query.getSingleResult();
		System.out.println(card);
	}catch(NoResultException e) {
		System.err.println("Invalid user Id");
	}
	}

}
