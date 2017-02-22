package com.moleda.zuzanna.HibernateProject.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Temporal(TemporalType.DATE)
	private Date joined;

	@ElementCollection
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();

	@Lob
	private String description;

//	@OneToMany
//	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
//	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
//	@OneToMany(mappedBy="user")
//	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
//	@ManyToMany
//	@JoinTable(name="USER_VEHICLE", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
//	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	// @OneToOne
	// @JoinColumn(name="VEHICLE_ID")
	// private Vehicle vehicle;
	//
	// public Vehicle getVehicle() {
	// return vehicle;
	// }
	// public void setVehicle(Vehicle vehicle) {
	// this.vehicle = vehicle;
	// }
	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
