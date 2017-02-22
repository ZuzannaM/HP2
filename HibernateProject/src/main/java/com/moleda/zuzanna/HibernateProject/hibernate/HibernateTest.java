package com.moleda.zuzanna.HibernateProject.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.moleda.zuzanna.HibernateProject.dto.Address;
import com.moleda.zuzanna.HibernateProject.dto.UserDetails;
import com.moleda.zuzanna.HibernateProject.dto.Vehicle;


public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
//		user.setUserId(1);
		user.setUserName("First User");
		user.setJoined(new Date());
		user.setDescription("First user description goes here");
		
		Address addr1 = new Address();
		addr1.setStreet("Street");
		addr1.setCity("City");
		addr1.setPincode("1234");
		
		user.getListOfAddress().add(addr1);
		
		Address addr2 = new Address();
		addr2.setStreet("Street 2");
		addr2.setCity("City 2");
		addr2.setPincode("12345");
		
		user.getListOfAddress().add(addr2);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Bicycle");
		
		
		user.getVehicles().add(vehicle);
		user.getVehicles().add(vehicle2);
		
//		vehicle.getUserList().add(user);
//		vehicle2.getUserList().add(user);
//		
//		vehicle.setUser(user);
//		vehicle2.setUser(user);
		
//		vehicle.assignVehicleToUser(user);
//		vehicle2.assignVehicleToUser(user);
		
//		vehicle.getUserList().add(user);
//		vehicle2.getUserList().add(user);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
//		session.save(vehicle);
//		session.save(vehicle2);
		session.getTransaction().commit();
		session.close();
		
//		user = null;
//		System.out.println("User is set to null: " + user);
//		
//		session = sessionFactory.openSession();
//		session.beginTransaction();
//		user = (UserDetails) session.get(UserDetails.class, 1);
//		System.out.println("Get user listOfAddress-size(): " + user.getListOfAddress().size());
//		session.getTransaction().commit();
//		session.close();
	}

}
