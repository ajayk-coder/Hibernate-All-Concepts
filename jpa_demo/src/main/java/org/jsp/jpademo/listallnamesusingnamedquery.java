package org.jsp.jpademo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class listallnamesusingnamedquery {
	public static void main(String[] args) 
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createNamedQuery("listAllName");
		List<String> merchants=query.getResultList();
		for(String m:merchants)
		{
			System.out.println(m);
		}
		
	}

}
