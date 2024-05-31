package org.jsp.hibernatedemo;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class DeleteUser {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the Id to delete User");
    int id=sc.nextInt();
    Session session= new Configuration(). configure().buildSessionFactory().openSession();
    Transaction t=session.beginTransaction();
    User user=session.get(User.class, id);
    if(user !=null) {
    	session.delete(user);
    	t.commit();
    }else
    	System.err.println("cannot delete user as id is invalid");
    
	}

}
