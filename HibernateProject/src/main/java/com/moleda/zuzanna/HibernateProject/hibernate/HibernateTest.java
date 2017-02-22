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

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWeeler bicycle = new TwoWeeler();
		bicycle.setSteerelHandler("bibycle Seerel handler");
		
		FourWeeler jeep = new FourWeeler();
		jeep.setSteerelWheel("jeep wheeler");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(bicycle);
		session.save(jeep);
		session.getTransaction().commit();
		session.close();
		
	}

}
