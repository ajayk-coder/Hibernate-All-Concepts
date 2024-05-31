package orj.jsp.onetomanybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductsByMerchantId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the merchant id to find products");
		int id=sc.nextInt();
		String jpql="select m.products from Merchant m where m.id=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, id);
		List<Product> products=query.getResultList();
		if(products.isEmpty())
		{
			System.err.println("Invalid products");
		}
		else 
		{
			for(Product p:products)
			{
				System.out.println(p);
			}

		}

	}

}
