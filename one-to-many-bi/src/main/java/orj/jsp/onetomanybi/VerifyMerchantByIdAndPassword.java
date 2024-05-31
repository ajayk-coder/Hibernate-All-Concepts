package orj.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantByIdAndPassword {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the id and password to find merchant");
		int id=sc.nextInt();
		String password=sc.next();
		String jpql="select m from Merchant m where m.id=?1 and password=:ps";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1,id);
		query.setParameter("ps", password);
		try
		{
			Merchant m=(Merchant)query.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid Id And password");
		}
	}

}
