package org.jsp.hibernateassg;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteEmployee {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		    System.out.println("Enter the Id to delete Employee");
		    int id=sc.nextInt();
		    Session session= new Configuration(). configure().buildSessionFactory().openSession();
		    Transaction t=session.beginTransaction();
		    Employees emp=session.get(Employees.class, id);
		    if(emp !=null) {
		    	session.delete(emp);
		    	t.commit();
		    }else
		    	System.err.println("cannot delete employee as id is invalid");
	}

}
