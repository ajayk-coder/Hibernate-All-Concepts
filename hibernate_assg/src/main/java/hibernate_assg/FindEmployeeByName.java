package hibernate_assg;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FindEmployeeByName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the name to print details");
	    String name=sc.next();
	    String hql="select  e from employeess e where e.name=?1";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employeess>query=session.createQuery(hql);
	    query.setParameter(1, name);
	    List<Employeess> empp=query.getResultList();
	    if(empp.isEmpty())
	    	System.err.println("no user with entered name");
	    else
	    	for(Employeess user:empp)
	    		System.out.println(empp);
	}

}
