package org.jsp.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateByMergeMethod {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
		  EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
	    Merchant m=new Merchant();
	    m.setId(1);
	    m.setEmail("abcd@gmail.com");
	    m.setName("ABCE");
	    m.setGst_number("ABCD123456");
	    m.setPhon(657467354l);
	    m.setPassword("abcd@123");
	    m=manager.merge(m);
	    transaction.begin();
	    transaction.commit();
		

}
}