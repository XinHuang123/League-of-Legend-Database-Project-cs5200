package edu.neu.cs5200.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.models.*; 
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
       
 
        public static void main(String[] args) {
                CommentDAO dao = new CommentDAO();
               Champion champion=new Champion(450,null,null,null,null,null);
               Comment comment=new Comment(1,"WTF", champion);
                dao.createComment(comment);
                //List<Comment> comments=dao.readAllComments();
                //for(Comment comment:comments)
                //{
                System.out.println(comment.getContent());
                //}
               
        }
}
