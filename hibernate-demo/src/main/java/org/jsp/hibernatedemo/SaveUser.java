package org.jsp.hibernatedemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the name,phon.email or password");
	User user= new User();
	user.setName(sc.next());
	user.setPhon(sc.nextLong());
	user.setEmail(sc.next());
	user.setPassword(sc.next());
	Session session=new Configuration().configure().buildSessionFactory().openSession();
	int id=(Integer)session.save(user);
	Transaction t= session.beginTransaction();
	t.commit();
	System.out.println("user saved with id"+id);
			
}
}
