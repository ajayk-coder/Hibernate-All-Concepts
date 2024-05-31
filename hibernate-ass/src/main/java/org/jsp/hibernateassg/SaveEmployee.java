package org.jsp.hibernateassg;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name,phon.email or password");
		Employees emp= new Employees();
		emp.setName(sc.next());
		emp.setPhon(sc.nextLong());
		emp.setEmail(sc.next());
		emp.setPassword(sc.next());
		emp.setDesignation(sc.next());
		emp.setSalary(sc.nextDouble());
		Session session=new Configuration().configure().buildSessionFactory().openSession();
		int id=(Integer)session.save(emp);
		Transaction t= session.beginTransaction();
		t.commit();
		System.out.println("employee saved with id"+id);
	}

}
