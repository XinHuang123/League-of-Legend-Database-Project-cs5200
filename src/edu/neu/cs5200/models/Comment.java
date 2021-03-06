package edu.neu.cs5200.models;

import javax.persistence.*;



/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	private int commentid;
	private String content;
	private String username;
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="championid")
	private Champion championid;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Champion getChampionid() {
		return championid;
	}
	public void setChampionid(Champion championid) {
		this.championid = championid;
	}
	public Comment(int commentid, String content, Champion championid, String username) {
		super();
		this.commentid = commentid;
		this.content = content;
		this.championid = championid;
		this.username=username;
	}
	public Comment() {
		super();
	}

	
}