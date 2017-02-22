package com.moleda.zuzanna.HibernateProject.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
//	@ManyToOne
//	@JoinColumn(name="USER_ID")
//	private UserDetails user;
	
//	public UserDetails getUser() {
//		return user;
//	}
//	public void setUser(UserDetails user) {
//		this.user = user;
//	}
	
//	@ManyToMany(mappedBy="vehicles")
//	private Collection<UserDetails> userList = new ArrayList<UserDetails>();
//	
//	public void assignVehicleToUser(UserDetails u){
//		setUser(u);
//		u.getVehicles().add(this);
//	}
	
	
//	public Collection<UserDetails> getUserList() {
//		return userList;
//	}
//	public void setUserList(Collection<UserDetails> userList) {
//		this.userList = userList;
//	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
