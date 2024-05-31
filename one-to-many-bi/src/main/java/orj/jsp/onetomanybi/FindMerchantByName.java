package orj.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name to find merchant");
		String name=sc.next();
		String jpql="select m from Merchant m where m.name=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, name);
		try
		{
			Merchant m=(Merchant)query.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid name");
		}
	}

}
