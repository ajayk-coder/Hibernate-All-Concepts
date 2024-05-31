package org.jsp.manytomanybi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class SaveBatchAndStudent {

	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Batch b1=new Batch();
		b1.setBatch_code("HID-E3");
		b1.setSubject("Hibernate");
		b1.setTrainer("Sathish");
		
		Batch b2=new Batch();
		b2.setBatch_code("ADD-A4");
		b2.setSubject("Advanced java");
		b2.setTrainer("Gururaj");
		
		Student s1=new Student();
		s1.setName("maitry");
		s1.setYop(2022);
		s1.setPerc(75);
		
		Student s2=new Student();
		s2.setName("heer");
		s2.setYop(2023);
		s2.setPerc(65);
		
		Student s3=new Student();
		s3.setName("nirav");
		s3.setYop(2021);
		s3.setPerc(85);
		
		List<Student> forB1=new ArrayList<Student>(Arrays.asList(s1,s3));
		List<Student> forB2 =new ArrayList<Student>(Arrays.asList(s1,s2,s3));
		
		List<Batch> forS1=new ArrayList<Batch>(Arrays.asList(b1,b2));
		List<Batch> forS2=new ArrayList<Batch>(Arrays.asList(b2));
		List<Batch> forS3=new ArrayList<Batch>(Arrays.asList(b1,b2));
		
		s1.setBatches(forS1);
		s2.setBatches(forS2);
		s2.setBatches(forS3);
		
		
		
		b1.setStudents(forB1);//Assigning students to 1st batch
		b1.setStudents(forB2);//Assigning students to 2nd batch
		
		manager.persist(b1);
		manager.persist(b2);
		transaction.begin();
		transaction.commit();
		
		
		
	}

}
