package edu.neu.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;

import edu.neu.cs5200.models.*;
import edu.neu.cs5200.dao.*;
public class CommentDAO {
 
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
       
  
       
       
        public void createComment (Comment comment) {      
               
               
               
                em.getTransaction().begin();
                em.persist(comment);
                em.getTransaction().commit();
        }
    
        public List<Comment> readAllComments()
    	{
    		Query query = em.createQuery("select comment from Comment comment");
    		return (List<Comment>)query.getResultList();
    	}
    	
        public void deleteComment(int commentid) {
    		em.getTransaction().begin();
    		Comment comment = em.find(Comment.class, commentid);
    		em.remove(comment);
    		em.getTransaction().commit();
    	}
    
      
      //  public List<Champion> readChampionByChampionid(Champion id)
    //	{
     //   	Query query = em.createQuery("select comment.championid=id from Comment comment");
      //  	
       // 	
       // 		return (List<Champion>)query.getResultList();
       // 	
        	
    	//}
        
        //JDBC
        /*
        DataSource ds;
    	
    	public CommentDAO()
    	{
    	  try {
    		Context ctx = new InitialContext();
    		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/database-project");
    		System.out.println(ds);
    	  } catch (NamingException e) {
    		e.printStackTrace();
    	  }
    	}
    	
    	public Comment findByChampionid(int id)
    	{
    		Comment movie = new Comment();
    		
    		String sql = "select * from user where championid = ?";
    		try {
    			Connection connection = ds.getConnection();
    			PreparedStatement statement = connection.prepareStatement(sql);
    			statement.setInt(1, id);
    			ResultSet result = statement.executeQuery();
    			if(result.next())
    			{
    				user.setChampion(result.getInt("id"));
    				
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}		
    		return movie;
    	}
        //JDBC
 */
        public static void main(String[] args) {
                CommentDAO dao = new CommentDAO();
                dao.deleteComment(10);
              // Champion champion=new Champion(450,null,null,null,null,null);
               //Comment comment=new Comment(1,"WTF", champion);
              //Comment comment= dao.readChampionByChampionid(1);
                //Champion champion=new Champion(1,null,null,null,null,null);
                //List<Champion> comments=dao.readChampionByChampionid(champion);
                //for(Champion comment:comments)
                //{
                //System.out.println(comment.getId());
                //}
               
        }
}
