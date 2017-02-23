package com.moleda.zuzanna.HibernateProject.hibernate;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.moleda.zuzanna.HibernateProject.dto.UserDetails;


public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// get CriteriaBuilder object to form wanted CriteriaQuery object
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		
		// define particular query
		CriteriaQuery<Object[]> qdef = criteriaBuilder.createQuery(Object[].class);
		
		// selecting root component
		Root<UserDetails> root = qdef.from(UserDetails.class);
		
		// getting all entities from root component - here is a time to add more criteria to the query
		qdef.select(criteriaBuilder.array(root.get("userId"), root.get("userName")));
		
		// creating query which must be translated to SQL
		TypedQuery<Object[]> typedQuery = session.createQuery(qdef);
		
		// getting list of object as the result of created query
		List<Object[]> users = typedQuery.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		for(Object[] u : users) {
			Integer userId = (Integer) u[0];
			String userName = (String) u[1];
			
			System.out.println("Printed user -> id: " + userId + " userName: " + userName);
		}
			
		
		
	}

}
