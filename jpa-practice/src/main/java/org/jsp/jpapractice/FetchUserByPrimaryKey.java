package org.jsp.jpapractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FetchUserByPrimaryKey {

	public static void main(String[] args) {
		EntityManagerFactory  factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		UserId userId=new UserId();
		userId.setEmail("xyz@gmail.com");
		userId.setPhone(635205532l);
		User user=manager.find(User.class, userId);
		if(user!=null) {
			System.out.println("User Name:"+user.getName());
			System.out.println("Phone Number"+user.getUserId().getPhone());
			System.out.println("Email Id:"+user.getUserId().getEmail());
		}else
			System.err.println("Invalid Phone Number or Email Id");
	}

}
