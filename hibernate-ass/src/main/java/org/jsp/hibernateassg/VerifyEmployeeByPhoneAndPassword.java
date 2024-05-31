package org.jsp.hibernateassg;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VerifyEmployeeByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the email  and password");
	    String email=sc.next();
	    String password=sc.next();
	    String hql="select e from Employees e where e.email=?1 and e.password=:ps";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employees>query=session.createQuery(hql);
	    query.setParameter(1, email);
	    query.setParameter("ps", password);
	    try {
	    	Employees emp=query.getSingleResult();
	    	System.out.println("verification successfully");
	    	System.out.println(emp);
	    }catch(NoResultException e) {
	    	System.err.println("invalid phon and password");
	    }
	}

}
