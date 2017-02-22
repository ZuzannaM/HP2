package com.moleda.zuzanna.HibernateProject.dto;

import javax.persistence.Entity;

@Entity
public class FourWeeler extends Vehicle {

	private String SteerelWheel;

	public String getSteerelWheel() {
		return SteerelWheel;
	}

	public void setSteerelWheel(String steerelWheel) {
		SteerelWheel = steerelWheel;
	}
	
	
}
