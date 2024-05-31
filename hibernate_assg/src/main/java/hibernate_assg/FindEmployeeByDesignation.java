package hibernate_assg;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByDesignation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the name to print details");
	    String designation=sc.next();
	    String hql="select  e from employeess e where e.designation=?1";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employeess>query=session.createQuery(hql);
	    query.setParameter(1, designation);
	    List<Employeess> empp=query.getResultList();
	    if(empp.isEmpty())
	    	System.err.println("no user with entered designation");
	    else
	    	for(Employeess emp:empp)
	    		System.out.println(empp);
	}

}
