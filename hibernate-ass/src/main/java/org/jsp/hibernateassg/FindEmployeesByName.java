package org.jsp.hibernateassg;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FindEmployeesByName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the name to print details");
	    String name=sc.next();
	    String hql="select e from Employees e where e.name=?1";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employees>query=session.createQuery(hql);
	    query.setParameter(1, name);
	    List<Employees> emp=query.getResultList();
	    if(emp.isEmpty())
	    	System.err.println("no user with entered name");
	    else
	    	for(Employees EMP:emp)
	    		System.out.println(EMP);
	}

}
