package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPhon {

	public static void main(String[] args) {
    String hql="select u.phon from User u";
    Session session= new Configuration(). configure().buildSessionFactory().openSession();
    Query<Long>query=session.createQuery(hql);
    for(long phon:query.getResultList()) {
    	System.out.println(phon);
    }
	}

}
