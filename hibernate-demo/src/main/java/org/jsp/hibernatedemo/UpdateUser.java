package org.jsp.hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {
    Configuration cfg=new Configuration().configure();
    SessionFactory factory=cfg.buildSessionFactory();
    Session session=factory.openSession();
    Transaction transaction=session.beginTransaction();
    User user=session.get(User.class, 1); //persistent state
    user.setName("nirav1");
    user.setEmail("nirav@gmail3.com");
    transaction.commit();
	}

}
