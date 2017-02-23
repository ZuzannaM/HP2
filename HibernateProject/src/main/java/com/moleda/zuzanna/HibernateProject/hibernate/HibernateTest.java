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
		CriteriaQuery<UserDetails> qdef = criteriaBuilder.createQuery(UserDetails.class);
		
		// selecting root component
		Root<UserDetails> root = qdef.from(UserDetails.class);
		
		// getting all entities from root component
		qdef.select(root);
		
		// creating query which must be translated to SQL
		TypedQuery<UserDetails> typedQuery = session.createQuery(qdef);
		
		// getting list of object as the result of created query
		List<UserDetails> users = typedQuery.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u : users)
			System.out.println(u);
		
	}

}
