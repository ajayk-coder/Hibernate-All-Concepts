package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonById {

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter id to display details");
    int id=sc.nextInt();
    EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
    EntityManager manager=factory.createEntityManager();
    person Person=manager.find(person.class, id);
    if(Person!=null) {
    	System.out.println("person found");
    	System.out.println(Person);
    }
    else
    	System.out.println("invalid person id");
	}

}
