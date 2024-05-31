package hibernate_assg;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VerifyEmployeeByPhoAndPassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the phon number and password");
	    long phon=sc.nextLong();
	    String password=sc.next();
	    String hql="select e from employeess e where e.phon=?1 and e.password=:ps";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employeess>query=session.createQuery(hql);
	    query.setParameter(1, phon);
	    query.setParameter("ps", password);
	    try {
	    	Employeess empp=query.getSingleResult();
	    	System.out.println("verification successfully");
	    	System.out.println(empp);
	    }catch(NoResultException e) {
	    	System.err.println("invalid phon and password");
	    }
	}

}
