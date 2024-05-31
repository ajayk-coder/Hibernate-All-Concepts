package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchByLoad {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		    System.out.println("enter the user id to display details:");
		    int id=sc.nextInt();
		    Configuration cfg=new Configuration().configure();
		    SessionFactory factory =cfg.buildSessionFactory();
		    Session session=factory.openSession();
		    User user=session.load(User.class, id);
		    try {
		    	System.out.println(user);
		    }catch(ObjectNotFoundException e) {
		    	System.err.println("invalid id");
		    }
	}

}
