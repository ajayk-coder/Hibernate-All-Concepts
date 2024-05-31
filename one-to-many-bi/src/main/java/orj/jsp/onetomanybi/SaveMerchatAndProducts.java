package orj.jsp.onetomanybi;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchatAndProducts {
	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Merchant m = new Merchant();
	m.setName("nirav");
	m.setPhone(987653676L);
	m.setGst_number("AB17234");
	m.setPassword("ABC2t");
	
	Product p1 = new Product();
	p1.setName("SmartPhone");
	p1.setCategory("Electronics");
	p1.setBrand("Samsung");
	p1.setDescription("8GB- RAM");
	p1.setCost(54967);
	p1.setM(m);

	Product p2 = new Product();
	p2.setName("TV");
	p2.setCategory("Electronics");
	p2.setBrand("PANASONIC");
	p2.setDescription("52 INCHES");
	p2.setCost(59467);
	p2.setM(m);
	

	Product p3 = new Product();
	p3.setName("LAPTOP");
	p3.setCategory("Electronics");
	p3.setBrand("HP");
	p3.setDescription("8GB- RAM");
	p3.setCost(54867);
	p3.setM(m);
	
	m.setProducts(Arrays.asList(p1,p2,p3));
	manager.persist(m);
	transaction.begin();
	transaction.commit();
	
	
	 
	}

}
