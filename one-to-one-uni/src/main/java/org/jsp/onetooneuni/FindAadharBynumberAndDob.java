package org.jsp.onetooneuni;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharBynumberAndDob {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the aadharcard number");
    long number=sc.nextLong();
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
	String jpql="select a from AadharCard a where a.number=?1 and a.date_of_birth=?2";
	Query query=manager.createQuery(jpql);
	query.setParameter(1, number);
	query.setParameter(2, dob);
	try {
		AadharCard card=(AadharCard)query.getSingleResult();
		System.out.println(card);
	}catch(NoResultException e) {
		System.err.println("Invalid AadharCard number or date of birth");
	}
	
	}

}
