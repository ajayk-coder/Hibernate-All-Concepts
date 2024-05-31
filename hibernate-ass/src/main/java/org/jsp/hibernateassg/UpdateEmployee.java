package org.jsp.hibernateassg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateEmployee {

	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure();
		    SessionFactory factory=cfg.buildSessionFactory();
		    Session session=factory.openSession();
		    Transaction transaction=session.beginTransaction();
		    Employees emp=new Employees(); //Transient state
		    emp.setId(5);
		    emp.setName("radhe");
		    emp.setEmail("ra@gmail.com");
		    emp.setPhon(867567465l);
		    emp.setPassword("ythg77");
		    emp.setDesignation("trainer");
		    emp.setSalary(40000.0);
		    session.saveOrUpdate(emp);
		    transaction.commit();
	}

}
