package org.jsp.onetoonebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByPanCardNumberAndDob {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the pan card number");
		String number=sc.next();
		System.out.println("Enter the Date Of Birth");
		System.out.println("Enter year");
		int year=sc.nextInt();
		System.out.println("Enter Month");
		int month=sc.nextInt();
		System.out.println("Enter Day of Month");
		int day=sc.nextInt();
		LocalDate dob=LocalDate.of(year, month, day);
		String jpql="select p.user from PanCard  p where p.number=?1 and p.date_of_birth=?2";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, number);
		query.setParameter(2, dob);
		try
		{
			User u=(User)query.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid pancard number and date of birth");
		}
		

	}

}
