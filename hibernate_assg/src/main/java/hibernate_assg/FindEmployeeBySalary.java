package hibernate_assg;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeBySalary {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the name to print details");
	    double salary=sc.nextDouble();
	    String hql="select  e from employeess e where e.salary=?1";
	    Session session= new Configuration(). configure().buildSessionFactory().openSession();
	    Query<Employeess>query=session.createQuery(hql);
	    query.setParameter(1, salary);
	    List<Employeess> empp=query.getResultList();
	    if(empp.isEmpty())
	    	System.err.println("no user with entered name");
	    else
	    	for(Employeess emp:empp)
	    		System.out.println(empp);
	}

}
