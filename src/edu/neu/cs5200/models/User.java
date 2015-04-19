package edu.neu.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)// ignore unknown
public class User {
	@Id
	private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User() {
		super();
	}
	
	

}
