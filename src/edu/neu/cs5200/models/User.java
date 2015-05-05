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
	private String role;
	private String firstname;
	private String lastname;
	private String dateofbirth;
	
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
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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
	
	public User(String username, String password, String role, Champion championid, String firstname, String lastname, String dateofbirth) {
		super();
		this.username=username;
		this.password=password;
		this.role=role;
		this.championid=championid;
		//this.champion=champion;
		this.firstname=firstname;
		this.lastname=lastname;
		this.dateofbirth=dateofbirth;
	}
	public User() {
		super();
	}
	
	

}
