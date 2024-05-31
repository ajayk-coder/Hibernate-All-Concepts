package hibernate_assg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployees {
	public static void main(String[] args) {
		 Configuration cfg=new Configuration().configure();
		    SessionFactory factory=cfg.buildSessionFactory();
		    Session session=factory.openSession();
		    Transaction transaction=session.beginTransaction();
		    Employeess emp=new Employeess(); //Transient state
		    emp.setId(3);
		    emp.setName("dfgh");
		    emp.setEmail("rrda@gmail.com");
		    emp.setPhon(867568875l);
		    emp.setPassword("yuujg77");
		    emp.setDesignation("kjhgfg");
		    emp.setSalary(50000.0);
		    session.saveOrUpdate(emp);
		    transaction.commit();
	}
}
