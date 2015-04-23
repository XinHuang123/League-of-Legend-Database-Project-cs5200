package edu.neu.cs5200.models;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentid;

	private String content;

	
	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="commenter")
	private User user;

	public Comment() {
		super();
	}

	public int getCommentid() {
		return this.commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Comment(User user, String content, String title) {
		super();
		this.user = user;
		this.content = content;
		this.title = title;
	}

	
	
}