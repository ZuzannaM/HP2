package com.moleda.zuzanna.HibernateProject.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.moleda.zuzanna.HibernateProject.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// create record in db
//		for(int i = 1; i<=10; i++){
//			UserDetails user = new UserDetails();
//			user.setUserName("User " + i);
//			session.save(user);
//		}
		
		@SuppressWarnings("unchecked")
		Query<UserDetails> query = session.createQuery("from UserDetails");
		List<UserDetails> users = query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user : users){
			System.out.println(user);
		}
		
		
	}

}
