package org.jsp.onetoonebi;



	import java.util.Scanner;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.NoResultException;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

	public class FindUserByPanCardId 
	{
		public static void main(String[] args) 
		{
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the pancard id to display details");
			int id=sc.nextInt();
			String jpql="select p.user from PanCard p where p.id=?1 ";
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
			EntityManager manager=factory.createEntityManager();
			Query query=manager.createQuery(jpql);
			query.setParameter(1, id);
			try {
				User u=(User)query.getSingleResult();
				System.out.println(u);
			}
			catch(NoResultException e)
			{
				System.err.println("No users found");
			}
			
		}

	}

