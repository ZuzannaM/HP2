package com.moleda.zuzanna.HibernateProject.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.moleda.zuzanna.HibernateProject.dto.Address;
import com.moleda.zuzanna.HibernateProject.dto.FourWeeler;
import com.moleda.zuzanna.HibernateProject.dto.TwoWeeler;
import com.moleda.zuzanna.HibernateProject.dto.UserDetails;
import com.moleda.zuzanna.HibernateProject.dto.Vehicle;


public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// create record in db
//		UserDetails user = new UserDetails();
//		user.setUserName("My name");
//		session.save(user);
		
		// getting from db
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		
		// update record from db
//		user.setUserName("Updated name");
//		session.update(user);
		
		// deleting a record from db
//		session.delete(user);
		
		session.getTransaction().commit();
		session.close();
		
//		System.out.println("User name: " + user.getUserName());
		
	}

}
