package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser2 {

	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure();
		    SessionFactory factory=cfg.buildSessionFactory();
		    Session session=factory.openSession();
		    Transaction transaction=session.beginTransaction();
		    User user=new User(); //Transient state
		    user.setId(25);
		    user.setName("dhruvi");
		    user.setEmail("dhruvi12332l.com");
		    user.setPhon(7283831123l);
		    user.setPassword("dhruvi233");
		    session.saveOrUpdate(user);
		    transaction.commit();
		    
	}

}
