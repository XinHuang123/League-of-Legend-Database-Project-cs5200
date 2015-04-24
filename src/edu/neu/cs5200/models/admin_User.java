package edu.neu.cs5200.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user")
@JsonIgnoreProperties(ignoreUnknown=true)// ignore unknown
public class admin_User {
	@Id	
	private String username;//primary key
	private String password;
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="championid")  // point to user table in database(cloumn: championid)
	private Champion championid;	
	
	
	
	//public Champion getChampion() {
	//	return champion;
	//}
	//public void setChampion(Champion champion) {
	//	this.champion = champion;
	//}
	
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
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
	
	public Champion getChampionid() {
		return championid;
	}
	public void setChampionid(Champion championid) {
		this.championid = championid;
	}
	
	public admin_User(String username, String password, String role, Champion championid) {
		super();
		this.username=username;
		this.password=password;
		this.role=role;
		this.championid=championid;
		//this.champion=champion;
	}
	public admin_User() {
		super();
	}
	
	

}

