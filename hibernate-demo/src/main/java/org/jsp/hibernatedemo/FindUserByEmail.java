package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByEmail {

	public static void main(String[] args) {
		String hql="select u.email from User u";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<String>query=session.createQuery(hql);
	    for(String email:query.getResultList()) {
	    	System.out.println(email);
	    }
	}

}
