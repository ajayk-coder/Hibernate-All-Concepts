package org.jsp.manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDepartment {
	public static void main(String[] args) {
		Department d = new Department ();
		d.setLocation("BTM Layout");
		d.setName("Development");
		
		Employee e1 = new Employee();
		e1.setName("ABC");
		e1.setDesg("Associate Software Engineer");
		e1.setSalary(56785);
		e1.setDepartment(d);
		
		Employee e2 = new Employee();
		e2.setName("PQR");
		e2.setDesg("Senior Software Engineer");
		e2.setSalary(76785);
		e2.setDepartment(d);
		
		Employee e3 = new Employee();
		e3.setName("XYZ");
		e3.setDesg("Junior Software Engineer");
		e3.setSalary(56785);
		e3.setDepartment(d);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(e1);
		manager.persist(e2);
		manager.persist(e3);
		transaction.begin();
		transaction.commit();
	}

}
