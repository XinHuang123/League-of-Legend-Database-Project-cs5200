package edu.neu.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)// ignore unknown
public class User {
	@Id	
	private String username;//primary key
	private String password;
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="id")
	//private Champion champion;
	
	//public Champion getChampion() {
	//	return champion;
	//}
	//public void setChampion(Champion champion) {
	//	this.champion = champion;
	//}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public User(String username, String password) {
		super();
		this.username=username;
		this.password=password;
		//this.champion=champion;
	}
	public User() {
		super();
	}
	
	

}
