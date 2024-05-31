package orj.jsp.onetomanybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindProductsByCost {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the cost to find product");
	  double cost=sc.nextDouble();
		String jpql="select p from Product p where p.cost=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, cost);
		List<Product> products=query.getResultList();
		if(products.isEmpty())
		{
			System.err.println("Invalid product cost");
		}
		else 
		{
			for(Product m:products)
			{
				System.out.println(m);
			}
			
		}

	}

}
