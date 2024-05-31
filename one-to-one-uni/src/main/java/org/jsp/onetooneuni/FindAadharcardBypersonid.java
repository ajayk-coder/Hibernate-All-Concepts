package org.jsp.onetooneuni;



	import java.util.Scanner;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.NoResultException;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	public class FindAadharcardBypersonid {
			public static void main(String[] args) {
				Scanner sc=new Scanner(System.in);
				int id=sc.nextInt();
					EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
					EntityManager manager=factory.createEntityManager();
					Query query=manager.createQuery("select a from AadharCard a,person p where a.id=p.id and p.id=?1");
					 query.setParameter(1,id);
					 try {
						  System.out.println( query.getSingleResult());
						    	
						    }
						    catch(NoResultException e) {
						    	System.err.println("Invalid");
						    	}

				}
		
	}

