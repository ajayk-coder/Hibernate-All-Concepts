package orj.jsp.onetomanybi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindProductsByBrand {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Brand to find product");
		String brand=sc.next();
		String jpql="select p from Product p where p.brand=?1";
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery(jpql);
		query.setParameter(1, brand);
		List<Product> products=query.getResultList();
		if(products.isEmpty())
		{
			System.err.println("Invalid product brand");
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
