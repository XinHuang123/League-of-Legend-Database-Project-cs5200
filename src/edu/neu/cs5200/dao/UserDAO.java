package edu.neu.cs5200.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.models.Champion;
import edu.neu.cs5200.models.User;


public class UserDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("LolDatabaseProject") ;
	EntityManager em = factory.createEntityManager();
	
	static UserDAO instance = null;
	public static UserDAO getInstance() {
		if(instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
public Boolean findUserByUsernamePassword(String username, String password) {
		
		try {
			User user = em.find(User.class, username);
			if (user.getPassword().equals(password)) {
				return true;
			}
			return false; 
		}
		catch (Exception e) {
			System.out.println("Invalid username");
		}
		
		return false;
}

public int findUserByRole(String username) {
	

		User user = em.find(User.class, username);
		if (user.getRole().equals("normal")) {
			return 1;
		}
		else if(user.getRole().equals("admin"))
		{
			return 2;
		}
		else
			{
			return 0;
			}
}

	
	//createUser
	public User createUser(User user)
	{
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	//readUserByUsername
	public User readUserByUsername(String username)
	{
		return em.find(User.class, username);
	}
	
	// readAllUsers
		public List<User> readAllUsers()
		{
			Query query = em.createQuery("select user from User user");
			return (List<User>)query.getResultList();
		}
		
		// updateUser
		public User UpdateUser(User user)
		{
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			return user;
		}
		// deleteChampion
		public void deleteUser(String username) {
			em.getTransaction().begin();
			User user = em.find(User.class, username);
			em.remove(user);
			em.getTransaction().commit();
		}

	public static void main(String[] args) {
		UserDAO dao=new UserDAO();
		User user=new User("XinHuang",null,null,null,null,null,null,null);
		User user1=new User("showing",null,null,null,null,null,null,user);
		dao.UpdateUser(user1);
		

	}
	
	

}
