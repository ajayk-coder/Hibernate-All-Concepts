package orj.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id to find product");
		int id=sc.nextInt();
		String jpql="select p from Product p where p.id=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		try
		{
			Product p=(Product)query.getSingleResult();
			System.out.println(p);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid ID");
		}
	}

}
