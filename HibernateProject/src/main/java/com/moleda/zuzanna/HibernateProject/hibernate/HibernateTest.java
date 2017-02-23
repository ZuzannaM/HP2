package com.moleda.zuzanna.HibernateProject.hibernate;

import java.util.List;
import java.util.Map;

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
		
		String userId = "5";
		String userName = "User 9";
		
//		@SuppressWarnings("unchecked")
//		Query<UserDetails> query = session.createQuery("from UserDetails where userId < ?");
//		query.setInteger(0, Integer.parseInt(userId));
//		query.setFirstResult(5);
//		query.setMaxResults(4);
//		List<UserDetails> users = session.createQuery("from UserDetails where userId > :userId and userName = :userName")
//			.setParameter("userId", Integer.parseInt(userId))
//			.setParameter("userName", userName)
//			.list();
		
		// Query constructed in UserDetails class
		Query<UserDetails> query = session.getNamedQuery("UserDetails.byId");
		query.setParameter("userId", 9);
		List<UserDetails> users = query.list();
		
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : users)
			System.out.println(u);
		
	}

}
