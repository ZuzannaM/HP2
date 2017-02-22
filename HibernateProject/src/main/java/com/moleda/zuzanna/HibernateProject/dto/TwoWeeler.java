package com.moleda.zuzanna.HibernateProject.dto;

import javax.persistence.Entity;

@Entity
public class TwoWeeler extends Vehicle {

	private String SteerelHandler;

	public String getSteerelHandler() {
		return SteerelHandler;
	}

	public void setSteerelHandler(String steerelHandler) {
		SteerelHandler = steerelHandler;
	}
	
	
}
