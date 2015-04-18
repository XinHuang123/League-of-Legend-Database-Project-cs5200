package edu.neu.cs5200.models;

import javax.persistence.*;

@Entity
public class Movie {
	@Id
	private Integer id;
	private String title;
	private String plot;
	private String poster;
	private String movieId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public Movie(Integer id, String title, String plot) {
		super();
		this.id = id;
		this.title = title;
		this.plot = plot;
		this.poster = poster;
		this.movieId = movieId;
	}
	public Movie() {
		super();
	}
		

}
