package edu.neu.cs5200.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.neu.cs5200.models.Movie;



public class MovieDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	//createMovie
	private Movie createMovie(Movie movie) {
		em.getTransaction().begin();		
		em.persist(movie);
		em.getTransaction().commit();
		return movie;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieDAO dao=new MovieDAO();
		Movie movie=new Movie(null, "123", "nihao");
		movie=dao.createMovie(movie);
		System.out.println(movie.getId());

	}

	

}
