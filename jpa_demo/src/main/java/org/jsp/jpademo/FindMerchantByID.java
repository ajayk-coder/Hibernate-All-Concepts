package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindMerchantByID {

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("enter the merchant id to display details");
		 int id=sc.nextInt();
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("development");
	    EntityManager manager=factory.createEntityManager();
	    Merchant merchant=manager.find(Merchant.class, id);
	    if(merchant!=null) {
	    	System.out.println("merchant found");
	    	System.out.println(merchant);
	    }else
	    	System.err.println("invalid merchant Id");
	}

}
