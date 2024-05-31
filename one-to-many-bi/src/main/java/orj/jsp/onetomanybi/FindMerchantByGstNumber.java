package orj.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByGstNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the gst number to find merchant");
		String gst_number=sc.next();
		String jpql="select m from Merchant m where m.gst_number=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, gst_number);
		try
		{
			Merchant m=(Merchant)query.getSingleResult();
			System.out.println(m);
		}
		catch(NoResultException e)
		{
			System.err.println("Invalid Gst Number");
		}
	}

}
