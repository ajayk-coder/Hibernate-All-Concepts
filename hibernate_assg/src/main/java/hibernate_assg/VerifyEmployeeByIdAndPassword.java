package hibernate_assg;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VerifyEmployeeByIdAndPassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the Id and password");
	    Integer id=sc.nextInt();
	    String password=sc.next();
	    String hql="select e from employeess e where e.id=?1 and e.password=:ps";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employeess>query=session.createQuery(hql);
	    query.setParameter(1, id);
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
