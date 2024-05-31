package orj.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class MerchantById {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id to find merchant");
		int id=sc.nextInt();
		String jpql="select m from Merchant m where m.id=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		try
		{
			Merchant m=(Merchant)query.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid ID");
		}
	}

}
