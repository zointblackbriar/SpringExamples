package org.tu_dresden.de.internal.entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private final String name;
	private final String email;
	
	public User() {
		this.name = "";
		this.email = "";
	}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "User{" + "id= " + id + "name= " + name + "email= " + email + "}";
	}
}
