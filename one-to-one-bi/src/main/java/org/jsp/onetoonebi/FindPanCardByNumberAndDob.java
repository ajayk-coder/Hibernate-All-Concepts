package org.jsp.onetoonebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindPanCardByNumberAndDob {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("enter the pancard number");
	    String number=sc.next();
	    System.out.println("enter the date of birth");
	    System.out.println("enter year");
	    int year=sc.nextInt();
	    System.out.println("enter month");
	    int month=sc.nextInt();
	    System.out.println("enter day");
	    int day=sc.nextInt();
	    LocalDate dob=LocalDate.of(year, month, day);
	    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		String jpql="select p.user from PanCard p where p.number=?1 and p.date_of_birth=?2";
		Query query=manager.createQuery(jpql);
		query.setParameter(1, number);
		query.setParameter(2, dob);
		try {
			User card=(User)query.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Invalid PanCard number or date of birth");
		}
	}

}
